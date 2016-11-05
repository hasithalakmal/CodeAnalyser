package com.codemage.sql.analyser;

import com.codemage.metrix.FirstMetrix;
import com.codemage.metrix.SecondMetrix;
import com.codemage.metrix.TheirdMetric;
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
        System.out.println(javaCode);
        FirstMetrix fm = new FirstMetrix(javaCode);
        fm.getLineValues();
        String file = fm.getFileAnalyse();
        int val = fm.getTotalValue();
        System.out.println(file);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("final result = " + val);
        System.out.println("result >>>>>>>>>>>>>>>>>>>>>>>>>> "+ val);
        JSONObject obj = new JSONObject();
	obj.put("type", "Metrix 1");
	obj.put("value", val);
        
        result = obj.toString();
        System.out.println("working 10");
        return result;
    }

    @Override
    public String getParameeter2(String javaCode) {
        System.out.println("working 11");
        String result ="";
        
        SecondMetrix fm2 = new SecondMetrix(javaCode);
        System.out.println("working 11www");
        
        FirstMetrix fm = new FirstMetrix(javaCode);
        fm.getLineValues();
        String file = fm.getFileAnalyse();
        int val = fm.getTotalValue();
        //double res = fm2.getResult();
        System.out.println("result >>>>>>>>>>>>>>>>>>>>>>>>>> "+ 88);
        JSONObject obj = new JSONObject();
	obj.put("type", "Metrix 2");
	obj.put("value", val);
        
        result = obj.toString();
        System.out.println("working 12");
        return result;
    }

    @Override
    public String getParameeter3(String javaCode) {
        System.out.println("working 13");
        String result ="";
        
        TheirdMetric tm = new TheirdMetric(javaCode);
        int therdMetVal = tm.getResult();
        System.out.println("result >>>>>>>>>>>>>>>>>>>>>>>>>> "+ therdMetVal);
        
        JSONObject obj = new JSONObject();
	obj.put("type", "Metrix 3");
	obj.put("value", therdMetVal);
        
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
