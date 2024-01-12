import gui.metodos.loginPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame loginFrame = new JFrame("Login");
                loginPanel login = new loginPanel(loginFrame);
                loginFrame.setContentPane(login.getPanel());
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                loginFrame.setVisible(true);
            }
        });
    }
}
