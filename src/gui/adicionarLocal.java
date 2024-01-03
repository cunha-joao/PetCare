package gui;

import javax.swing.*;
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

    public adicionarLocal() {
        // ... inicialização de outros componentes ...

        List<String> utilizadores = lerUtilizadoresDoFicheiro();
        for (String utilizador : utilizadores) {
            funcionarios.addItem(utilizador);
        }
    }
    private List<String> lerUtilizadoresDoFicheiro() {
        List<String> utilizadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                // Supondo que o nome do utilizador esteja na primeira posição
                utilizadores.add(userDetails[2]);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Ou outro tratamento de erro
        }
        return utilizadores;
    }

    public JPanel getPanel() {
        return adicionarLocal;
    }
}
