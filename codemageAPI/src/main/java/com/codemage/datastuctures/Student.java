package com.codemage.datastuctures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasitha Lakmal
 */
public class Student {
    
    private String name;
    private String School;
    private int id;
    private int age;
    int x;

    public Student() {
        System.out.println("clz initialise");
    }
    
    public void myMeth(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("This is my method");
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String School) {
        this.School = School;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
