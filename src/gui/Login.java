package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login {
    private JPanel Login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton entrarButton;
    private JButton registarButton;

    private JFrame parentFrame; // Referência ao JFrame pai

    public Login(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Registar");
                Registar registar = new Registar();
                frame.setContentPane(registar.getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                frame.pack();
                frame.setVisible(true);

                // Oculta a janela de login
                parentFrame.setVisible(false);
                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        parentFrame.setVisible(true);
                    }
                });
            }
        });
    }

    public JPanel getPanel() {
        return Login;
    }
}
