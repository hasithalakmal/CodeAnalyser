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
public class TokenCounter {

    private int crunchifyTotalWords = 0;
    private int crunchifyTotalLines = 0;
    private int crunchifyTotalCharacters = 0;
    HashMap tokenList = new HashMap();

    public HashMap counter(String javaCode) {

        int lineinindex = 0;

        String[] lines = javaCode.split("\r\n|\r|\n");

        // read each line one by one
        for (int i = 0; i < lines.length; i++) {
            CodeLine codeline = new CodeLine();

            String newString = lines[i].replace("{", " ").trim();

            newString = newString.replace("}", " ");
            newString = newString.replace("(", " ");
            newString = newString.replace(")", " ");
            newString = newString.replace(".", " ");
            newString = newString.replace("\t", " ");
            newString = newString.replace(";", " ");
            newString = newString.replace("\"", " ");
            newString = newString.replace("\'", " ").trim();

            
            crunchifyTotalLines++;

            // ignore multiple white spaces
            String[] myWords = newString.replaceAll("\\s+", " ").split(" ");
            
            for (String s : myWords) {
                crunchifyTotalCharacters += s.length();
               // System.out.print(s + " ");
            }
           // System.out.println("");

            crunchifyTotalWords += myWords.length;

            codeline.setLineNumber(i + 1);
            codeline.setInIndex(lineinindex);
            codeline.setCodeline(lines[i]);
            codeline.setCodelinetokens(newString);
            lineinindex = lineinindex + lines[i].length();
            codeline.setOutIndex(lineinindex);
            lineinindex++;
            if(newString != null && newString.length() == 0){
                codeline.setNumberOftokens(0);
            }else{
                codeline.setNumberOftokens(myWords.length);
            }
            

            tokenList.put(i, codeline);

        }

        return tokenList;
    }

    public String printStringRemover(String javaCode) {
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
                out.add(stringEndIndex + 1);

            }

            for (int i = 0; i < in.size(); i++) {
                int inIndex = (int) in.get((in.size() - 1) - i);
                int outIndex = (int) out.get((out.size() - 1) - i);

                String removeablePart = javaCode.substring(inIndex, outIndex);
                javaCode = javaCode.replace(removeablePart, "");
            }

            in.clear();
            out.clear();

        }

        return javaCode;
    }

    public void inoutIndexes(String javaCode) {
        HashMap linelist = new HashMap();

        String[] lines = javaCode.split("\r\n|\r|\n");
    }

    public int getCrunchifyTotalWords() {
        return crunchifyTotalWords;
    }

    public void setCrunchifyTotalWords(int crunchifyTotalWords) {
        this.crunchifyTotalWords = crunchifyTotalWords;
    }

    public int getCrunchifyTotalLines() {
        return crunchifyTotalLines;
    }

    public void setCrunchifyTotalLines(int crunchifyTotalLines) {
        this.crunchifyTotalLines = crunchifyTotalLines;
    }

    public int getCrunchifyTotalCharacters() {
        return crunchifyTotalCharacters;
    }

    public void setCrunchifyTotalCharacters(int crunchifyTotalCharacters) {
        this.crunchifyTotalCharacters = crunchifyTotalCharacters;
    }

}
