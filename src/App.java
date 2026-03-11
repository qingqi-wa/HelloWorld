import com.afuyan.www.GUIHRDeom.Ui;

import javax.swing.*;

public class App {


    public static void main(String[] args) {
        // 在事件分发线程中启动 GUI，避免线程安全问题
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ui loginFrame = new Ui();
                loginFrame.setVisible(true);
            }
        });
    }
}
