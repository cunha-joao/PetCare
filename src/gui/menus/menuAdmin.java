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
        consultarMenuDeClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuCliente menuCli = new menuCliente(utilizador);
                menuCli.setContentPane(menuCli.getPanel());
                menuCli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuCli.pack();
                menuCli.setVisible(true);
            }
        });

        consultarMenuDePrestadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrestador menuPres = new menuPrestador(utilizador);
                menuPres.setContentPane(menuPres.getPanel());
                menuPres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuPres.pack();
                menuPres.setVisible(true);
            }
        });

        consultarMenuDeAuxiliarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAuxiliar menuAux = new menuAuxiliar(utilizador);
                menuAux.setContentPane(menuAux.getPanel());
                menuAux.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuAux.pack();
                menuAux.setVisible(true);
            }
        });
    }

    public JPanel getPanel() {
        return menuAdmin;
    }
}
