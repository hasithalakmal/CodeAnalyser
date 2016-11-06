/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.datastuctures;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import javax.lang.model.element.Element;

/**
 *
 * @author Hasitha Lakmal
 */
public class CodeLevelBlockStructureImpl implements CodeLevelBlockStructure {

    private String code = "";
    TokenCounter wc = new TokenCounter();
    MethodIdentifier mi = new MethodIdentifier();
    HashMap tokenlistbyLine;
    CodeLevelTreeStructure nodestructure;

    int distinctOperators = 0;
    int allOperators = 0;

    int distinctVariables = 0;
    int allVariables = 0;

    String[] operators = {"+", "-", "*", "/", "="};
    String[] datatypes = {"int ", "String", "float", "double", "char"};
    ArrayList variables = new ArrayList();
    ArrayList blockArray = new ArrayList();

    public CodeLevelBlockStructureImpl(String javaCode) {
        this.code = javaCode;
        //get all variables
        this.getAllVariables();

    }

    @Override
    public double getCodeBlock() {

        nodestructure = mi.getCodeStructure(code);
        tokenlistbyLine = wc.counter(code);
        //nodestructure.print();
        int depth = nodestructure.getMaxDepth();
        for (int i = depth; i > 2; i--) {
            LinkedList<Node> nodelist = nodestructure.getElements(i);
            for (Node node : nodelist) {

                int m2wc = node.getM2wc();

                int parentid = node.getParentElement();
                Node parentElement = nodestructure.getElement(parentid);
                int m2wcParent = parentElement.getM2wc();
                int m2wcParentreal = parentElement.getM2wcreal();

                int newparentn2wc = m2wcParentreal + (m2wcParent * m2wc);
                parentElement.setM2wcreal(newparentn2wc);

            }
        }

        for (int i = 0; i <= depth; i++) {
            LinkedList<Node> nodelist = nodestructure.getElements(i);
            for (Node node : nodelist) {
                int nodeinindex = node.getInIndex();
                int nodeoutindex = node.getOutIndex();
                boolean flag = false;

                int codeblockInIndex = 0;
                int codeblockOutIndex = 0;

                for (int j = 0; j < tokenlistbyLine.size(); j++) {
                    CodeLine codeline = (CodeLine) tokenlistbyLine.get(j);
                    int linein = codeline.getInIndex();
                    int lineout = codeline.getOutIndex();
                    if ((linein <= nodeinindex && nodeinindex <= lineout)) {
                        flag = true;
                        codeblockInIndex = linein;
                    }

                    if (flag) {

                    }

                    if ((linein <= nodeoutindex && nodeoutindex <= lineout)) {
                        flag = false;
                        codeblockOutIndex = lineout;
                    }
                }

                node.setCodeblock(code.substring(codeblockInIndex, codeblockOutIndex));

                int m2wc = node.getM2wc();
                int m2wcr = node.getM2wcreal();
                if (m2wcr == 0) {
                    node.setM2wcreal(m2wc);
                }
            }
        }

        int blockid = 0;
        LinkedList<Node> nodelist = nodestructure.getElements(2);
        for (Node node : nodelist) {
            Block block = new Block();
            block.setId(blockid);

            //refine the code block
            String basiccodeblock = node.getCodeblock();
            String refineCodeBlock = "";
            int actualcodeblockInIndex = 0;

            int openIndex = basiccodeblock.indexOf("{");
            String firstpart = basiccodeblock.substring(0, openIndex + 1);
            int startIndex = firstpart.indexOf("}");
            if (startIndex != -1 && openIndex > startIndex) {
                actualcodeblockInIndex = startIndex + 1;
            }

            String lastpart = new StringBuilder(basiccodeblock).reverse().toString().trim();
            int closeIndex = lastpart.indexOf("}");
            int actualcodeblockOutIndex = basiccodeblock.length() - closeIndex;

            refineCodeBlock = basiccodeblock.substring(actualcodeblockInIndex, actualcodeblockOutIndex);

            this.getAllOperators(refineCodeBlock);

            this.getBlockVariables(refineCodeBlock);
            node.setCodeblock(refineCodeBlock);

            block.setCode(refineCodeBlock);
            block.setNop(allOperators);
            block.setNdop(distinctOperators);
            block.setWc(node.getM2wcreal());
            block.setNvar(allVariables);
            block.setNdvar(distinctVariables);
            blockid++;
            blockArray.add(block);
        }

        String level1code = code;

        for (int i = 0; i < blockArray.size(); i++) {
            Block block = (Block) blockArray.get(i);
            String blockcode = block.getCode().trim();
            level1code = level1code.replace(blockcode, "");
        }

        Block block = new Block();
        this.getAllOperators(level1code);
        this.getBlockVariables(level1code);
        block.setId(blockid);
        block.setCode(level1code);
        block.setNop(allOperators);
        block.setNdop(distinctOperators);
        block.setNvar(allVariables);
        block.setNdvar(distinctVariables);
        block.setWc(1);
        blockid++;
        blockArray.add(block);

        double res = this.calculateValue();
        return res;

    }

