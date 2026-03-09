package com.afuyan.www.GasStationPayment;

public class GoldCard extends  Card{

    public GoldCard(String carNum, String name, String phone, double balance) {
      super(carNum, name, phone, balance);
        System.out.println("恭喜您办理金卡成功！");
    }


    @Override
    public void pay(double money) {
        this.setBalance(this.getBalance()-money*0.8);

        if(money>=200){
            System.out.println("恭喜您获得打印洗车票服务！");
        }
        System.out.println("金卡支付成功！");
    }



}
