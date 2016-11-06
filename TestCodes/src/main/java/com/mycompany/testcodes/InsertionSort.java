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
public class InsertionSort {

    public static void main(String [] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int ccc = 0;
        int j;     
        int key;       
        int i;

        for (j = 1; j < num.length; j++) 
        {
            key = num[j];
            for (i = j - 1; (i >= 0) && (num[i] < key); i--) 
            {
                num[i + 1] = num[i];
            }
            num[i + 1] = key;  
        }
    }
}
