package com.afuyan.www.www.calculator;

import javax.swing.*;
import java.awt.*;

/**
 * 计算器界面类
 * 负责创建和管理图形界面，处理用户交互
 *
 * 职责：只显示和交互，不处理具体的计算逻辑
 */
public class CalculatorUI extends JFrame {

    // ========== 界面组件声明 ==========

    /** 显示屏文本框，用于显示输入的数字和计算结果 */
    private JTextField displayField;

    /** 数字按钮数组（0-9） */
    private JButton[] numberButtons;

    /** 运算符按钮数组（+、-、×、÷） */
    private JButton[] operatorButtons;

    /** 功能按钮：清零、删除、等于、小数点 */
    private JButton clearButton, deleteButton, equalButton, decimalButton;

    // ========== 核心改进：使用接口来调用逻辑 ==========

    /**
     * 计算器操作接口
     * 持有 Calculator 的引用，但不依赖具体类
     * 这样以后可以方便地替换成其他实现
     */
    private CalculatorOperations calculatorOperations;

    /**
     * 构造方法 - 初始化窗口
     */
    public CalculatorUI() {
        // 设置窗口标题
        setTitle("简易计算器");

        // 设置关闭操作：关闭窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置窗口大小不可调整
        setResizable(false);

        // 初始化组件数组
        initComponents();

        // 设置布局管理器
        // BorderLayout 将容器分为 5 个区域：东、南、西、北、中
        // (10, 10) 表示组件之间的间距为 10 像素
        setLayout(new BorderLayout(10, 10));

        // 添加显示屏面板到北部（上方）
        add(createDisplayPanel(), BorderLayout.NORTH);

        // 添加按钮面板到中间区域
        add(createButtonPanel(), BorderLayout.CENTER);

        // 自动调整窗口大小以适应内容
        pack();

        // 设置窗口在屏幕中央显示
        // null 表示相对于屏幕居中
        setLocationRelativeTo(null);

        // 设置窗口可见
        setVisible(true);
    }

    /**
     * 创建显示屏面板
     * @return 包含显示屏的面板
     */
    private JPanel createDisplayPanel() {
        // 创建面板容器
        JPanel panel = new JPanel();

        // 设置面板布局为 BorderLayout
        panel.setLayout(new BorderLayout());

        // 创建文本框，初始显示"0"
        displayField = new JTextField("0");

        // 设置字体：Arial，粗体，24 号
        displayField.setFont(new Font("Arial", Font.BOLD, 24));

        // 设置文字右对齐（符合计算器习惯）
        displayField.setHorizontalAlignment(JTextField.RIGHT);

        // 设置为不可编辑，只能用鼠标点击按钮
        displayField.setEditable(false);

        // 设置背景颜色为白色
        displayField.setBackground(Color.WHITE);

        // 设置内边距：上下左右各 10 像素
        displayField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 将显示屏添加到面板中央
        panel.add(displayField, BorderLayout.CENTER);

        // 设置面板的外边距
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return panel;
    }

