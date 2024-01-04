package gui;

import bll.Utilizador;

import javax.swing.*;

public class menuAuxiliar extends JFrame{
    private JPanel menuAuxiliar;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;

    public menuAuxiliar(Utilizador utilizador){}

    public JPanel getPanel() {
        return menuAuxiliar;
    }
}
