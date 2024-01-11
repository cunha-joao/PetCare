package gui;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuSecretariado extends JFrame{
    private JPanel menuSecre;
    private JButton sairButton;

    public menuSecretariado(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSecretariado.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuSecre;
    }
}
