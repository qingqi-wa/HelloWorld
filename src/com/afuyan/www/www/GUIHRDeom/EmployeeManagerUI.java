package com.afuyan.www.www.GUIHRDeom; // 声明包路径

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeManagerUI extends JFrame { // 定义员工管理界面类，继承自 JFrame 窗口

    JTextField searchField = new JTextField(15); // 创建搜索文本输入框，宽度 15 列
    JButton searchBtn = new JButton("搜索"); // 创建搜索按钮
    JButton addBtn = new JButton("添加"); // 创建添加按钮

    JTable table; // 声明表格组件
    DefaultTableModel model; // 声明表格数据模型

    JPopupMenu popupMenu = new JPopupMenu(); // 创建右键弹出菜单
    JMenuItem editItem = new JMenuItem("修改"); // 创建修改菜单项
    JMenuItem deleteItem = new JMenuItem("删除"); // 创建删除菜单项
    


    public EmployeeManagerUI(){ // 构造方法，初始化界面

        setTitle("员工信息管理系统"); // 设置窗口标题
        setSize(900,500); // 设置窗口大小为 900x500 像素
        setLocationRelativeTo(null); // 设置窗口居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 设置关闭时退出程序

        // ===== 第一行 面板 ===== // 注释：创建顶部面板
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 创建顶部面板，使用流式布局居中

        topPanel.add(new JLabel("姓名搜索:")); // 添加姓名标签到顶部面板
        topPanel.add(searchField); // 添加搜索文本框到顶部面板
        topPanel.add(searchBtn); // 添加搜索按钮到顶部面板
        topPanel.add(addBtn); // 添加添加按钮到顶部面板

        add(topPanel,BorderLayout.NORTH); // 将顶部面板添加到窗口北部（上方）

        // ===== 表格 ===== // 注释：创建数据表格
        String[] columnNames={ // 定义表格列名数组
                "ID","姓名","年龄","电话","入职时间","薪水","部门" // 7 个列名
        };

        model=new DefaultTableModel(columnNames,0); // 创建表格模型，初始 0 行数据
        table=new JTable(model); // 创建表格组件并绑定模型

        JScrollPane scrollPane=new JScrollPane(table); // 创建滚动面板包裹表格
        add(scrollPane,BorderLayout.CENTER); // 将滚动面板添加到窗口中部

        // ===== 右键菜单 ===== // 注释：配置右键菜单
        popupMenu.add(editItem); // 添加修改项到弹出菜单
        popupMenu.add(deleteItem); // 添加删除项到弹出菜单

        table.addMouseListener(new MouseAdapter() { // 为表格添加鼠标监听器
            public void mousePressed(MouseEvent e){ // 鼠标按下时触发
                if(e.isPopupTrigger()) showMenu(e); // 如果是弹出菜单触发事件则显示菜单
            }
            public void mouseReleased(MouseEvent e){ // 鼠标释放时触发
                if(e.isPopupTrigger()) showMenu(e); // 如果是弹出菜单触发事件则显示菜单
            }

            private void showMenu(MouseEvent e){ // 显示菜单的私有方法
                int row=table.rowAtPoint(e.getPoint()); // 获取鼠标点击位置的行号
                table.setRowSelectionInterval(row,row); // 选中该行
                popupMenu.show(table,e.getX(),e.getY()); // 在鼠标位置显示弹出菜单
            }
        });

        // ===== 初始化 20 条数据 ===== // 注释：循环添加 20 条测试数据
        for(int i=1;i<=20;i++){ // 循环变量 i 从 1 到 20
            model.addRow(new Object[]{ // 向表格模型添加一行数据
                    "E"+i, // ID 为员工编号 E1-E20
                    "员工"+i, // 姓名为员工 1- 员工 20
                    20+i, // 年龄为 21-40 岁
                    "138000000"+i, // 电话号码
                    "2023-01-"+(i<10?"0"+i:i), // 入职日期，格式统一为 yyyy-MM-dd
                    5000+i*100, // 薪水为 5100-6900
                    "技术部" // 部门固定为技术部
            });
        }

        // ===== 搜索 ===== // 注释：绑定搜索按钮事件
        searchBtn.addActionListener(e->search()); // 点击搜索按钮时调用 search 方法

        // ===== 添加 ===== // 注释：绑定添加按钮事件
        addBtn.addActionListener(e->addEmployee()); // 点击添加按钮时调用添加员工方法

        // ===== 删除 ===== // 注释：绑定删除菜单项事件
        deleteItem.addActionListener(e->deleteEmployee()); // 选择删除菜单项时调用删除员工方法

        // ===== 修改 ===== // 注释：绑定修改菜单项事件
        editItem.addActionListener(e->editEmployee()); // 选择修改菜单项时调用修改员工方法

        setVisible(true); // 设置窗口可见
    }

    // 搜索 // 注释：搜索员工方法
    private void search(){ // 私有搜索方法
        String keyword=searchField.getText(); // 获取搜索框输入的关键词

        for(int i=0;i<table.getRowCount();i++){ // 遍历表格所有行
            String name=(String)model.getValueAt(i,1); // 获取第 i 行第 2 列（姓名）的值

            if(name.contains(keyword)){ // 如果姓名包含关键词
                table.setRowSelectionInterval(i,i); // 选中该行
                table.scrollRectToVisible(table.getCellRect(i,0,true)); // 滚动到该行可见位置
                return; // 找到后退出方法
            }
        }

        JOptionPane.showMessageDialog(this,"未找到员工"); // 未找到则弹出提示对话框
    }

    // 添加 // 注释：添加员工方法
    private void addEmployee(){ // 私有添加员工方法

        JTextField id=new JTextField(); // 创建 ID 输入框
        JTextField name=new JTextField(); // 创建姓名输入框
        JTextField age=new JTextField(); // 创建年龄输入框
        JTextField phone=new JTextField(); // 创建电话输入框
        JTextField date=new JTextField(); // 创建入职日期输入框
        JTextField salary=new JTextField(); // 创建薪水输入框
        JTextField dept=new JTextField(); // 创建部门输入框

        Object[] message={ // 定义消息对话框的内容数组
                "ID:",id, // ID 标签和输入框
                "姓名:",name, // 姓名标签和输入框
                "年龄:",age, // 年龄标签和输入框
                "电话:",phone, // 电话标签和输入框
                "入职时间:",date, // 入职时间标签和输入框
                "薪水:",salary, // 薪水标签和输入框
                "部门:",dept // 部门标签和输入框
        };

        int option=JOptionPane.showConfirmDialog( // 显示确认对话框并获取用户选择
                this, // 父组件
                message, // 对话框内容
                "添加员工", // 对话框标题
                JOptionPane.OK_CANCEL_OPTION // 确定取消按钮类型
        );

        if(option==JOptionPane.OK_OPTION){ // 如果用户点击确定

            model.addRow(new Object[]{ // 向表格模型添加新行
                    id.getText(), // 获取 ID 输入框文本
                    name.getText(), // 获取姓名输入框文本
                    age.getText(), // 获取年龄输入框文本
                    phone.getText(), // 获取电话输入框文本
                    date.getText(), // 获取日期输入框文本
                    salary.getText(), // 获取薪水输入框文本
                    dept.getText() // 获取部门输入框文本
            });
        }
    }

    // 删除 // 注释：删除员工方法
    private void deleteEmployee(){ // 私有删除员工方法
        int row=table.getSelectedRow(); // 获取选中的行号

        if(row!=-1){ // 如果有选中行（行号不为 -1）
            model.removeRow(row); // 从表格模型中删除该行
        }
    }

    // 修改 // 注释：修改员工方法
    private void editEmployee(){ // 私有修改员工方法

        int row=table.getSelectedRow(); // 获取选中的行号

        if(row==-1) return; // 如果没有选中行则直接返回

        JTextField id=new JTextField(model.getValueAt(row,0).toString()); // 创建 ID 输入框并填入当前值
        JTextField name=new JTextField(model.getValueAt(row,1).toString()); // 创建姓名输入框并填入当前值
        JTextField age=new JTextField(model.getValueAt(row,2).toString()); // 创建年龄输入框并填入当前值
        JTextField phone=new JTextField(model.getValueAt(row,3).toString()); // 创建电话输入框并填入当前值
        JTextField date=new JTextField(model.getValueAt(row,4).toString()); // 创建日期输入框并填入当前值
        JTextField salary=new JTextField(model.getValueAt(row,5).toString()); // 创建薪水输入框并填入当前值
        JTextField dept=new JTextField(model.getValueAt(row,6).toString()); // 创建部门输入框并填入当前值

        Object[] message={ // 定义消息对话框的内容数组
                "ID:",id, // ID 标签和输入框
                "姓名:",name, // 姓名标签和输入框
                "年龄:",age, // 年龄标签和输入框
                "电话:",phone, // 电话标签和输入框
                "入职时间:",date, // 入职时间标签和输入框
                "薪水:",salary, // 薪水标签和输入框
                "部门:",dept // 部门标签和输入框
        };

        int option=JOptionPane.showConfirmDialog( // 显示确认对话框并获取用户选择
                this, // 父组件
                message, // 对话框内容
                "修改员工", // 对话框标题
                JOptionPane.OK_CANCEL_OPTION // 确定取消按钮类型
        );

        if(option==JOptionPane.OK_OPTION){ // 如果用户点击确定

            model.setValueAt(id.getText(),row,0); // 更新 ID 值到表格
            model.setValueAt(name.getText(),row,1); // 更新姓名值到表格
            model.setValueAt(age.getText(),row,2); // 更新年龄值到表格
            model.setValueAt(phone.getText(),row,3); // 更新电话值到表格
            model.setValueAt(date.getText(),row,4); // 更新日期值到表格
            model.setValueAt(salary.getText(),row,5); // 更新薪水值到表格
            model.setValueAt(dept.getText(),row,6); // 更新部门值到表格
        }
    }

}