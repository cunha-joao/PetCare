package gui.metodos;

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
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public adicionarLocal(Utilizador utilizador, JFrame criarLocalFrame) {
        this.utilizadorAtual = utilizador;
        this.currentFrame = criarLocalFrame;

        List<Funcionario> listaFuncionarios = lerUtilizadoresDoFicheiro();
        for (Funcionario funcionario : listaFuncionarios) {
            funcionarios.addItem(funcionario.getNome());
        }

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLocais();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }
    private List<Funcionario> lerUtilizadoresDoFicheiro() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (!userDetails[8].equalsIgnoreCase("CLIENTE") &&
                        !userDetails[8].equalsIgnoreCase("PRESTADOR")) {
                    funcionarios.add(new Funcionario(userDetails[0], userDetails[1], userDetails[2],
                            userDetails[3], userDetails[4], userDetails[5], userDetails[6],
                            userDetails[7], TipoUtilizador.PRESTADOR));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Ou outro tratamento de erro
        }
        return funcionarios;
    }

    public void adicionarLocais() {
        String moradaValue = morada.getText();
        String localidadeValue = localidade.getText();
        String telefoneValue = telefone.getText();

        Local novoLocal = new Local(moradaValue, localidadeValue, telefoneValue);

        // Retrieve the selected Funcionario and add it to the Local
        Funcionario selectedFuncionario = getFuncionarioByName((String) funcionarios.getSelectedItem());
        if (selectedFuncionario != null) {
            novoLocal.getFuncionarios().add(selectedFuncionario);
        }
        // Add selected services to the Local
        if (educacao.isSelected()) {
            novoLocal.getServicos().add(new Servico(TipoServico.EDUCACAO));
        }
        if (passeio.isSelected()) {
            novoLocal.getServicos().add(new Servico(TipoServico.PASSEIO));
        }
        if (tosquia.isSelected()) {
            novoLocal.getServicos().add(new Servico(TipoServico.TOSQUIA));
        }
        if (banho.isSelected()) {
            novoLocal.getServicos().add(new Servico(TipoServico.BANHO));
        }
        // Add the Local to the PrestadorServico's locaisRecolha list
        if (utilizadorAtual instanceof PrestadorServico prestador) {
            prestador.getLocaisRecolha().add(novoLocal);
            System.out.println("Local Novo: " + novoLocal.getMorada() + " " + novoLocal.getLocalidade() + " "
                    + novoLocal.getNumeroTelefone() + " " + novoLocal.getFuncionarios() + " " + novoLocal.getServicos());
        }

        JOptionPane.showMessageDialog(adicionarLocal, "Local adicionado com sucesso!");
    }

    private Funcionario getFuncionarioByName(String nomeFuncionario) {
        List<Funcionario> listaFuncionarios = lerUtilizadoresDoFicheiro();
        for(Funcionario f : listaFuncionarios){
            if(f.getNome().equals(nomeFuncionario)){
                System.out.println("Funcionario selecionado\n" + f);
                return f;
            }
        }
        return null;
    }

    public JPanel getPanel() {
        return adicionarLocal;
    }
}
