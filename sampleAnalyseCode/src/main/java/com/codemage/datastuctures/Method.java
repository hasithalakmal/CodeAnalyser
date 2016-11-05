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
public class Method {
    
    private int methID;
    private String methName;
    private int numberOfElementIO;
    private int numberOf1dIO;
    private int numberOfmdIO;
    private int maxCallingDistence;
    private int callingModuleWeight;
    private String methCodeline;
    private int lineNum;
    
    public int getMethID() {
        return methID;
    }

    public void setMethID(int methID) {
        this.methID = methID;
    }

   
    public int getNumberOfElementIO() {
        return numberOfElementIO;
    }

    public void setNumberOfElementIO(int numberOfElementIO) {
        this.numberOfElementIO = numberOfElementIO;
    }

    public int getNumberOf1dIO() {
        return numberOf1dIO;
    }

    public void setNumberOf1dIO(int numberOf1dIO) {
        this.numberOf1dIO = numberOf1dIO;
    }

    public int getNumberOfmdIO() {
        return numberOfmdIO;
    }

    public void setNumberOfmdIO(int numberOfmdIO) {
        this.numberOfmdIO = numberOfmdIO;
    }

    public int getMaxCallingDistence() {
        return maxCallingDistence;
    }

    public void setMaxCallingDistence(int maxCallingDistence) {
        this.maxCallingDistence = maxCallingDistence;
    }

    public int getCallingModuleWeight() {
        return callingModuleWeight;
    }

    public void setCallingModuleWeight(int callingModuleWeight) {
        this.callingModuleWeight = callingModuleWeight;
    }


    public String getMethCodeline() {
        return methCodeline;
    }

    public void setMethCodeline(String methCodeline) {
        this.methCodeline = methCodeline;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName = methName;
    }

    @Override
    public String toString() {
        return "Method{" + "methID=" + methID + ", methName=" + methName + ", numberOfElementIO=" + numberOfElementIO + ", numberOf1dIO=" + numberOf1dIO + ", numberOfmdIO=" + numberOfmdIO + ", maxCallingDistence=" + maxCallingDistence + ", callingModuleWeight=" + callingModuleWeight + ", methCodeline=" + methCodeline + '}';
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }
    
    
    
    
    
}
