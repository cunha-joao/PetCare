package gui;

import bll.Local;

import javax.swing.*;

public class adicionarFuncionarios extends JFrame{
    private JPanel adicionarFuncionarios;
    private JComboBox funcionarioDisponiveis;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JComboBox<Local> locaisDisponiveis;

    public JPanel getPanel() {
        return adicionarFuncionarios;
    }
}
