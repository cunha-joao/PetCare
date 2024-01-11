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
import java.util.Objects;
import bll.PrestadorServico;

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
    private Funcionario func;
    private JFrame currentFrame;

    public adicionarLocal(JFrame currentFrame) {
        // ... inicialização de outros componentes ...
        this.currentFrame = currentFrame;

        List<Funcionario> listaFuncionarios = lerUtilizadoresDoFicheiro();
        for (Funcionario funcionario : listaFuncionarios) {
            funcionarios.addItem(funcionario.getNome());
        }

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLocais();
                JOptionPane.showMessageDialog(adicionarLocal, "Local adicionado com sucesso!");
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

        //Adiciona o funcionario escolhido
        List<Funcionario> listaFuncionarios = lerUtilizadoresDoFicheiro();
        for(Funcionario f : listaFuncionarios){
            if(Objects.equals(funcionarios.getSelectedItem(), f.getNome())){
                novoLocal.adicionarFuncionario(f);
                func = f;
            }
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
        //Adiciona aos maps
        if (prestadorSelecionado != null) {
            prestadorSelecionado.adicionarLocalMap(novoLocal);
            prestadorSelecionado.adicionarFuncionario(func);
        }
    }

    public void setPrestadorSelecionado(PrestadorServico prestador) {
        this.prestadorSelecionado = prestador;
    }

    public JPanel getPanel() {
        return adicionarLocal;
    }
}
