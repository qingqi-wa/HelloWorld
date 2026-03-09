package com.afuyan.www.GasStationPayment;

public class Card {
    //卡片信息包括：车牌号码、车主姓名、电话号码、卡片余额。
    private String carNumber;
    private String ownerName;
    private String phoneNumber;
    private double balance;

    public Card() {
    }

    public Card(String carNumber, String ownerName, String phoneNumber, double balance) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void pay(double amount) {
        this.balance -= amount;
    }

    public void recharge(double amount) {
        this.balance += amount;
    }



}
