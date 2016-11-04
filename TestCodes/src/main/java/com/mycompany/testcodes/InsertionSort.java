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
    // Insertion Sort Method for Descending Order

    public static void main(String [] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int ccc = 0;
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < num.length; j++) // Start with 1 (not 0)
        {
            key = num[j];
            for (i = j - 1; (i >= 0) && (num[i] < key); i--) // Smaller values are moving up
            {
                num[i + 1] = num[i];
            }
            num[i + 1] = key;    // Put the key in its proper location
        }
    }
}
