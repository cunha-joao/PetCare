package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuVeterinario extends JFrame{
    private JPanel menuVet;
    private JButton sairButton;

    public menuVeterinario(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuVeterinario.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuVet;
    }
}
