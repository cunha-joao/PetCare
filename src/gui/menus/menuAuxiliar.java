package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAuxiliar extends JFrame{
    private JPanel menuAuxiliar;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;

    public menuAuxiliar(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAuxiliar.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuAuxiliar;
    }
}
