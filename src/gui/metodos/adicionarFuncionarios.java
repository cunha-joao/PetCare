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

public class adicionarFuncionarios{
    private JPanel adicionarFuncionarios;
    private JComboBox<String> locaisDisponiveis;
    private JComboBox funcionarioDisponiveis;
    private JButton adicionarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public adicionarFuncionarios(Utilizador utilizador, JFrame adFuncFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = adFuncFrame;

        if (utilizadorAtual instanceof PrestadorServico prestador) {
            //Fill locaisDisponiveis JComboBox
            List<Local> locais = prestador.getLocaisRecolha();
            if (!locais.isEmpty()) {
                for (Local local : locais) {
                    locaisDisponiveis.addItem(local.getMorada());
                }
            } else {
                JOptionPane.showMessageDialog(adFuncFrame, "Não tem locais associados", "Sem Locais", JOptionPane.INFORMATION_MESSAGE);
            }

            // Fill funcionariosDisponiveis JComboBox
            List<Funcionario> listaFuncionarios = lerFuncionariosDoFicheiro();
            for (Funcionario funcionario : listaFuncionarios) {
                funcionarioDisponiveis.addItem(funcionario.getNome());
            }

            adicionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome do funcionário selecionado na JComboBox funcionarioDisponiveis
                    String nomeFuncionario = (String) funcionarioDisponiveis.getSelectedItem();

                    // Obtenha a morada do local selecionado na JComboBox locaisDisponiveis
                    String moradaLocal = (String) locaisDisponiveis.getSelectedItem();

                    if (nomeFuncionario != null && moradaLocal != null) {
                        // Encontre o Local correspondente com base na morada
                        Local selectedLocal = null;
                        for (Local local : locais) {
                            if (moradaLocal.equals(local.getMorada())) {
                                selectedLocal = local;
                                break;
                            }
                        }

                        // Verifique se o Local foi encontrado
                        if (selectedLocal != null) {
                            // Encontre o Funcionário correspondente com base no nome
                            Funcionario selectedFuncionario = null;
                            for (Funcionario funcionario : listaFuncionarios) {
                                if (nomeFuncionario.equals(funcionario.getNome())) {
                                    selectedFuncionario = funcionario;
                                    break;
                                }
                            }

                            // Verifique se o Funcionário foi encontrado
                            if (selectedFuncionario != null) {
                                // Adicione o funcionário à lista de funcionários do Local
                                selectedLocal.getFuncionarios().add(selectedFuncionario);

                                // Exiba uma mensagem de sucesso ou faça o que for necessário
                                JOptionPane.showMessageDialog(currentFrame, "Funcionário adicionado ao local com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(currentFrame, "Funcionário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(currentFrame, "Local não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
        }
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    private List<Funcionario> lerFuncionariosDoFicheiro() {
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
            e.printStackTrace();
        }
        return funcionarios;
    }

    public JPanel getPanel() {
        return adicionarFuncionarios;
    }
}
