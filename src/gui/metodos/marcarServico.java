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
import java.util.Map;

public class marcarServico {
    private JPanel marcarServico;
    private JComboBox<String> prestadoresServico;
    private JComboBox<String> locaisRecolha;
    private JComboBox<String> funcionariosLocal;
    private JComboBox<String> tipoServico;
    private JFormattedTextField dataMarcacao;
    private JButton marcarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;
    private List<PrestadorServico> listaPrestadores;

    public marcarServico(Utilizador utilizador, JFrame marcarFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = marcarFrame;

        // Inicialize a lista de prestadores
        listaPrestadores = lerPrestadoresDoFicheiro();

        // Fill funcionariosDisponiveis JComboBox
        for (PrestadorServico prestador : listaPrestadores) {
            prestadoresServico.addItem(prestador.getNome());
        }

        prestadoresServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePrestadorSelecionado = (String) prestadoresServico.getSelectedItem();
                if (nomePrestadorSelecionado != null) {
                    preencherLocaisRecolha(nomePrestadorSelecionado);
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    private List<PrestadorServico> lerPrestadoresDoFicheiro() {
        List<PrestadorServico> prestadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails.length > 8 && userDetails[8].equalsIgnoreCase("PRESTADOR")) {
                    // Verifica se userDetails[8] é "PRESTADOR" antes de adicionar o Funcionario
                    prestadores.add(new PrestadorServico(userDetails[0], userDetails[1], userDetails[2],
                            userDetails[3], userDetails[4], userDetails[5], userDetails[6],
                            userDetails[7], TipoUtilizador.PRESTADOR));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prestadores;
    }

    // Método para preencher a JComboBox locaisRecolha com os locais
    private void preencherLocaisRecolha(String nomePrestador) {
        PrestadorServico prestadorSelecionado = null;
        for (PrestadorServico prestador : listaPrestadores) {
            if (prestador.getNome().equals(nomePrestador)) {
                prestadorSelecionado = prestador;
                break;
            }
        }

        if (prestadorSelecionado != null) {
            List<Local> locaisAssociados = prestadorSelecionado.getLocaisAssociados(nomePrestador);

            // Agora você pode preencher a JComboBox locaisRecolha com os locais associados
            locaisRecolha.removeAllItems();
            for (Local local : locaisAssociados) {
                locaisRecolha.addItem(local.getMorada());
            }
        }
    }

    public JPanel getPanel(){
        return marcarServico;
    }
}
