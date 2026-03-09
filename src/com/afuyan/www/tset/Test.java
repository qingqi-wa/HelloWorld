package com.afuyan.www.tset;

import java.util.Random;
import java.util.Scanner;

public class Test {

    // 猜数字小游戏
    // 程序逻辑如下：
    // 1.	计算机随机生成一个 1-100 的数字
    // 2.	用户输入数字进行猜测
    // 3.	程序提示"太大"或"太小"
    // 4.	直到猜对为止

    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        
        Scanner scanner = new Scanner(System.in);
        int guessCount = 0;
        int userGuess;
        
        System.out.println("=== 猜数字游戏 ===");
        System.out.println("我已经想好了一个 1 到 100 之间的数字，请开始猜测吧！");
        
        do {
            System.out.print("请输入你的猜测：");
            
            while (!scanner.hasNextInt()) {
                System.out.print("请输入有效的数字：");
                scanner.next();
            }
            
            userGuess = scanner.nextInt();
            guessCount++;
            
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("请输入 1-100 之间的数字！");
            } else if (userGuess > targetNumber) {
                System.out.println("太大了！再试一次。");
            } else if (userGuess < targetNumber) {
                System.out.println("太小了！再试一次。");
            }
            
        } while (userGuess != targetNumber);
        
        System.out.println("恭喜你猜对了！答案就是 " + targetNumber);
        System.out.println("你总共猜了 " + guessCount + " 次");
        
        scanner.close();
    }
}
