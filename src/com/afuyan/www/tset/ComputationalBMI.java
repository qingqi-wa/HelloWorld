package com.afuyan.www.tset;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ComputationalBMI {
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    
    public static void main(String[] args) {
        System.out.println("=== 健康计算器 ===");
        
        UserInfo user = getUserInfo();
        
        printResults(user);
        
        scanner.close();
    }
    
    private static UserInfo getUserInfo() {
        UserInfo user = new UserInfo();
        user.age = readInt("请输入你的年龄：");
        user.sex = readString("请输入你的性别：");
        user.weight = readDouble("请输入你的体重（kg）：");
        user.height = readDouble("请输入你的身高（cm）：");
        return user;
    }
    
    private static void printResults(UserInfo user) {
        System.out.println("\n=== 计算结果 ===");
        System.out.printf("BMI 指数：%.2f\n", user.getBMI());
        System.out.printf("基础代谢率：%.2f 千卡/天\n", user.getBMR());
    }
    
    private static int readInt(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("输入无效，请输入数字！");
            return readInt(message);  // 重新输入
        }
    }
    
    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    
    private static double readDouble(String message) {
        System.out.print(message);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("输入无效，请输入数字！");
            return readDouble(message);  // 重新输入
        }
    }
    
    static class UserInfo {
        int age;
        String sex;
        double weight;
        double height;
        
        double getBMI() {
            double h = height / 100;
            return weight / (h * h);
        }
        
        double getBMR() {
            if (sex.equalsIgnoreCase("男")) {
                return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
            } else {
                return 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
            }
        }
    }
}
