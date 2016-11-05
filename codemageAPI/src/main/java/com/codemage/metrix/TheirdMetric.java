/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.metrix;

import com.codemage.datastuctures.CodeLevelTreeStructure;
import com.codemage.datastuctures.CodeLine;
import com.codemage.datastuctures.Method;
import com.codemage.datastuctures.MethodIdentifier;
import com.codemage.datastuctures.Node;
import com.codemage.datastuctures.TokenCounter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hasitha Lakmal
 */
public class TheirdMetric {

    String code;
    TokenCounter wc = new TokenCounter();
    MethodIdentifier mi = new MethodIdentifier();
    HashMap tokenlistbyLine;
    HashMap lineDetails;
    HashMap methLines = new HashMap();
    CodeLevelTreeStructure nodestructure;
    int element;
    int oneD;
    int mulD;
    String[] datatypes = {"int", "String", "float", "double", "char"};
    ArrayList methName = new ArrayList();
    HashMap methCall = new HashMap();
    FirstMetrix fm;

    public TheirdMetric(String javacode) {
        this.code = javacode;

    }

    public int getResult() {

        nodestructure = mi.getCodeStructure(code);
        tokenlistbyLine = wc.counter(code);
        this.setNodeValues(tokenlistbyLine);
//        for (int i = 0; i < tokenlistbyLine.size(); i++) {
//            System.out.println(tokenlistbyLine.get(i));
//        }

        int methIdcounter = 0;
        //get method lines
        LinkedList<Node> nodelist = nodestructure.getElements(1);
        for (Node node : nodelist) {
            int nodeinindex = node.getInIndex();
            int nodeoutindex = node.getOutIndex();
            boolean flag = false;
            for (int j = 0; j < tokenlistbyLine.size(); j++) {
                CodeLine codeline = (CodeLine) tokenlistbyLine.get(j);
                int linein = codeline.getInIndex();
                int lineout = codeline.getOutIndex();
                if ((linein <= nodeinindex && nodeinindex <= lineout)) {
                    flag = true;
                    String methLine = codeline.getCodeline().trim();
                    Method meth = new Method();
                    meth.setMethCodeline(methLine);
                    meth.setMethID(methIdcounter);
                    this.numberofIO(methLine);
                    meth.setNumberOfElementIO(this.element);
                    meth.setNumberOf1dIO(this.oneD);
                    meth.setNumberOfmdIO(this.mulD);
                    String methName = getMethName(methLine);
                    meth.setMethName(methName);
                    meth.setLineNum(codeline.getLineNumber());

                    methLines.put(methIdcounter, meth);

                    methIdcounter++;
                }

                if (flag) {

                }

                if ((linein <= nodeoutindex && nodeoutindex <= lineout)) {
                    flag = false;
                }
            }

        }

        this.getDistence();
        System.out.println("----------------------------------------------");
        for (int i = 0; i < methLines.size(); i++) {
            int lineType = 0;
            Method meth = (Method) methLines.get(i);
            int inIndex = meth.getLineNum();
            Object callLine = methCall.get(meth.getMethName());
            int dis = 0;
            if (callLine == null) {
                dis = 0;
                lineType =0;
            } else {
                int line = (int) callLine;
                dis = Math.abs((inIndex - line));
                CodeLine linedetail = (CodeLine) tokenlistbyLine.get(line);
                Node nodedetail = linedetail.getNode();
                String levelType = nodedetail.getType();

                switch (levelType) {
                    case "class":
                        lineType =0;
                        break;
                    case "method":
                        lineType = 1;
                        break;
                    case "if":
                        lineType = 2;
                        break;
                    case "else":
                        lineType =2;
                        break;
                    case "for":
                        lineType = 3;
                        break;
                    case "while":
                        lineType = 3;
                        break;
                    default:
                        lineType =0;
                        break;
                }
            }
            meth.setMaxCallingDistence(dis);

            meth.setCallingModuleWeight(lineType);
            String object = (String) methLines.get(i).toString();
            System.out.println(object);
        }

        //System.out.println(methCall.toString());
        int res = this.finalResult();
        return res;

    }

