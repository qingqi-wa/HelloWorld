package com.afuyan.www.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JTextField;

/**
 * 计算器核心逻辑类
 * 实现 CalculatorOperations 接口，提供所有计算功能的具体实现
 *
 * 职责：只负责业务逻辑，不处理界面相关的事情
 */
public class Calculator implements CalculatorOperations {

    /**
     * 计算表达式结果
     * 使用 JavaScript 引擎来计算数学表达式
     *
     * @param displayField 显示屏文本框，从中获取表达式并显示结果
     */
    @Override
    public void calculateResult(JTextField displayField) {
        try {
            // 获取当前显示屏上的表达式
            String expression = displayField.getText();

            // 将特殊符号转换为 Java 能识别的运算符
            // × → *（乘法）
            // ÷ → /（除法）
            expression = expression.replace("×", "*").replace("÷", "/");

            // 创建脚本引擎管理器
            ScriptEngineManager manager = new ScriptEngineManager();

            // 获取 JavaScript 引擎
            // JavaScript 引擎可以直接计算字符串表达式，如 "1+2*3"
            ScriptEngine engine = manager.getEngineByName("JavaScript");

            // 计算表达式结果
            // eval() 方法会执行字符串中的代码并返回结果
            Object result = engine.eval(expression);

            // 将结果显示在显示屏上
            displayField.setText(result.toString());

        } catch (Exception e) {
            // 如果表达式有误（如除以零），显示"错误"
            displayField.setText("错误");
        }
    }

    /**
     * 删除最后一个字符（退格键功能）
     *
     * @param displayField 显示屏文本框
     */
    @Override
    public void deleteLastChar(JTextField displayField) {
        // 获取当前显示的文本
        String currentText = displayField.getText();

        // 如果长度大于 1，删除最后一个字符
        if (currentText.length() > 1) {
            // substring(0, length-1) 截取从开头到倒数第二个字符
            displayField.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            // 如果只剩一个字符，删除后显示"0"
            displayField.setText("0");
        }
    }

    /**
     * 清零功能
     *
     * @param displayField 显示屏文本框
     */
    @Override
    public void clear(JTextField displayField) {
        // 直接设置为"0"
        displayField.setText("0");
    }

    /**
     * 输入数字或运算符
     * 处理用户点击数字键或运算符按钮的逻辑
     *
     * @param displayField 显示屏文本框
     * @param value 用户输入的字符（数字或运算符）
     */
    @Override
    public void inputNumber(JTextField displayField, String value) {
        // 获取当前显示的文本
        String currentText = displayField.getText();

        // 如果当前显示的是"0"，直接用新值替换
        // 这是为了避免出现 "01"、"0+" 这样的情况
        if (currentText.equals("0")) {
            displayField.setText(value);
        } else {
            // 否则将新值追加到末尾
            // 例如：当前是"12"，输入"+"后变成"12+"
            displayField.setText(currentText + value);
        }
    }
}
