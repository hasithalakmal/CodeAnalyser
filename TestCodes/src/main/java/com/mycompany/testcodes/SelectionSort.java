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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectionSort {

    private static void swap(int[] a, int i, int j) {						//MCC=3*15 + (2*1 + 1*1 +  1*1)=79;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] selectionSort(int[] list) {							//MCC=1*40 + 0
        for (int i = 0; i < list.length - 1; i++) {
            // Find the index of the minimum value
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minPos]) {																		//therefore CCC = 40+79 =119				
                    minPos = j;
                }
            }
            swap(list, minPos, i);
        }
        return list;
    }

    public static void main(String args[]) throws Exception {
        String list = "";
        int i = 0, n = 0;

        SelectionSort s = new SelectionSort();
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Please enter the list of elements,one element per line");
        System.out.println(" write 'STOP' when list is completed ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (!(list = bf.readLine()).equalsIgnoreCase("stop")) {
            int intelement = Integer.parseInt(list);
            arrlist.add(intelement);

        }

        int elementlist[] = new int[arrlist.size()];
        Iterator<Integer> iter = arrlist.iterator();
        for (int j = 0; iter.hasNext(); j++) {
            elementlist[j] = iter.next();
        }

        elementlist = selectionSort(elementlist);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Values after Selection Sort : ");
        for (int j = 0; j < elementlist.length; j++) {
            System.out.println(elementlist[j] + " ");
        }
    }
}
