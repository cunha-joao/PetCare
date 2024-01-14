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
import java.util.Date;

public class marcarServico {
    private JPanel marcarServico;
    private JComboBox<String> prestadoresServico;
    private JComboBox<String> locaisRecolha;
    private JComboBox<String> funcionariosLocal;
    private JComboBox<String> tipoServico;
    private JSpinner dia;
    private JSpinner mes;
    private JSpinner ano;
    private JSpinner hora;
    private JSpinner minuto;
    private JButton marcarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;
    private List<PrestadorServico> listaPrestadores;

    public marcarServico(Utilizador utilizador, JFrame marcarFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = marcarFrame;

        // Inicializar a listaPrestadores
        listaPrestadores = lerPrestadoresDoFicheiro();

        // Preencher prestadoresServico JComboBox
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
        locaisRecolha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePrestadorSelecionado = (String) prestadoresServico.getSelectedItem();
                String moradaLocalSelecionado = (String) locaisRecolha.getSelectedItem();
                if (moradaLocalSelecionado != null) {
                    preencherFuncionariosServicosLocal(moradaLocalSelecionado, nomePrestadorSelecionado);
                }
            }
        });
        marcarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected values from JComboBoxes
                String nomePrestadorSelecionado = (String) prestadoresServico.getSelectedItem();
                String moradaLocalSelecionado = (String) locaisRecolha.getSelectedItem();
                String nomeFuncionarioSelecionado = (String) funcionariosLocal.getSelectedItem();
                String tipoServicoSelecionado = (String) tipoServico.getSelectedItem();

                // Get values from JSpinners
                int selectedDia = (int) dia.getValue();
                int selectedMes = (int) mes.getValue();
                int selectedAno = (int) ano.getValue();
                int selectedHora = (int) hora.getValue();
                int selectedMinuto = (int) minuto.getValue();

                // Create a Date object with the selected values (assuming day, month, and year)
                Date dataHora = new Date(selectedAno - 1900, selectedMes - 1, selectedDia, selectedHora, selectedMinuto);

                // Find the corresponding Cliente, PrestadorServico, Local, Funcionario, and Servico objects
                if(utilizadorAtual instanceof Cliente clienteAtual){
                    PrestadorServico prestador = findPrestadorByName(nomePrestadorSelecionado);
                    Local local = findLocalByMorada(moradaLocalSelecionado, nomePrestadorSelecionado);
                    Funcionario funcionario = findFuncionarioByName(nomeFuncionarioSelecionado, moradaLocalSelecionado, nomePrestadorSelecionado);
                    Servico servico = findServicoByTipo(tipoServicoSelecionado, moradaLocalSelecionado, nomePrestadorSelecionado);

                    // Create a new Marcacao and add it to the Cliente's marcacoes list
                    Marcacao marcacao = new Marcacao(clienteAtual, prestador, local, funcionario, servico, dataHora);
                    clienteAtual.getMarcacoes().add(marcacao);
                    System.out.println("Marcação adicionada: " + marcacao);

                    JOptionPane.showMessageDialog(currentFrame, "Marcação Confirmada!");
                    currentFrame.dispose();
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


    // Preencher JComboBox locaisRecolha
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

            // Preencher a JComboBox locaisRecolha com os locais associados
            locaisRecolha.removeAllItems();
            for (Local local : locaisAssociados) {
                locaisRecolha.addItem(local.getMorada());
            }
        }
    }

    // Preencher JComboBox funcionariosLocal com a lista de funcionários associados ao local escolhido
    // Preencher JComboBox tipoServico com a lista de tipos de serviços associados ao local escolhido
    private void preencherFuncionariosServicosLocal(String moradaLocal, String nomePrestador) {
        PrestadorServico prestadorSelecionado = null;
        for (PrestadorServico prestador : listaPrestadores) {
            if (prestador.getNome().equals(nomePrestador)) {
                prestadorSelecionado = prestador;
                break;
            }
        }

        if (prestadorSelecionado != null) {
            List<Local> locaisAssociados = prestadorSelecionado.getLocaisAssociados(nomePrestador);
            // Encontre o local selecionado com base na morada
            Local localSelecionado = null;
            for (Local local : locaisAssociados) {
                if (local.getMorada().equals(moradaLocal)) {
                    localSelecionado = local;
                    break;
                }
            }
            // Verifique se o local foi encontrado
            if (localSelecionado == null) {
                return;
            }
            // Obtenha a lista de funcionários associados ao local selecionado
            List<Funcionario> funcionariosAssociados = localSelecionado.getFuncionarios();
            // Limpe e preencha a JComboBox funcionariosLocal com os nomes dos funcionários
            funcionariosLocal.removeAllItems();
            for (Funcionario funcionario : funcionariosAssociados) {
                funcionariosLocal.addItem(funcionario.getNome());
            }

            // Obtenha a lista de tipos de serviços associados ao local selecionado
            List<Servico> servicosAssociados = localSelecionado.getServicos();
            // Limpe e preencha a JComboBox tipoServico com os tipos de serviços
            tipoServico.removeAllItems();
            for (Servico serv : servicosAssociados){
                tipoServico.addItem(serv.getTipo().toString());
            }
        }
    }


    // Find PrestadorServico by name
    private PrestadorServico findPrestadorByName(String nomePrestador) {
        for (PrestadorServico prestador : listaPrestadores) {
            if (prestador.getNome().equals(nomePrestador)) {
                return prestador;
            }
        }
        return null; // Return null if not found (handle this case in your code)
    }
    // Find Local by morada within a specific PrestadorServico
    private Local findLocalByMorada(String moradaLocal, String nomePrestador) {
        PrestadorServico prestador = findPrestadorByName(nomePrestador);
        if (prestador != null) {
            for (Local local : prestador.getLocaisAssociados(nomePrestador)) {
                if (local.getMorada().equals(moradaLocal)) {
                    return local;
                }
            }
        }
        return null; // Return null if not found (handle this case in your code)
    }
    // Find Funcionario by name within a specific Local and PrestadorServico
    private Funcionario findFuncionarioByName(String nomeFuncionario, String moradaLocal, String nomePrestador) {
        Local local = findLocalByMorada(moradaLocal, nomePrestador);
        if (local != null) {
            for (Funcionario funcionario : local.getFuncionarios()) {
                if (funcionario.getNome().equals(nomeFuncionario)) {
                    return funcionario;
                }
            }
        }
        return null; // Return null if not found (handle this case in your code)
    }
    // Find Servico by type within a specific Local and PrestadorServico
    private Servico findServicoByTipo(String tipoServico, String moradaLocal, String nomePrestador) {
        Local local = findLocalByMorada(moradaLocal, nomePrestador);
        if (local != null) {
            for (Servico servico : local.getServicos()) {
                if (servico.getTipo().toString().equals(tipoServico)) {
                    return servico;
                }
            }
        }
        return null; // Return null if not found (handle this case in your code)
    }

    public JPanel getPanel(){
        return marcarServico;
    }

    private void createUIComponents() {
        SpinnerNumberModel spinnerModelDia = new SpinnerNumberModel(1, 1, 31, 1);
        SpinnerNumberModel spinnerModelMes = new SpinnerNumberModel(1, 1, 12, 1);
        SpinnerNumberModel spinnerModelAno = new SpinnerNumberModel(2024, 2024, 2030, 1);
        SpinnerNumberModel spinnerModelHora = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel spinnerModelMinuto = new SpinnerNumberModel(0, 0, 59, 1);

        // Create a JSpinner with the SpinnerNumberModel
        dia = new JSpinner(spinnerModelDia);
        mes = new JSpinner(spinnerModelMes);
        ano = new JSpinner(spinnerModelAno);
        hora = new JSpinner(spinnerModelHora);
        minuto = new JSpinner(spinnerModelMinuto);
    }
}
