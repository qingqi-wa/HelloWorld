package com.afuyan.www.GUIHRDeom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * HR 管理系统登录界面
 * 提供用户登录和注册功能
 */
public class Ui extends JFrame {

    // 用户名输入框
    private JTextField usernameField;
    
    // 密码输入框（隐藏显示）
    private JPasswordField passwordField;

    /**
     * 构造方法，初始化登录界面
     */
    public Ui() {
        initUI();
    }

    /**
     * 初始化界面组件和布局
     */
    private void initUI() {
        // 设置窗口标题
        setTitle("HR 管理系统 - 登录");
        
        // 设置窗口大小（宽 500px, 高 400px）
        setSize(500, 400);
        
        // 设置窗口居中显示
        setLocationRelativeTo(null);
        
        // 设置关闭操作：点击关闭按钮时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 设置布局管理器为边界布局
        setLayout(new BorderLayout());

        // 创建顶部面板，放置欢迎登录标题
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // 创建标题标签，文字居中
        JLabel titleLabel = new JLabel("欢迎登录HR管理系统");
        
        // 设置标题字体（微软雅黑，加粗，24 号）
        titleLabel.setFont(new Font("宋体", Font.BOLD, 24));
        
        topPanel.add(titleLabel);

        // 创建主面板，用于放置用户输入组件
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        
        // 设置面板边框（上 20, 左 80, 下 30, 右 80）
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 30, 80));
        
        // 创建 GridBagConstraints 用于控制组件布局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0); // 上下间距 5px

        // 创建用户名标签
        JLabel usernameLabel = new JLabel("用户名:");
        
        // 设置用户名字体（宋体，加粗，18 号）
        usernameLabel.setFont(new Font("宋体", Font.BOLD, 18));
        
        // 创建用户名文本输入框
        usernameField = new JTextField();
        
        // 设置用户名字体（宋体，16 号）
        usernameField.setFont(new Font("宋体", Font.PLAIN, 16));
        
        // 设置输入框的首选大小（宽度自适应，高度 30px）
        usernameField.setPreferredSize(new Dimension(0, 30));

        // 创建密码标签
        JLabel passwordLabel = new JLabel("密码:");
        
        // 设置密码字体（宋体，加粗，18 号）
        passwordLabel.setFont(new Font("宋体", Font.BOLD, 18));
        
        // 创建密码输入框（输入内容显示为圆点）
        passwordField = new JPasswordField();
        
        // 设置密码字体（宋体，16 号）
        passwordField.setFont(new Font("宋体", Font.PLAIN, 16));
        
        // 设置输入框的首选大小（宽度自适应，高度 30px）
        passwordField.setPreferredSize(new Dimension(0, 30));

        // 使用 GridBagLayout 添加组件
        // 第一行：用户名标签
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(usernameLabel, gbc);
        
        // 第一行：用户名输入框
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(usernameField, gbc);
        
        // 第二行：密码标签
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(passwordLabel, gbc);
        
        // 第二行：密码输入框
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(passwordField, gbc);

        // 创建底部按钮面板，使用流式布局（两个按钮横向紧挨在一起）
        JPanel buttonPanel = new JPanel();
        
        // 设置按钮面板布局（居中对齐，水平间距 10px，垂直间距 10px）
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        // 创建登录按钮
        JButton loginButton = new JButton("登录");
        
        // 设置登录按钮字体（微软雅黑，加粗，16 号）
        loginButton.setFont(new Font("宋体", Font.BOLD, 16));
        
        // 设置登录按钮首选大小（宽 120px, 高 40px）
        loginButton.setPreferredSize(new Dimension(120, 40));
        
        // 设置登录按钮背景色为蓝色
        loginButton.setBackground(new Color(0, 120, 215));
        
        // 设置登录按钮前景色（文字颜色）为白色
        loginButton.setForeground(Color.WHITE);
        
        // 设置登录按钮不绘制内容区域（让背景色填满）
        loginButton.setContentAreaFilled(true);
        
        // 设置登录按钮不透明
        loginButton.setOpaque(true);
        
        // 设置登录按钮无边框
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // 创建注册按钮
        JButton registerButton = new JButton("注册");
        
        // 设置注册按钮字体（微软雅黑，加粗，16 号）
        registerButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        
        // 设置注册按钮首选大小（与登录按钮相同）
        registerButton.setPreferredSize(new Dimension(120, 40));
        
        // 设置注册按钮背景色为灰色
        registerButton.setBackground(new Color(128, 128, 128));
        
        // 设置注册按钮前景色（文字颜色）为白色
        registerButton.setForeground(Color.WHITE);
        
        // 设置注册按钮不绘制内容区域
        registerButton.setContentAreaFilled(true);
        
        // 设置注册按钮不透明
        registerButton.setOpaque(true);
        
        // 设置注册按钮无边框
        registerButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        
        // 将按钮添加到按钮面板
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // 将各部分添加到窗口的不同区域
        add(topPanel, BorderLayout.NORTH);      // 顶部放标题
        add(mainPanel, BorderLayout.CENTER);    // 中间放输入框
        add(buttonPanel, BorderLayout.SOUTH);   // 底部放按钮

        // 为登录按钮添加点击事件监听器
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 为注册按钮添加点击事件监听器
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

//    /**
//     * 处理登录逻辑
//     * 验证用户名和密码，默认账号 admin，密码 123456
//     */
//    private void handleLogin() {
//        // 获取用户名并去除首尾空格
//        String username = usernameField.getText().trim();
//
//        // 获取密码（JPasswordField 返回 char[]，需转换为 String）
//        String password = new String(passwordField.getPassword());
//
//        // 校验用户名是否为空
//        if (username.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "请输入用户名！", "提示", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        // 校验密码是否为空
//        if (password.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "请输入密码！", "提示", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        // 验证用户名和密码是否正确
//        if ("admin".equals(username) && "123456".equals(password)) {
//            // 登录成功，显示成功消息并关闭当前窗口
//            JOptionPane.showMessageDialog(this, "登录成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
//            dispose();
//        } else {
//            // 登录失败，显示错误消息并清空密码框
//            JOptionPane.showMessageDialog(this, "用户名或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
//            passwordField.setText("");
//        }
//    }
//
//    /**
//     * 处理注册逻辑
//     * 目前仅显示提示信息，后续可扩展实现注册功能
//     */
//    private void handleRegister() {
//        JOptionPane.showMessageDialog(this, "注册功能待实现！", "提示", JOptionPane.INFORMATION_MESSAGE);
//    }


}
