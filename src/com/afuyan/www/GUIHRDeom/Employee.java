package com.afuyan.www.GUIHRDeom;





// 员工角色Employee：ID,姓名 ，年龄，电话，入职时间，薪水，部门信息
public class Employee {
    private String name;
    private int age;
    private String phone;
    private String joinTime;
    private double salary;
    private String department;

    public Employee() {
    }

    public Employee(String name, int age, String phone, String joinTime, double salary, String department) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.joinTime = joinTime;
        this.salary = salary;
        this.department = department;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



}