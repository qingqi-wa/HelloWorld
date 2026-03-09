package com.afuyan.www.GasStationPayment;

public class SilverCrad extends  Card{

    public SilverCrad(String carNum, String name, String phone, double balance) {
        super(carNum, name, phone, balance);
        System.out.println("恭喜您办理银卡卡成功！");
    }


    @Override
    public void pay(double money) {
        this.setBalance(this.getBalance()-money*0.9);

        System.out.println("银卡支付成功！");
    }



}
