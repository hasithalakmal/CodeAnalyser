package com.codemage.datastuctures;

import com.codemage.datastuctures.CodeLevelTreeStructureImpl;
import com.codemage.datastuctures.GenQueue;
import com.codemage.datastuctures.Node;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hasitha Lakmal
 */
public class MethodIdentifier {

    public void getMethodIndexes() {
        Student s = new Student();
        Class<? extends Student> cl = s.getClass();
        Method[] meth = cl.getMethods();
        Field[] feilds = cl.getDeclaredFields();
       

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        for (Method m : meth) {
            System.out.println(m.getName() + " ---- " );
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        for (Field f : feilds) {
            System.out.println(f.getName());
        }
    }

    public ArrayList getMethodIndexes(String code) {
        //stack and que
        Stack openIndex = new Stack();
        GenQueue<Integer> closeIndex = new GenQueue<Integer>();

        //read words
        String[] arr = code.split("\\s+");
        for (String ss : arr) {
            // System.out.println(ss);
        }

        //read indexces of given thing
        int initial_method_index = code.indexOf("{");

        //get all indexses of given value
        ArrayList al = new ArrayList();
        int current_index = -1;
        int new_index = 0;
        while (new_index != -1 && current_index != new_index) {
            current_index = new_index;
            new_index = code.indexOf("{", current_index + 1);
            al.add(new_index);
            openIndex.push(new_index);
        }
        openIndex.pop();

        //get all indexses of given value
        ArrayList al2 = new ArrayList();
        int current_index2 = -1;
        int new_index2 = 0;
        while (current_index2 != new_index2) {
            current_index2 = new_index2;
            new_index2 = code.indexOf("}", current_index2 + 1);
            al2.add(new_index2);
            if (new_index2 == -1) {
                break;
            }
            closeIndex.enqueue(new_index2);
        }
        //System.out.println(al2);
        closeIndex.printItems();

        //identify method initial index and end index
        ArrayList al3 = new ArrayList();
        int nodeid = 0;
        while (closeIndex.hasItems()) {
            nodeid++;
            Node n = new Node();

            int in = (int) openIndex.pop();
            int out = closeIndex.dequeue();
            System.out.println(in + "-----" + out);
            //fill node
            n.setNodeID(nodeid);
            n.setInIndex(in);
            n.setOutIndex(out);

            al3.add(n);
        }

        System.out.println(al3.toString());
        return al3;
    }

    public CodeLevelTreeStructure getCodeStructure(String code) {
        Stack openIndex = new Stack();
        CodeLevelTreeStructure ts = new CodeLevelTreeStructureImpl();

        int currentOpen = -1;
        int currentClose = -1;
        int in = 0;
        int out = 0;
        int nodeID = 1;
        while (currentOpen != in && in != -2) {
            currentOpen = in;
            in = code.indexOf("{", currentOpen + 1);

            out = code.indexOf("}", currentClose + 1);
            while (out < in || in == -1) {
                if (openIndex.empty()) {
                    in = -2;
                    break;
                }
                currentClose = out;
                Node n = new Node();
                n.setInIndex((int) openIndex.pop());
                n.setNodeID(nodeID);
                n.setOutIndex(out);
                n.setComplexityLevel(openIndex.size());

                if (n.getComplexityLevel() == 0) {
                    n.setType("class");
                } else if (n.getComplexityLevel() == 1) {
                    n.setType("method");
                } else {
                    String nodetype = this.getNodeType(code, n.getInIndex());
                    n.setType(nodetype);
                }
                String type = n.getType();
                switch (type) {
                    case "class":
                        n.setM2wc(1);
                        break;
                    case "method":
                         n.setM2wc(1);
                        break;
                    case "if":
                         n.setM2wc(2);
                        break;
                    case "else":
                        n.setM2wc(2);
                        break;
                    case "for":
                        n.setM2wc(3);
                        break;
                    case "while":
                        n.setM2wc(3);
                        break;
                    default:
                        n.setM2wc(0);
                        break;
                }

                ts.addNode(n);

                out = code.indexOf("}", currentClose + 1);
                nodeID++;
            }
            openIndex.push(in);
        }
        ts.resetHierarchy();
        return ts;
    }

    public String getNodeType(String code, int inIndex) {
        String newcode = code.substring(0, inIndex);
        String reverseString = new StringBuilder(newcode).reverse().toString().trim();

        String blockType = "";
        reverseString = reverseString.replace("}", " ").trim();
        reverseString = reverseString.replace(".", " ").trim();
        reverseString = reverseString.replace("\t", " ").trim();
        reverseString = reverseString.replace(";", " ").trim();
        reverseString = reverseString.replace("(", " ").trim();
        reverseString = reverseString.replace(")", " ").trim();
        reverseString = reverseString.replace("\"", " ").trim();
        reverseString = reverseString.replace("\'", " ").trim();

        int minindex = reverseString.length();
        int typeid = 0;
        //no paranthesis
        int x = reverseString.indexOf("fi");
        if (x < minindex && x != -1) {
            typeid = 1;
            minindex = x;
        }

        x = reverseString.indexOf("esle");
        if (x < minindex && x != -1) {
            typeid = 2;
            minindex = x;
        }

        x = reverseString.indexOf("rof");
        if (x < minindex && x != -1) {
            typeid = 3;
            minindex = x;
        }

        x = reverseString.indexOf("elihw");
        if (x < minindex && x != -1) {
            typeid = 4;
            minindex = x;
        }

        switch (typeid) {
            case 1:
                blockType = "if";
                break;
            case 2:
                blockType = "else";
                break;
            case 3:
                blockType = "for";
                break;
            case 4:
                blockType = "while";
                break;
            default:
                blockType = "notclear";
                break;
        }

        return blockType;

    }

}
