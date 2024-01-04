package gui;

import bll.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class adicionarLocal extends JFrame{
    private JPanel adicionarLocal;
    private JTextField morada;
    private JTextField localidade;
    private JTextField telefone;
    private JComboBox funcionarios;
    private JCheckBox educacao;
    private JCheckBox passeio;
    private JCheckBox tosquia;
    private JCheckBox banho;
    private JButton adicionarButton;
    private PrestadorServico prestadorSelecionado;
    private JFrame currentFrame;

    public adicionarLocal(JFrame currentFrame) {
        // ... inicialização de outros componentes ...
        this.currentFrame = currentFrame;

        List<String> utilizadores = lerUtilizadoresDoFicheiro();
        for (String utilizador : utilizadores) {
            funcionarios.addItem(utilizador);
        }
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLocalAoPrestador();
                JOptionPane.showMessageDialog(adicionarLocal, "Utilizador registrado com sucesso!");
                currentFrame.dispose();
            }
        });
    }
    private List<String> lerUtilizadoresDoFicheiro() {
        List<String> utilizadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (!userDetails[8].equalsIgnoreCase("CLIENTE") && !userDetails[8].equalsIgnoreCase("PRESTADOR")) {
                    // Supondo que o nome do utilizador esteja na terceira posição (índice 2)
                    utilizadores.add(userDetails[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Ou outro tratamento de erro
        }
        return utilizadores;
    }

    public void adicionarLocalAoPrestador() {
        String moradaValue = morada.getText();
        String localidadeValue = localidade.getText();
        String telefoneValue = telefone.getText();

        Local novoLocal = new Local(moradaValue, localidadeValue, telefoneValue);

        // Adiciona o funcionário selecionado
        Auxiliar funcionarioSelecionado = (Auxiliar) funcionarios.getSelectedItem();
        if (funcionarioSelecionado != null) {
            novoLocal.adicionarFuncionario(funcionarioSelecionado);
        }
        // Adiciona os serviços selecionados
        if (educacao.isSelected()) {
            novoLocal.adicionarServico(new Servico(TipoServico.EDUCACAO, 15.99));
        }
        if (passeio.isSelected()) {
            novoLocal.adicionarServico(new Servico(TipoServico.PASSEIO, 10.99));
        }
        if (tosquia.isSelected()) {
            novoLocal.adicionarServico(new Servico(TipoServico.TOSQUIA, 12.49));
        }
        if (banho.isSelected()) {
            novoLocal.adicionarServico(new Servico(TipoServico.BANHO, 12.99));
        }
        if (prestadorSelecionado != null) {
            prestadorSelecionado.adicionarLocal(novoLocal);
        }
    }

    public void setPrestadorSelecionado(PrestadorServico prestador) {
        this.prestadorSelecionado = prestador;
    }

    public JPanel getPanel() {
        return adicionarLocal;
    }
}