    public void getAllOperators(String codeBlock) {
        allOperators = 0;
        distinctOperators = 0;
        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            String str = codeBlock;
            String findStr = operator;
            int lastIndex = 0;
            int count = 0;

            while (lastIndex != -1) {

                lastIndex = str.indexOf(findStr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findStr.length();
                }
            }
            allOperators += count;
            if (count > 0) {
                distinctOperators++;
            }
        }
    }

    public void getAllVariables() {

        String[] lines = code.split("\r\n|\r|\n");
        System.out.println(code);
        for (String line : lines) {
            String newString = line;
            for (String datatype : datatypes) {
                //will have variable
                if (newString.contains(datatype)) {
                    String s = newString;
                    //should have variable
                    if (newString.contains(";")) {
                        String pattern = "\\b" + datatype + "\\b";
                        System.out.println("************************** " + pattern);
                        int count = 0;
                        Pattern p = Pattern.compile(pattern);
                        Matcher m = p.matcher(newString);
                        while (m.find()) {
                            count++;
                            System.out.print("Start index: " + m.start());
                            System.out.print(" End index: " + m.end());
                            System.out.println(" Found: " + m.group());
                            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                            int datataypeindex = s.indexOf(datatype);
                            s = s.substring(m.start());
                            System.out.println("++++++++++++++++++++++++++++++++" + s);
                            String[] parameterlist = s.split(";");
                            for (int i = 0; i < parameterlist.length; i++) {
                                String codepart = parameterlist[i] + ";";
                                if (codepart.contains(datatype)) {
                                    s = codepart;
                                    s = s.replaceAll(datatype, "");
                                    s = s.replaceAll("=.*?,", "");
                                    s = s.replaceAll("=.*?;", "");
                                    s = s.replaceAll("[.*?]", "");
                                    s = s.replaceAll(",", "");
                                    s = s.replaceAll("\\[", "").replaceAll("\\]", "");
                                    s = s.replaceAll(";", "");
                                    s = s.replaceAll("\\[", "").replaceAll("\\]", "");

                                    System.out.println("-------------------------------------" + s);
                                    //remove white space & set distinct variables into array
                                    String[] strs = s.trim().split("[\\s']", -1);
                                    ArrayList<String> al = new ArrayList<>(Arrays.asList(strs));
                                    al.removeAll(Arrays.asList(null, ""));
                                    for (int j = 0; j < al.size(); j++) {
                                        variables.add(al.get(j));
                                        // System.out.println("variale = " + al.get(j));
                                    }
                                }

                            }
                        }

                    } else {// will have variable
                        int inIndex = s.indexOf("(");
                        int outIndex = s.indexOf(")");
                        s = s.substring(inIndex + 1, outIndex);
                        s = s.replaceAll("[.*?]", "");
                        s = s.replaceAll("\\[", "");
                        s = s.replaceAll("\\]", "");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+ s);
                        String[] parameterlist = s.split(",");
                        for (int i = 0; i < parameterlist.length; i++) {
                            String variable = parameterlist[i];

                            String pattern = "\\b" + datatype + "\\b";
                            System.out.println("************************** " + pattern);
                            int count = 0;
                            Pattern p = Pattern.compile(pattern);
                            Matcher m = p.matcher(variable);
                            System.out.println("%%%%%%%%%%%%%%%%%%%%%% "+ variable);
                            while (m.find()) {
                                count++;
                                System.out.print("Start index: " + m.start());
                                System.out.print(" End index: " + m.end());
                                System.out.println(" Found: " + m.group());
                                variable = s.substring(m.start(), m.end());
                                variables.add(variable);
                            }

//                            if (m.find()) {
//                                variable = variable.replace(datatype, "").trim();
//                                variables.add(variable);
//                            }
                        }
                    }
                }
            }
        }

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (int i = 0; i < variables.size(); i++) {
            String var = (String) variables.get(i);
            System.out.println(var);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n\n");
    }

    public void getBlockVariables(String codeBlock) {
        allVariables = 0;
        distinctVariables = 0;

        for (int i = 0; i < variables.size(); i++) {
            String variable = (String) variables.get(i);
            String pattern = "\\b" + variable + "\\b";
            System.out.println("************************** " + pattern);
            int count = 0;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(codeBlock);
            while (m.find()) {
                count++;
            }

            /* String var = " " + variable;
            String x = codeBlock.replaceAll("\\(", " ");
            String str = x;
            String findStr = var;
            int lastIndex = 0;
            int count = 0;

            while (lastIndex != -1) {

                lastIndex = str.indexOf(findStr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findStr.length();
                }
            }*/
            allVariables += count;
            if (count > 0) {
                distinctVariables++;
            }
        }
    }

    public double calculateValue() {
        double totalValue = 0;

        for (int i = 0; i < blockArray.size(); i++) {
            Block block1 = (Block) blockArray.get(i);
            String blockcode = block1.getCode().trim();
            int ndop = block1.getNdop();
            int nop = block1.getNop();
            int ndv = block1.getNdvar();
            int nv = block1.getNvar();
            int wc = block1.getWc();
            int N = nop + nv;
            int n = ndop + ndv;
            System.out.println(blockcode);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(" Number of diferent operators = " + block1.getNdop());
            System.out.println(" Number of  operators = " + block1.getNop());
            System.out.println(" Number of diferent variables = " + block1.getNdvar());
            System.out.println(" Number of  variables = " + block1.getNvar());
            System.out.println(" WC = " + block1.getWc());
            System.out.println("------------------------------------------------------");
            double blockvalue = (((Math.sqrt(Math.log(n + 1) * N)) + 1) * wc);
            System.out.println("Block Value = " + blockvalue);
            System.out.println("\n\n\n");
            totalValue += blockvalue;
        }

        System.out.println("Final metrix Value = " + totalValue);
        return totalValue;

    }

