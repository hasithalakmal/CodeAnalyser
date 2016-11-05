package com.codemage.datastuctures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasitha Lakmal
 */
public class Node {
    
    private int nodeID;
    private int inIndex;
    private int outIndex;
    private int parentElement;
    private int complexityLevel;
    private String type;
    private String codeblock;
    private int m2wc = 0;
    private int m2wcreal =0;

    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
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

    public int getParentElement() {
        return parentElement;
    }

    public void setParentElement(int parentElement) {
        this.parentElement = parentElement;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(int complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodeblock() {
        return codeblock;
    }

    public void setCodeblock(String codeblock) {
        this.codeblock = codeblock;
    }

    public int getM2wc() {
        return m2wc;
    }

    public void setM2wc(int m2wc) {
        this.m2wc = m2wc;
    }

    public int getM2wcreal() {
        return m2wcreal;
    }

    public void setM2wcreal(int m2wcreal) {
        this.m2wcreal = m2wcreal;
    }

    @Override
    public String toString() {
        return "Node{" + "nodeID=" + nodeID + ", inIndex=" + inIndex + ", outIndex=" + outIndex + ", parentElement=" + parentElement + ", complexityLevel=" + complexityLevel + ", type=" + type + ", codeblock=" + codeblock + ", m2wc=" + m2wc + ", m2wcreal=" + m2wcreal + '}';
    }

    
    

   

   

    
    
    
}
