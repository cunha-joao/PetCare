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
    private List<Utilizador> utilizadores;

    public alterarDadosPessoais(Utilizador utilizador){
        this.utilizadorAtual = utilizador;
        this.utilizadores = new ArrayList<>();
        carregarUtilizadores();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(antigaPassword.getPassword());
                String newPassword = new String(novaPassword.getPassword());

                if (oldPassword.equals(utilizadorAtual.getPassword())) {
                    // Atualiza as informações do utilizador
                    utilizadorAtual.setNomeUtilizador(nomeUtilizador.getText());
                    utilizadorAtual.setPassword(newPassword);
                    utilizadorAtual.setNome(nome.getText());
                    utilizadorAtual.setNumeroCartaoCidadao(numeroCC.getText());
                    utilizadorAtual.setNumeroFiscal(numeroFiscal.getText());
                    utilizadorAtual.setTelefone(telefone.getText());
                    utilizadorAtual.setMorada(morada.getText());
                    utilizadorAtual.setLocalidade(localidade.getText());

                    // Atualiza o arquivo
                    atualizarArquivo();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha antiga incorreta!");
                }
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterarDadosPessoais.this.dispose();
            }
        });
    }

    private void carregarUtilizadores() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("utilizadores.txt"));
            for (String linha : linhas) {
                String[] userDetails = linha.split(";");
                // Assumindo que a estrutura do Utilizador é: username, password, etc.
                Utilizador u = new Utilizador(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5], userDetails[6], userDetails[7], utilizadorAtual.getTipo()); // Adicione mais parâmetros conforme necessário
                utilizadores.add(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void atualizarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("utilizadores.txt"))) {
            for (Utilizador u : utilizadores) {
                bw.write(u.getNomeUtilizador() + ";" + u.getPassword() + ";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getPanel() {
        return alterarDadosPessoais;
    }
}