//    public static void main(String[] args) {
//        String text = "I will come and meet you at the woods; \"woods\" and all the woods11";
//        String pattern = "\\b" + "woods" + "\\b";
//
//        int i = 0;
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(text);
//        while (m.find()) {
//            i++;
//        }
//        System.out.println(i);
//
////         String pattern = "\\b"+"woods"+"\\b";
////         Pattern p=Pattern.compile(pattern);
////         Matcher m=p.matcher(text);
////         m.find();
////        
////        System.out.println();
//    }
//    public static void main(String[] args) {
//        String s = "public int get (int x, String y, int z) {";
//        s = "for (int i = 0; i < parameterlist.length; i++) {";
//        s = "public int x, y ;";
//        s = "public int x= 5, y, z=2;";
//        int datataypeindex = s.indexOf("int");
//        s = s.substring(datataypeindex);
//
//        String[] parameterlist = s.split(";");
//        for (int i = 0; i < parameterlist.length; i++) {
//            String codepart = parameterlist[i] + ";";
//            if (codepart.contains("int ")) {
//                s = codepart;
//                s = s.replaceAll("int", "");
//                s = s.replaceAll("=.*?,", "");
//                s = s.replaceAll("=.*?;", "");
//                s = s.replaceAll(",", "");
//                s = s.replaceAll(";", "");
//
//                //remove white space & set distinct variables into array
//                String[] strs = s.trim().split("[\\s']", -1);
//                ArrayList<String> al = new ArrayList<>(Arrays.asList(strs));
//                al.removeAll(Arrays.asList(null, ""));
////                for (int j = 0; j < al.size(); j++) {
////                    System.out.println("variale = " + al.get(j));
////                }
//            }
//
//        }
//
//    }
}
