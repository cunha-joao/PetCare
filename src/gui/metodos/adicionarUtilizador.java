package gui.metodos;

import bll.TipoUtilizador;
import bll.Utilizador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class adicionarUtilizador extends JFrame{
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
    private JButton sairButton;
    private JComboBox tipoUtilizadores;
    private JFrame currentFrame;

    public adicionarUtilizador(JFrame registarFrame) {
        this.currentFrame = registarFrame;

        registarButton.addActionListener(e -> registrarUtilizador());
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
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
