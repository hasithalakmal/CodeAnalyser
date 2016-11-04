/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.metrix;

import com.codemage.datastuctures.CodeLevelBlockStructure;
import com.codemage.datastuctures.CodeLevelBlockStructureImpl;

/**
 *
 * @author Hasitha Lakmal
 */
public class SecondMetrix {

    private String code = "";
    CodeLevelBlockStructure clbs ;
    

    public SecondMetrix(String javaCode) {
        this.code = javaCode;
        this.clbs = new CodeLevelBlockStructureImpl(this.code);
    }

   public double getResult(){
        double res = clbs.getCodeBlock();
        return res;
   }

}
