package gui.menus;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAdmin extends JFrame{
    private JPanel menuAdmin;
    private JButton consultarQuantidadeDeServiçosButton;
    private JButton consultarValoresPagosButton;
    private JButton desativarEmpresaButton;
    private JButton desativarPrestadorButton;
    private JButton consultarMenuDeClienteButton;
    private JButton consultarMenuDePrestadorButton;
    private JButton consultarMenuDeAuxiliarButton;
    private JButton sairButton;

    public menuAdmin(Utilizador utilizador){
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAdmin.this.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuAdmin;
    }
}
