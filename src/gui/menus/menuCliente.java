package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuCliente extends JFrame{
    private JPanel menuCli;
    private JButton marcacaoButton;
    private JButton pagarServicoButton;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;

    public menuCliente(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuCliente.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuCli;
    }
}
