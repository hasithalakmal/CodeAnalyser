package com.codemage.sql.analyser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hasitha Lakmal
 */
@Service("reportGen")
@Transactional
public class ReportGenImpl implements ReportGen {

    @Override
    public String getReport(String parameterValues) {
        System.out.println("working 19");
        String result ="";
        double[] weight = {1.9, 2.9, 3.4};
        double[] passLevel = {50, 60, 70};
        String[] parameter_min_max = {"min", "max", "max"}; 
        double[] value = new double[3];
        String[] parameter = new String[3]; 
        double[] weightedValues = new double[3];
        String[] state = new String[3];
        double passValue = 58.3;
        double weightedAvg = 0;
        double weightedvalueSum = 0;
        double weightSum = 0;
        String overall_result ="";
        
        System.out.println("working 20");
        //create table object
        JSONArray tableobj = new JSONArray();
        JSONObject jsonObj = new JSONObject(parameterValues);
        JSONArray anlyse = jsonObj.getJSONArray("anlyse"); 
        System.out.println("working 20.1");
        for(int i=0; i<anlyse.length(); i++){
            //for table gen
            JSONObject obj = anlyse.getJSONObject(i);
            value[i] = obj.getDouble("value");
            parameter[i] = obj.getString("type");
            weightedValues[i] = obj.getInt("value") * weight[i];
            String condition = parameter_min_max[i];
             System.out.println("working 20.2");
            //for final result gen
            weightedvalueSum = weightedvalueSum+ weightedValues[i];
            weightSum = weightSum + weight[i];
     
            if("min".equals(condition)){
                if(value[i] > passLevel[i]){
                    state[i] = "Pass";
                }else{
                    state[i] = "Fail";
                }
            }else{
                if(value[i] < passLevel[i]){
                    state[i] = "Pass";
                }else{
                    state[i] = "Fail";
                }
            }
            
            JSONObject row = new JSONObject();
            row.put("parameter",parameter[i]);
            row.put("weight", weight[i]);
            row.put("pass_level", passLevel[i]);
            row.put("value", value[i]);
            row.put("weighted_value", weightedValues[i]);
            row.put("state", state[i]);
            
            tableobj.put(row);
        }
        System.out.println("working 21");
        
        //Final Report
        weightedAvg = (weightedvalueSum/weightSum);
        //change this if passValue is upper bound 
        if(weightedAvg>passValue){
            overall_result ="Pass";
        }else{
            overall_result ="Fail";
        }
        
        System.out.println("working 22");
        JSONObject obj = new JSONObject();
	obj.put("table", tableobj);
        obj.put("pass_value", passValue);
	obj.put("avg_result", weightedAvg);
        obj.put("overall_result", overall_result);
        
        
        result = obj.toString();
        System.out.println("working 23");
        return result;
    }

   

}
