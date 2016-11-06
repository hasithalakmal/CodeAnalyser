/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.sql.controller;

import com.codemage.sql.service.AnalyserService;
import com.codemage.sql.util.JsonStringGenarator;
import com.codemage.sql.util.MyFileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        String newcode = jsonStringGenarator.javaToJSON(javaCode);

        String hdd = "public class SampleCode4 {\n"
                + "    public void checkCC(String x) {\n"
                + "        System.out.println(x);\n"
                + "        if (\"a\".equals(x)) {\n"
                + "            if (x.length() == 5) {\n"
                + "                System.out.println(x);\n"
                + "            } else {\n"
                + "                System.out.println(x);\n"
                + "            }\n"
                + "        } else if (\"b\".equals(x)) {\n"
                + "            System.out.println(x);\n"
                + "        } else {\n"
                + "            System.out.println(x);\n"
                + "        }       \n"
                + "        System.out.println(\"jjjjj\"); \n"
                + "        for (int i = 0; i < 10; i++) {\n"
                + "            System.out.println(i);\n"
                + "        }\n"
                + "    }\n"
                + "}";
        String result = analyserService.getAnalysereport(newcode);
        System.out.println("working 2");
        // result = "{\"msg\":\"success\",\"err\":\"false\",\"result\":\"" + result+ "\"}";
        //result =jsonStringGenarator.javaToJSON(result);
        System.out.println("working 3");
        System.out.println(result);
        return result;
    }

}
