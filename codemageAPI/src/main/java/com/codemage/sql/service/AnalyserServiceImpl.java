package com.codemage.sql.service;

import com.codemage.sql.analyser.CodeAnalyser;
import com.codemage.sql.analyser.ReportGen;
import com.codemage.sql.util.SonarQubeManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("analyserService")
@Transactional
public class AnalyserServiceImpl implements AnalyserService {
    
    @Autowired
    CodeAnalyser codeAnalyser;
    
    @Autowired
    ReportGen reportGen;
    
    @Autowired
    SonarQubeManager sonarQubeManager;


    @Override
    public String getAnalysereport(String javaCode) { 
       // sonarQubeManager.createJavaFile(javaCode);
       // sonarQubeManager.AnalyseProject();
        System.out.println("working 4");
        String result ="";
        
        String res1 = codeAnalyser.getCyclomaticComplexity(javaCode);
        System.out.println(">>>>>>>>>>>>!!!");
        String res2 = codeAnalyser.getParameeter2(javaCode);
        String res3 = codeAnalyser.getParameeter3(javaCode);
        System.out.println("working 5");
        
        JSONArray list = new JSONArray();
        
        JSONObject res1Obj = new JSONObject(res1);
        JSONObject res2Obj = new JSONObject(res2);
        JSONObject res3Obj = new JSONObject(res3);
	list.put(res1Obj);
	list.put(res2Obj);
	list.put(res3Obj);
        System.out.println("working 6");
        
        JSONObject obj = new JSONObject();
	obj.put("anlyse", list);
        System.out.println("working 7");
        result = reportGen.getReport(obj.toString());
        System.out.println("working 8");

        
        return result;
    }

	

}
