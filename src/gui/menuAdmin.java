package gui;

import bll.Utilizador;

import javax.swing.*;

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

    public menuAdmin(Utilizador utilizador){}

    public JPanel getPanel() {
        return menuAdmin;
    }
}
