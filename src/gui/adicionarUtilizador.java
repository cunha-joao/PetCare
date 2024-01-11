package gui;

import bll.TipoUtilizador;
import bll.Utilizador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    public adicionarUtilizador(JFrame frame) {
        this.currentFrame = frame;

        registarButton.addActionListener(e -> registrarUtilizador());
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarUtilizador.this.dispose();
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

            // Verifica se o tipo selecionado é "Prestador"
            if (tipoSelecionado == TipoUtilizador.PRESTADOR) {
                JFrame frameLocal = new JFrame("Adicionar Local");
                adicionarLocal localPanel = new adicionarLocal(frameLocal);

                // Cria um JDialog modal
                JDialog localDialog = new JDialog(currentFrame, "Adicionar Local", true);
                localDialog.setContentPane(localPanel.getPanel());
                localDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                localDialog.pack();
                localDialog.setVisible(true); // Este método bloqueará até que o JDialog seja fechado
            }

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
