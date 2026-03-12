package com.afuyan.www.www.JFrameDemo;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Test {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("登录窗口");

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        jFrame.add(Panel);

        jFrame.setSize(400,300);//设置窗体的宽和高
        jFrame.setLocationRelativeTo( null);//设置窗体居中
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭模式

       //设置登录按钮
        JButton jButton = new JButton("登录");
        //设置按钮的位置在画布中央
        jButton.setBounds(150,100,80,30);
        Panel.add(jButton);//添加按钮
        //监听登录按钮的点击事件,点击会弹出一个提示框
        jButton.addActionListener(e -> { JOptionPane.showMessageDialog(jFrame,"用户点击了登录按钮");});


        //监听用户键盘上下左右四个按键的事件
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    System.out.println("用户按下了上");
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("用户按下了下");
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    System.out.println("用户按下了左");
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    System.out.println("用户按下了右");
                }
            }


        });


        jFrame.setVisible(true);//设置窗体可见
        //让窗口成为焦点
        jFrame.requestFocus();




    }



}
