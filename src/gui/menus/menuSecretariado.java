package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuSecretariado extends JFrame{
    private JPanel menuSecre;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuSecretariado(Utilizador utilizador, JFrame secFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = secFrame;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuSecre;
    }
}
