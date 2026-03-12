package com.afuyan.www;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
  //设置图片文件位置
    private static final String imagePath = "stone-maze/src/image/";

   int step=0;//步数
   
   //保存初始数组状态（作为常量）
    private final int[][] INITIAL_DATE = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    
   //准备一个数组存储色块行列位置
    private final int[][] imagDate = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0},

   };
   
   //记录 0 的位置
    private int zeroRow = 3; //0 的行数
    private int zeroCol = 3; //0 的列数
    
    //步数显示标签
    private JLabel stepLabel;
    
    // 游戏是否结束
    private boolean isGameOver = false;

    // 创建主界面，加入背景，导入素材
     public MainFrame() {
         initFrame();// 初始化窗体
        resetGame();  // 重置游戏数据
        initRandomArray();//打乱二维数组中的元素顺序
         initImage();// 初始化图片
         initMenu();// 初始化菜单
        //给窗体绑定上下左右按键事件
         initKeyPreess();// 绑定按键事件


         this.setVisible(true);// 设置可见


     }
     
     // 重置游戏数据到初始状态
     private void resetGame() {
         zeroRow = 3;
         zeroCol = 3;
         step = 0;
         isGameOver = false;
         // 恢复数组初始值
         for(int i = 0; i < 4; i++) {
             for(int j = 0; j < 4; j++) {
                 imagDate[i][j] = INITIAL_DATE[i][j];
             }
         }
         // 更新步数显示
         if(stepLabel != null) {
             stepLabel.setText("步数：" + step);
         }
     }
     
     // 随机打乱数组（保证有解）
     private void initRandomArray() {
         // 方案：从完成状态开始，随机移动 100-200 步来打乱
         // 这样保证一定可以还原
         
         int shuffleSteps = 100 + (int)(Math.random() * 100); // 随机移动 100-200 步
         
         for(int i = 0; i < shuffleSteps; i++) {
             // 随机选择一个方向
             int randomDirection = (int)(Math.random() * 4);
             
             Direction dir = null;
             switch(randomDirection) {
                 case 0: dir = Direction.UP; break;
                 case 1: dir = Direction.DOWN; break;
                 case 2: dir = Direction.LEFT; break;
                 case 3: dir = Direction.RIGHT; break;
             }
             
             // 执行移动（不增加步数，不刷新界面）
             moveWithoutCount(dir);
         }
         
         // 重置步数为 0（打乱过程不计入步数）
         step = 0;
         if(stepLabel != null) {
             stepLabel.setText("步数：" + step);
         }
     }
     
     // 移动但不计数（用于打乱）
     private void moveWithoutCount(Direction direction) {
         if(direction == Direction.UP && zeroRow > 0) {
             imagDate[zeroRow][zeroCol] = imagDate[zeroRow - 1][zeroCol];
             imagDate[zeroRow - 1][zeroCol] = 0;
             zeroRow--;
         } else if(direction == Direction.DOWN && zeroRow < 3) {
             imagDate[zeroRow][zeroCol] = imagDate[zeroRow + 1][zeroCol];
             imagDate[zeroRow + 1][zeroCol] = 0;
             zeroRow++;
         } else if(direction == Direction.LEFT && zeroCol > 0) {
             imagDate[zeroRow][zeroCol] = imagDate[zeroRow][zeroCol - 1];
             imagDate[zeroRow][zeroCol - 1] = 0;
             zeroCol--;
         } else if(direction == Direction.RIGHT && zeroCol < 3) {
             imagDate[zeroRow][zeroCol] = imagDate[zeroRow][zeroCol + 1];
             imagDate[zeroRow][zeroCol + 1] = 0;
             zeroCol++;
         }
     }

    private void initKeyPreess() {
        //给窗体绑定上下左右按键事件
         this.addKeyListener( new KeyAdapter() {
             @Override
              public void keyPressed(KeyEvent e) {
                //获取当前按钮编号
                 int keyCode = e.getKeyCode();
                 //判断是否是上下左右按键或 WASD
                 switch (keyCode) {
                     case KeyEvent.VK_UP:
                     case KeyEvent.VK_W:
                         switchAndMove( Direction.UP);
                         break;
                     case KeyEvent.VK_DOWN:
                     case KeyEvent.VK_S:
                         switchAndMove( Direction.DOWN);
                         break;
                     case KeyEvent.VK_LEFT:
                     case KeyEvent.VK_A:
                         switchAndMove( Direction.LEFT);
                         break;
                     case KeyEvent.VK_RIGHT:
                     case KeyEvent.VK_D:
                         switchAndMove( Direction.RIGHT);
                         break;
                 }
             }
         });


    }


    private void switchAndMove(Direction direction ) {
        if(isGameOver) return; // 游戏已结束，禁止移动
        
        if((direction == Direction.UP || direction == Direction.w)&& zeroRow < 3) {
            //0 与下方的色块交换
            imagDate[zeroRow][zeroCol] = imagDate[zeroRow + 1][zeroCol];
            imagDate[zeroRow + 1][zeroCol] = 0;
            zeroRow++;
            step++;
        } else if((direction == Direction.DOWN || direction == Direction.s) && zeroRow > 0) {
            // 0 与上方的色块交换
            imagDate[zeroRow][zeroCol] = imagDate[zeroRow - 1][zeroCol];
            imagDate[zeroRow - 1][zeroCol] = 0;
            zeroRow--;
            step++;
        } else if((direction == Direction.LEFT || direction == Direction.a) && zeroCol < 3) {
            // 0 与右方的色块交换
            imagDate[zeroRow][zeroCol] = imagDate[zeroRow][zeroCol + 1];
            imagDate[zeroRow][zeroCol + 1] = 0;
            zeroCol++;
            step++;
        } else if((direction == Direction.RIGHT || direction == Direction.d) && zeroCol > 0) {
            // 0 与左方的色块交换
            imagDate[zeroRow][zeroCol] = imagDate[zeroRow][zeroCol - 1];
            imagDate[zeroRow][zeroCol - 1] = 0;
            zeroCol--;
            step++;
        }
        
        // 更新步数显示
        if(stepLabel != null) {
            stepLabel.setText("步数：" + step);
        }
        
        // 检查是否胜利
        checkWin();
        
        // 重绘界面
        this.getContentPane().removeAll();
        initImage();
        this.repaint();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("系统");
        JMenuItem exitItem = new JMenuItem("退出");
        menu.add(exitItem);
        exitItem.addActionListener(e ->  dispose());
        
        JMenuItem restartItem = new JMenuItem("重启");
        menu.add(restartItem);
        restartItem.addActionListener(e -> { 
            resetGame();          // 重置游戏数据到初始状态
            initRandomArray();    // 重新打乱
            this.getContentPane().removeAll();
            initImage();
            this.repaint();
        });

        menuBar.add(menu);
        
        // 添加步数显示在菜单栏右侧
        stepLabel = new JLabel("步数：" + step);
        stepLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
        menuBar.add(Box.createHorizontalGlue()); // 弹性空间，把步数推到右边
        menuBar.add(stepLabel);
        
        this.setJMenuBar(menuBar);
    }

    //展示一个行类矩阵的图片色块依次铺满窗口（4）
     private void initImage() {
         for (int i = 0; i < imagDate.length; i++) {
             for (int j = 0; j < imagDate[i].length; j++) {
                String imageName = imagDate[i][j] + ".png";// 拼接图片名
                 JLabel label = new JLabel(new ImageIcon(imagePath + imageName));// 创建标签
                 label.setBounds(20 + j * 100, 60+i * 100, 100, 100);
                 this.add(label);//把图片展示出来
             }
         }
             //设置背景图片
         JLabel label = new JLabel(new ImageIcon(imagePath + "background.png"));
         label.setBounds(-10, -40, 465, 575);
         this.add(label);






     }





    private void initFrame() {
        this.setTitle("stone-maze");// 设置标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭模式
        this.setSize(465, 575);// 设置大小
        this.setLocationRelativeTo(null);// 设置居中
        this.setLayout(null);
        this.setResizable(false);// 设置不可拉伸
    }
    
    // 判断是否胜利
    private void checkWin() {
        // 对比当前数组和目标数组
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(imagDate[i][j] != INITIAL_DATE[i][j]) {
                    return; // 有一个不匹配就没胜利
                }
            }
        }
        
        // 全部匹配，胜利！
        isGameOver = true;
        showWinDialog();
    }
    
    // 显示胜利对话框
    private void showWinDialog() {
        JOptionPane.showMessageDialog(this, 
            "🎉 恭喜你完成了拼图！\n\n总步数：" + step, 
            "胜利", 
            JOptionPane.INFORMATION_MESSAGE);
    }

}