    public void numberofIO(String cl) {
        element = 0;
        oneD = 0;
        mulD = 0;
        int totalIO = 0;

        //get total IO
        for (String datatype : datatypes) {
            String pattern = "\\b" + datatype + "\\b";
            int count = 0;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(cl);
            while (m.find()) {
                count++;
            }
            totalIO += count;

        }

        //get mulD
        String str = cl;
        String findStr = "[][]";
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        mulD = count;

//        String pattern = "\\b\\[\\]\\[\\]\\b";
//        int count = 0;
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(cl);
//        while (m.find()) {
//            count++;
//        }
//        mulD = count;
        //get oneD
        str = cl;
        findStr = "[]";
        lastIndex = 0;
        count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        oneD = count - (mulD * 2);
//        pattern = "\\b\\[\\]\\b";
//        count = 0;
//        p = Pattern.compile(pattern);
//        m = p.matcher(cl);
//        while (m.find()) {
//            count++;
//        }
//        oneD = count;
        //get elements
        element = totalIO - (mulD + oneD);

       //
       
       
       
       
       
       
       
       System.out.println(cl + " // totalIO = " + totalIO + "  element= " + element + " oneD = " + oneD + " mulD = " + mulD);

    }

    public String getMethName(String cl) {
        String meth = "";

        int methIndex = cl.indexOf("(");
        String methNamepart = cl.substring(0, methIndex);
        String revString = new StringBuilder(methNamepart).reverse().toString().trim();
        meth = revString.split(" ")[0];
        meth = new StringBuilder(meth).reverse().toString().trim();

        methName.add(meth);
        return meth;
    }

    public int getDistence() {
        int dis = 0;

        int methIdcounter = 0;
        //get method lines
        LinkedList<Node> nodelist = nodestructure.getElements(1);
        for (Node node : nodelist) {
            int nodeinindex = node.getInIndex();
            int nodeoutindex = node.getOutIndex();
            boolean flag = false;
            boolean flag2 = false;
            int counter = 0;
            for (int j = 0; j < tokenlistbyLine.size(); j++) {
                CodeLine codeline = (CodeLine) tokenlistbyLine.get(j);
                int linein = codeline.getInIndex();
                int lineout = codeline.getOutIndex();
                if ((linein <= nodeinindex && nodeinindex <= lineout)) {
                    flag = true;
                }

                if (flag) {
                    if (flag2) {
                        for (int i = 0; i < methName.size(); i++) {

                            String pattern = "\\b" + methName.get(i) + "\\b";
                            int count = 0;
                            Pattern p = Pattern.compile(pattern);
                            Matcher m = p.matcher(codeline.getCodeline());
                            if (m.find()) {
                                methCall.put(methName.get(i), codeline.getLineNumber());
                            }
                        }
                    }
                    flag2 = true;
                }

                if ((linein <= nodeoutindex && nodeoutindex <= lineout)) {
                    flag = false;
                    flag2 = false;
                }
            }

        }

        return dis;
    }

    public void setNodeValues(HashMap Lines) {
        // CodeLevelTreeStructure nodestructure = mi.getCodeStructure(code);
        //nodestructure.print();
        int depth = nodestructure.getMaxDepth();
        for (int i = 0; i <= depth; i++) {
            LinkedList<Node> nodelist = nodestructure.getElements(i);
            for (Node node : nodelist) {
                int nodeinindex = node.getInIndex();
                int nodeoutindex = node.getOutIndex();
                boolean flag = false;
                for (int j = 0; j < tokenlistbyLine.size(); j++) {
                    CodeLine codeline = (CodeLine) tokenlistbyLine.get(j);
                    int linein = codeline.getInIndex();
                    int lineout = codeline.getOutIndex();
                    if ((linein <= nodeinindex && nodeinindex <= lineout)) {
                        flag = true;
                    }

                    if (flag) {
                        codeline.setNode(node);
                        String type = node.getType();
                        switch (type) {
                            case "class":
                                codeline.setTypeValue(0);
                                break;
                            case "method":
                                codeline.setTypeValue(0);
                                break;
                            case "if":
                                codeline.setTypeValue(1);
                                break;
                            case "else":
                                codeline.setTypeValue(1);
                                break;
                            case "for":
                                codeline.setTypeValue(2);
                                break;
                            case "while":
                                codeline.setTypeValue(2);
                                break;
                            default:
                                codeline.setTypeValue(0);
                                break;
                        }

                        tokenlistbyLine.remove(j);
                        tokenlistbyLine.put(j, codeline);

                    }

                    if ((linein <= nodeoutindex && nodeoutindex <= lineout)) {
                        flag = false;
                    }
                }

            }
        }

    }
    
    public int finalResult(){
        int res =0;
       for (int i = 0; i < methLines.size(); i++) {
           Method meth = (Method) methLines.get(i);
           int mw = meth.getCallingModuleWeight();
           int dis = meth.getMaxCallingDistence();
           int d1io = meth.getNumberOf1dIO();
           int dmio = meth.getNumberOf1dIO();
           int eio = meth.getNumberOf1dIO();
           
           res = res + (mw*dis+((1*eio)+(2*d1io)+(3*dmio)));
       }
        return res;
    }
}
