package com.codemage.sql.analyser;

public interface CodeAnalyser {

    String getCyclomaticComplexity(String javaCode);
    
    String getParameeter2(String javaCode);
    
    String getParameeter3(String javaCode);
    
    String getParameeter4(String javaCode);
    
    String getParameeter5(String javaCode);
	
}
