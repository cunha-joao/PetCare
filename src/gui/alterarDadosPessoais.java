package gui;

import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class alterarDadosPessoais extends JFrame{
    private JPanel alterarDadosPessoais;
    private JTextField nomeUtilizador;
    private JPasswordField antigaPassword;
    private JPasswordField novaPassword;
    private JTextField nome;
    private JTextField numeroCC;
    private JTextField numeroFiscal;
    private JTextField telefone;
    private JTextField morada;
    private JTextField localidade;
    private JButton confirmarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;

    public alterarDadosPessoais(Utilizador utilizador){
        this.utilizadorAtual = utilizador;
    }

    public JPanel getPanel() {
        return alterarDadosPessoais;
    }
}
