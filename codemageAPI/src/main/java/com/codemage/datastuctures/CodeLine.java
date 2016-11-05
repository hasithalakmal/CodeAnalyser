/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.datastuctures;

/**
 *
 * @author Hasitha Lakmal
 */
public class CodeLine {
    
    private int lineNumber;
    private int inIndex;
    private int outIndex;
    private Node node;
    private int typeValue;
    private int numberOftokens;
    private String codeline;
    private String codelinetokens;
    

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getInIndex() {
        return inIndex;
    }

    public void setInIndex(int inIndex) {
        this.inIndex = inIndex;
    }

    public int getOutIndex() {
        return outIndex;
    }

    public void setOutIndex(int outIndex) {
        this.outIndex = outIndex;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(int typeValue) {
        this.typeValue = typeValue;
    }

    public int getNumberOftokens() {
        return numberOftokens;
    }

    public void setNumberOftokens(int numberOftokens) {
        this.numberOftokens = numberOftokens;
    }

    public String getCodeline() {
        return codeline;
    }

    public void setCodeline(String codeline) {
        this.codeline = codeline;
    }

    public String getCodelinetokens() {
        return codelinetokens;
    }

    public void setCodelinetokens(String codelinetokens) {
        this.codelinetokens = codelinetokens;
    }

    @Override
    public String toString() {
        return "CodeLine{" + "lineNumber=" + lineNumber + ", inIndex=" + inIndex + ", outIndex=" + outIndex + ", node=" + node + ", typeValue=" + typeValue + ", numberOftokens=" + numberOftokens + ", codeline=" + codeline + ", codelinetokens=" + codelinetokens + '}';
    }

    

    
    
    
}
