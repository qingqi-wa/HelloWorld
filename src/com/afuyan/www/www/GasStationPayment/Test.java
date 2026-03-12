package com.afuyan.www.www.GasStationPayment;

import java.util.Scanner;

public class Test {
    //某加油站为了吸引更多的车主，推出了如下活动，车主可以办理金卡和银卡。
    //卡片信息包括：车牌号码、车主姓名、电话号码、卡片余额。
    //金卡办理时入存金额必须>=5000元，银卡办理时预存金额必须>=2000元，金卡支付时享受8
    //折优惠，银卡支付时享受9折优惠，金卡消费满200元可以提供打印免费洗车票的服务。
  public  static void main(String[] args) {
      System.out.println("请选择所需服务");
      System.out.println("1.办理会员卡");
      System.out.println("2.会员充值");
      System.out.println("3.会员消费");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();

      extracted(choice, scanner);


  }

    private static void extracted(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                extractedCard(scanner);
                break;
            case 2:
                System.out.println("充值金额：");
                double rechargeAmount = scanner.nextDouble();


                System.out.println("充值成功");

            case 3:

            case 0:
                System.out.println("感谢使用，再见！");
                break;



                default:
                System.out.println("请输入正确的选项");
                break;
        }
        return;

    }

    private static void extractedCard(Scanner scanner) {
        System.out.println("请选择会员类型");
        System.out.println("1.金卡");
        System.out.println("2.银卡");
        int cardType = scanner.nextInt();
        System.out.println("请输入会员姓名");
        String name = scanner.next();
        System.out.println("请输入会员车牌号");
        String plateNumber = scanner.next();
        System.out.println("请输入会员电话号码");
        String phoneNumber = scanner.next();
        System.out.println("请输入会员卡余额");
        double balance = scanner.nextDouble();
        switch (cardType) {
            case 1:
                if (balance >= 5000) {
                    System.out.println("办理成功");
                    GoldCard goldCard = new GoldCard(name, plateNumber, phoneNumber, balance);
                    System.out.println("欢迎您："+goldCard);
                } else {
                    System.out.println("余额不足");
                }
                break;
            case 2:
                System.out.println("请输入会员卡余额");
               if (balance >= 2000) {
                   System.out.println("办理成功");
                   SilverCrad silverCrad = new SilverCrad(name, plateNumber, phoneNumber, balance);
               } else {
                   System.out.println("余额不足");
               }
               break;
        }
    }


}
