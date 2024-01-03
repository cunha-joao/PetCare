import gui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("loginPanel"); // Cria um JFrame com o título "loginPanel"
                loginPanel login = new loginPanel(frame); // Cria uma instância da sua interface loginPanel
                frame.setContentPane(login.getPanel()); // Define o painel da sua interface como o conteúdo do JFrame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setVisible(true); // Torna a janela visível
            }
        });
    }
}