package com.afuyan.www.www.calculator;

import javax.swing.*;
    /**
     * 计算器操作接口
     * 定义了计算器所有核心操作的规范
     * 作用：解耦界面和逻辑，让代码更灵活
     */
    public interface CalculatorOperations {

        /**
         * 计算表达式结果
         * @param displayField 显示屏文本框
         */
        void calculateResult(JTextField displayField);

        /**
         * 删除最后一个字符
         * @param displayField 显示屏文本框
         */
        void deleteLastChar(JTextField displayField);

        /**
         * 清零
         * @param displayField 显示屏文本框
         */
        void clear(JTextField displayField);

        /**
         * 输入数字或运算符
         * @param displayField 显示屏文本框
         * @param value 要输入的字符
         */
        void inputNumber(JTextField displayField, String value);



}
