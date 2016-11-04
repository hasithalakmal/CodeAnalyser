/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testcodes;

/**
 *
 * @author Hasitha Lakmal
 */
public class BubbleSort { 
    // Bubble Sort Method for Descending Order 

    public static void main(String [] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int j;
        boolean flag = true;   // set flag to true to begin first pass		
        int temp;   //holding variable

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < num.length - 1; j++) {
                if (num[j] < num[j + 1]) // change to > for ascending sort
                {
                    temp = num[j];                //swap elements
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;              //shows a swap occurred  
                }
            }
        }
    }
}
