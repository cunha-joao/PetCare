package gui;

import bll.Utilizador;

import javax.swing.*;

public class menuCliente extends JFrame{
    private JPanel menuCli;
    private JButton marcacaoButton;
    private JButton pagarServicoButton;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;

    public menuCliente(Utilizador utilizador){}

    public JPanel getPanel() {
        return menuCli;
    }
}
