/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.datastuctures;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Hasitha Lakmal
 */
public class TokenCounter1 {

    public void counter(String javaCode) {

        int crunchifyTotalWords = 0;
        int crunchifyTotalLines = 0;
        int crunchifyTotalCharacters = 0;
        HashMap tokenList = new HashMap();

        String[] lines = javaCode.split("\r\n|\r|\n");

        System.out.println("========== File Content ==========");

        // read each line one by one
        for (int i = 0; i < lines.length; i++) {
            String newString = lines[i].replace("{", " ").trim();
            newString = newString.replace("}", " ");
            newString = newString.replace("(", " ");
            newString = newString.replace(")", " ");
            newString = newString.replace(".", " ");
            newString = newString.replace("\t", " ");
            newString = newString.replace(";", " ");
            newString = newString.replace("\"", " ");
            newString = newString.replace("\'", " ");

            //newString = newString.trim();
            System.out.println(lines[i]);
            //System.out.println(newString);
            crunchifyTotalLines++;

            // ignore multiple white spaces
            String[] myWords = newString.replaceAll("\\s+", " ").split(" ");

            for (String s : myWords) {
                crunchifyTotalCharacters += s.length();
            }

            crunchifyTotalWords += myWords.length;

            tokenList.put(i, myWords.length);

        }

        System.out.println("\n========== Result ==========");

        System.out.println("* Total Characters: " + crunchifyTotalCharacters);
        System.out.println("* Total Words: " + crunchifyTotalWords);
        System.out.println("* Toal Lines: " + crunchifyTotalLines);
        System.out.println(tokenList.toString());

    }

    public String printStringRemover(String javaCode) {
        System.out.println(javaCode);
        String[] targetString = {"System.out.println", "System.err.println"};
        for (String targetString1 : targetString) {
            int currentIndex = -1;
            int new_index = 0;
            int stringStartIndex = 0;
            int stringEndIndex = 0;
            ArrayList in = new ArrayList();
            ArrayList out = new ArrayList();

            while (new_index != -1 && currentIndex != new_index) {
                currentIndex = new_index;
                new_index = javaCode.indexOf(targetString1, currentIndex + 1);
                if (new_index == -1) {
                    break;
                }

                stringStartIndex = javaCode.indexOf("\"", new_index);
                stringEndIndex = javaCode.indexOf("\"", stringStartIndex + 1);
                in.add(stringStartIndex);
                out.add(stringEndIndex+1);

            }

            for (int i = 0; i < in.size(); i++) {
                int inIndex = (int) in.get((in.size() - 1) - i);
                int outIndex = (int) out.get((out.size() - 1) - i);

                String removeablePart = javaCode.substring(inIndex, outIndex);
                System.out.println(removeablePart);
                javaCode = javaCode.replace(removeablePart, "");
            }

            in.clear();
            out.clear();

        }

        System.out.println(javaCode);
        return javaCode;
    }

}
