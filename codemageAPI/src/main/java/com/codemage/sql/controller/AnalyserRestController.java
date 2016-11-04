/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.sql.controller;

import com.codemage.sql.service.AnalyserService;
import com.codemage.sql.util.JsonStringGenarator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hasitha Lakmal
 */
@RestController
@Component
public class AnalyserRestController {

    @Autowired
    JsonStringGenarator jsonStringGenarator;
    
    @Autowired
    AnalyserService analyserService;
 
    @RequestMapping(value = "analyse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String analyseJavaCode(@RequestBody String javaCodeJSON) {
        JSONObject jsonObj = new JSONObject(javaCodeJSON);
        String javaCode = jsonObj.getString("java_code");
        System.out.println("working 1");
        String result = analyserService.getAnalysereport(javaCode);
        System.out.println("working 2");
       // result = "{\"msg\":\"success\",\"err\":\"false\",\"result\":\"" + result+ "\"}";
        //result =jsonStringGenarator.javaToJSON(result);
        System.out.println("working 3");
        System.out.println(result);
        return result;
    }
    
   
}
