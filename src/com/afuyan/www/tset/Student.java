package com.afuyan.www.tset;

public class Student {
    private String name;
    private int age;
    private double hight;


    public Student() {
    }
    public Student(String name, int age, double hight) {
        this.name = name;
        this.age = age;
        this.hight = hight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }




}
