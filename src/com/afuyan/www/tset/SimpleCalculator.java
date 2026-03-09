package com.afuyan.www.tset;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("=== 简易计算器 ===");
        Scanner scanner = new Scanner(System.in);

        // ✅ 使用循环让用户反复输入，直到正确
        double num1 = getValidDouble(scanner, "请输入第一个数字：");
        String operator = getOperator(scanner);
        double num2 = getValidDouble(scanner, "请输入第二个数字：");

        // 计算并显示结果
        double result = 0;
        try {
            result = calculate(num1, operator, num2);
            System.out.println("\n✅ 计算结果：" + num1 + " " + operator + " " + num2 + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("❌ 错误：" + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ 错误：" + e.getMessage());
        }

        scanner.close();
    }

    /**
     * 获取有效的数字输入
     * 会循环提示用户，直到输入正确的数字
     */
    public static double getValidDouble(Scanner scanner, String prompt) {
        while (true) {  // 无限循环，直到输入正确才 break
            try {
                System.out.print(prompt);
                return scanner.nextDouble();  // 成功则直接返回

            } catch (InputMismatchException e) {
                System.out.println("❌ 输入错误！请输入有效的数字。");
                scanner.nextLine();  // 清除错误输入
                // 继续循环，再次提示输入
            }
        }
    }

    /**
     * 获取有效的运算符
     */
    public static String getOperator(Scanner scanner) {
        while (true) {
            System.out.print("请选择运算符（+、-、*、/）：");
            String operator = scanner.next();

            // 检查运算符是否有效
            if (operator.equals("+") || operator.equals("-") ||
                    operator.equals("*") || operator.equals("/")) {
                return operator;  // 有效则返回
            } else {
                System.out.println("❌ 无效的运算符！请重新输入。");
            }
        }
    }

    public static double calculate(double num1, String operator, double num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("除数不能为零");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("无效的运算符");
        }
    }
}