    /**
     * 创建按钮面板
     * @return 包含所有按钮的面板
     */
    private JPanel createButtonPanel() {
        // 创建面板容器
        JPanel panel = new JPanel();

        // 设置面板布局为网格布局
        // GridLayout(5, 4, 5, 5) 表示 5 行 4 列，间距 5 像素
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // 设置面板外边距
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 定义所有按钮的文字
        // 按从左到右、从上到下的顺序排列
        String[] buttonTexts = {
            "C", "←", "", "",          // 第 1 行：清零、删除、2 个空白
            "7", "8", "9", "÷",        // 第 2 行
            "4", "5", "6", "×",        // 第 3 行
            "1", "2", "3", "-",        // 第 4 行
            "0", ".", "=", "+"         // 第 5 行
        };

        // 遍历所有按钮文字，创建对应的按钮
        for (String text : buttonTexts) {
            // 如果是空字符串，添加一个空白标签占位
            if (text.isEmpty()) {
                panel.add(new JLabel());
                continue;
            }

            // 创建按钮
            JButton button = createButton(text);

            // 根据按钮文字设置特殊属性
            if (text.equals("C")) {
                // 清零按钮保存引用，并设为红色
                clearButton = button;
                button.setForeground(Color.RED);
            } else if (text.equals("←")) {
                // 删除按钮保存引用
                deleteButton = button;
            } else if (text.equals("=")) {
                // 等于按钮保存引用，并设为蓝色
                equalButton = button;
                button.setForeground(Color.BLUE);
            } else if (text.equals(".")) {
                // 小数点按钮保存引用
                decimalButton = button;
            } else if (text.matches("[0-9]")) {
                // 数字按钮存入数组
                // Integer.parseInt(text) 将字符串转为整数作为索引
                numberButtons[Integer.parseInt(text)] = button;
            } else if (text.matches("[+\\-×÷]")) {
                // 运算符按钮存入数组
                // "+-×÷".indexOf(text) 找到运算符在字符串中的位置
                int index = "+-×÷".indexOf(text);
                operatorButtons[index] = button;
                // 运算符按钮字体加大
                button.setFont(new Font("Arial", Font.BOLD, 18));
            }

            // 将按钮添加到面板
            panel.add(button);
        }

        return panel;
    }

    /**
     * 创建单个按钮
     * @param text 按钮上显示的文字
     * @return 创建好的按钮
     */
    private JButton createButton(String text) {
        // 创建按钮对象
        JButton button = new JButton(text);

        // 设置字体：Arial，粗体，18 号
        button.setFont(new Font("Arial", Font.BOLD, 18));

        // 不绘制焦点边框（更好看）
        button.setFocusPainted(false);

        // 设置首选大小：60x60 像素
        button.setPreferredSize(new Dimension(60, 60));

        // 添加点击事件监听器
        // 当按钮被点击时，执行 handleButtonClick(text) 方法
        // e -> ... 是 Lambda 表达式，简化代码写法
        button.addActionListener(e -> handleButtonClick(text));

        return button;
    }

    /**
     * 处理按钮点击事件
     * 根据用户点击的不同按钮执行相应操作
     *
     * @param command 按钮上的文字，代表命令
     */
    private void handleButtonClick(String command) {
        // 获取当前显示屏上的内容
        String currentText = displayField.getText();

        // 使用 switch-case 语句判断是哪个按钮
        switch (command) {
            case "C":
                // 清零按钮：调用接口的清零方法
                calculatorOperations.clear(displayField);
                break;

            case "←":
                // 删除按钮：调用接口的删除方法
                calculatorOperations.deleteLastChar(displayField);
                break;

            case "=":
                // 等于按钮：调用接口的计算方法
                calculatorOperations.calculateResult(displayField);
                break;

            default:
                // 其他按钮（数字、运算符、小数点）
                // 调用接口的输入方法
                calculatorOperations.inputNumber(displayField, command);
                break;
        }
    }

    /**
     * 初始化组件数组
     * 为按钮数组分配内存空间
     */
    private void initComponents() {
        // 创建 10 个元素的数组，存储 0-9 共 10 个数字按钮
        numberButtons = new JButton[10];

        // 创建 4 个元素的数组，存储 +、-、×、÷ 四个运算符按钮
        operatorButtons = new JButton[4];

        // ========== 关键改进：初始化接口引用 ==========
        // 创建 Calculator 对象，它实现了 CalculatorOperations 接口
        // 多态：父接口引用指向子类对象
        calculatorOperations = new Calculator();
    }

    /**
     * 程序主入口
     * Swing 程序的启动方式
     *
     * @param args 命令行参数（本程序不使用）
     */
    public static void main(String[] args) {
        // SwingUtilities.invokeLater() 确保在事件分发线程（EDT）上创建界面
        // EDT 是 Swing 专门处理界面事件的线程，保证线程安全
        // () -> new CalculatorUI() 是 Lambda 表达式，相当于 runnable.run()
        SwingUtilities.invokeLater(() -> new CalculatorUI());
    }
}
