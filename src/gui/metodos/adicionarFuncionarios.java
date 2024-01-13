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
    private JButton cancelarButton;
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
            List<Funcionario> listaFuncionarios = lerUtilizadoresDoFicheiro();
            for (Funcionario funcionario : listaFuncionarios) {
                funcionarioDisponiveis.addItem(funcionario.getNome());
            }
        }
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
            e.printStackTrace();
        }
        return funcionarios;
    }

    public JPanel getPanel() {
        return adicionarFuncionarios;
    }
}
