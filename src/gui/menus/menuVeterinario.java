package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuVeterinario extends JFrame{
    private JPanel menuVet;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuVeterinario(Utilizador utilizador, JFrame vetFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = vetFrame;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuVet;
    }
}
