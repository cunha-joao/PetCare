package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuEducador extends JFrame{
    private JPanel menuEdu;
    private JButton sairButton;

    public menuEducador(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuEducador.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuEdu;
    }
}
