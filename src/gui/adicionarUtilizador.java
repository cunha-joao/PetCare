package gui;

import bll.TipoUtilizador;
import bll.Utilizador;
import javax.swing.*;
import java.io.IOException;

public class adicionarUtilizador {
    private JPanel Registar;
    private JButton registarButton;
    private JTextField utilizador;
    private JPasswordField password;
    private JTextField nome;
    private JTextField numeroCC;
    private JTextField numeroFiscal;
    private JTextField telefone;
    private JTextField morada;
    private JTextField localidade;
    private JButton voltarButton;
    private JComboBox tipoUtilizadores;
    private JLabel tipo;

    private JFrame currentFrame; // Referência ao JFrame atual

    public adicionarUtilizador(JFrame currentFrame) {
        this.currentFrame = currentFrame;

        registarButton.addActionListener(e -> registrarUtilizador());
        voltarButton.addActionListener(e -> currentFrame.dispose()); // Fecha a janela atual
    }

    private void registrarUtilizador() {
        try {
            String tipoSelecionadoString = (String) tipoUtilizadores.getSelectedItem();
            TipoUtilizador tipoSelecionado = TipoUtilizador.fromString(tipoSelecionadoString);

            Utilizador novoUtilizador = new Utilizador(
                    utilizador.getText(),
                    new String(password.getPassword()),
                    nome.getText(),
                    numeroCC.getText(),
                    numeroFiscal.getText(),
                    telefone.getText(),
                    morada.getText(),
                    localidade.getText(),
                    tipoSelecionado
            );

            Utilizador.adicionarUtilizador(novoUtilizador);
            JOptionPane.showMessageDialog(Registar, "Utilizador registrado com sucesso!");
            currentFrame.dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Registar, "Erro ao registrar utilizador: " + ex.getMessage());
        }
    }

    public JPanel getPanel() {
        return Registar;
    }
}
