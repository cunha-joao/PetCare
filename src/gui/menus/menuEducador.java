package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuEducador extends JFrame{
    private JPanel menuEdu;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuEducador(Utilizador utilizador, JFrame eduFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = eduFrame;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuEdu;
    }
}
