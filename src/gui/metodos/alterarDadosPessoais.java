package gui.metodos;

import bll.Utilizador;
import gui.menus.menuPrestador;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
    private JFrame currentFrame;

    public alterarDadosPessoais(Utilizador utilizador, JFrame alterarDadosFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = alterarDadosFrame;

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return alterarDadosPessoais;
    }
}
