/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.metrix;

import com.codemage.datastuctures.CodeLevelTreeStructure;
import com.codemage.datastuctures.MethodIdentifier;
import com.codemage.datastuctures.CodeLine;
import com.codemage.datastuctures.Node;
import com.codemage.datastuctures.TokenCounter;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Hasitha Lakmal
 */
public class FirstMetrix {

    private String code = "";
    private TokenCounter wc = new TokenCounter();
    private MethodIdentifier mi = new MethodIdentifier();
    private HashMap tokenlistbyLine;
    private int TotalCharacters = 0;
    private int Totaltockens = 0;
    private int TotalLines = 0;
    private int totalValue =0;
    private String fileAnalyse = "";

    public FirstMetrix(String javaCode) {
        this.code = javaCode;
    }

    
    
    public void getLineValues() {
        tokenlistbyLine = wc.counter(code);
        this.setNodeValues(tokenlistbyLine);
        for (int i = 0; i < tokenlistbyLine.size(); i++) {
            CodeLine codeline = (CodeLine) tokenlistbyLine.get(i);
            Node node = codeline.getNode();
            int sj = codeline.getNumberOftokens();
            int wi = 1;
            int wn =0;
            if(node.getComplexityLevel() == 0){
                wn= node.getComplexityLevel();
            }else{
                wn= node.getComplexityLevel()-1;
            }
            
            int wc = codeline.getTypeValue();
            int inindex = codeline.getInIndex();
            int outindex = codeline.getOutIndex();

            int linevalue = (wi + wn + wc) * sj;

            totalValue += linevalue;
            String lineString = code.substring(inindex, outindex) + "      // " + sj + "*(" + wi + "+" + wn + "+" + wc + ") = " + linevalue+"\n";
            fileAnalyse += lineString;
        }
        TotalCharacters = wc.getCrunchifyTotalCharacters();
        Totaltockens = wc.getCrunchifyTotalWords();
        TotalLines = wc.getCrunchifyTotalLines();
    }

    public void setNodeValues(HashMap Lines) {
        CodeLevelTreeStructure nodestructure = mi.getCodeStructure(code);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalCharacters() {
        return TotalCharacters;
    }

    public void setTotalCharacters(int TotalCharacters) {
        this.TotalCharacters = TotalCharacters;
    }

    public int getTotaltockens() {
        return Totaltockens;
    }

    public void setTotaltockens(int Totaltockens) {
        this.Totaltockens = Totaltockens;
    }

    public int getTotalLines() {
        return TotalLines;
    }

    public void setTotalLines(int TotalLines) {
        this.TotalLines = TotalLines;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public String getFileAnalyse() {
        return fileAnalyse;
    }

    public void setFileAnalyse(String fileAnalyse) {
        this.fileAnalyse = fileAnalyse;
    }

    public TokenCounter getWc() {
        return wc;
    }

    public void setWc(TokenCounter wc) {
        this.wc = wc;
    }

    public MethodIdentifier getMi() {
        return mi;
    }

    public void setMi(MethodIdentifier mi) {
        this.mi = mi;
    }

    public HashMap getTokenlistbyLine() {
        return tokenlistbyLine;
    }

    public void setTokenlistbyLine(HashMap tokenlistbyLine) {
        this.tokenlistbyLine = tokenlistbyLine;
    }

    
}
