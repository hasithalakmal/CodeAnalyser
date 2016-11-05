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
public class Block {
    
    private int id;
    private String code;
    private int wc;
    private int nop;
    private int ndop;
    private int nvar;
    private int ndvar;
    private double result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getWc() {
        return wc;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public int getNdop() {
        return ndop;
    }

    public void setNdop(int ndop) {
        this.ndop = ndop;
    }

    public int getNvar() {
        return nvar;
    }

    public void setNvar(int nvar) {
        this.nvar = nvar;
    }

    public int getNdvar() {
        return ndvar;
    }

    public void setNdvar(int ndvar) {
        this.ndvar = ndvar;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Block{" + "id=" + id + ", code=" + code + ", wc=" + wc + ", nop=" + nop + ", ndop=" + ndop + ", nvar=" + nvar + ", ndvar=" + ndvar + ", result=" + result + '}';
    }

    
    
    
}
