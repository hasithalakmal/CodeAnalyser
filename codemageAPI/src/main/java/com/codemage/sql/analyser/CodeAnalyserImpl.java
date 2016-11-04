package com.codemage.sql.analyser;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hasitha Lakmal
 */
@Service("codeAnalyser")
@Transactional
public class CodeAnalyserImpl implements CodeAnalyser {

    @Override
    public String getCyclomaticComplexity(String javaCode) {
        System.out.println("working 9");
        String result ="";
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Cyclomatic Complexity");
	obj.put("value", 12);
        
        result = obj.toString();
        System.out.println("working 10");
        return result;
    }

    @Override
    public String getParameeter2(String javaCode) {
        System.out.println("working 11");
        String result ="";
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Parameeter2");
	obj.put("value", 50);
        
        result = obj.toString();
        System.out.println("working 12");
        return result;
    }

    @Override
    public String getParameeter3(String javaCode) {
        System.out.println("working 13");
        String result ="";
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Parameeter3");
	obj.put("value", 40);
        
        result = obj.toString();
        System.out.println("working 14");
        return result;
    }

    @Override
    public String getParameeter4(String javaCode) {
        System.out.println("working 15");
        String result ="";
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Parameeter4");
	obj.put("value", 60);
        
        result = obj.toString();
        System.out.println("working 16");
        return result;
    }

    @Override
    public String getParameeter5(String javaCode) {
        System.out.println("working 17");
        String result ="";
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Parameeter5");
	obj.put("value", 80);
        
        result = obj.toString();
        System.out.println("working 18");
        return result;
    }

   

}
