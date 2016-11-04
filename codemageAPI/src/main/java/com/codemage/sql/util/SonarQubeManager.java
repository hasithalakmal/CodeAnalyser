/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemage.sql.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hasitha Lakmal
 */
@Service("sonarQubeManager")
public class SonarQubeManager {

    void startSonarQube() {
        System.out.println("start sonar Qube");
    }

    public void createJavaFile(String JavaCode) {
        BufferedWriter bw = null;

        try {
            // APPEND MODE SET HERE
            bw = new BufferedWriter(new FileWriter("E:\\Smile24\\Projects\\0005 - CAL\\sampleAnalyseCode\\src\\main\\java\\checkbook.java", false));
            bw.write(JavaCode);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
        } finally {                       // always close the file
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                    // just ignore it
                }
            }
        } // end try/catch/finally
    }

    public void AnalyseProject() {
        
        
        
        String domainName = "google.com";

        //in mac oxs
        //String command = "ping -c 3 " + domainName;

        //in windows
        String command = "cd E:\\Smile24\\Projects\\0005 - CAL\\sampleAnalyseCode";
        String output = this.executeCommand(command);
        
        command = "cd E:\\Smile24\\Projects\\0005 - CAL\\sampleAnalyseCode";
        output = this.executeCommand(command);

        System.out.println(output);
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}
