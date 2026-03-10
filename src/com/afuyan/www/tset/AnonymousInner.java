package com.afuyan.www.tset;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousInner {
    public static void main(String[] args) {
        System.out.println("hello world");
        //准备一个学生数组，存放5个学生对象
        Student[] students = new Student[5];
        students[0] = new Student("小王", 15, 1.75);
        students[1] = new Student("小张", 19, 1.65);
        students[2] = new Student("小李", 17, 1.55);
        students[3] = new Student("小王", 20, 1.75);
        students[4] = new Student("小王", 18, 1.75);


        //按年龄大小排列
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

               return o1.getAge() - o2.getAge();
            }
        });

        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge() + " " + student.getHight());
        }

    }


}
