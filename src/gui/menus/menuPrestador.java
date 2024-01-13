package gui.menus;

import bll.*;
import gui.metodos.adicionarLocal;
import gui.metodos.alterarDadosPessoais;
import gui.metodos.consultarLocais;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class menuPrestador extends JFrame{
    private JPanel menuPres;
    private JButton consultarMarcacoesButton;
    private JButton criarNovoLocalDeButton;
    private JButton consultarDadosPessoaisButton;
    private JButton alterarDadosPessoaisButton;
    private JButton consultarLocaisDeRecolhaButton;
    private JButton adicionarFuncionariosALocalButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuPrestador(Utilizador utilizador, JFrame presFrame) {
        this.utilizadorAtual = utilizador;
        this.currentFrame = presFrame;

        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof PrestadorServico) {
                    PrestadorServico prestador = (PrestadorServico) utilizadorAtual;
                    List<Marcacao> marcacoes = prestador.consultarMarcacoes();

                    if (marcacoes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ainda não tem nenhuma marcação.", "Sem Marcações", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder dadosMarcacoes = new StringBuilder();
                        for (Marcacao marcacao : marcacoes) {
                            dadosMarcacoes.append("Data: ").append(marcacao.getDataHora())
                                    .append(", Serviço: ").append(marcacao.getServico().getTipo())
                                    .append(", Estado: ").append(marcacao.getEstado())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, dadosMarcacoes.toString(), "Marcações", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A funcionalidade de consultar marcações é apenas para clientes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        criarNovoLocalDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame criarLocalFrame = new JFrame("Adicionar Local");
                adicionarLocal adLocal = new adicionarLocal(utilizadorAtual, criarLocalFrame);
                criarLocalFrame.setContentPane(adLocal.getPanel());
                criarLocalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                criarLocalFrame.pack();
                criarLocalFrame.setVisible(true);

                currentFrame.setVisible(false);

                criarLocalFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        consultarLocaisDeRecolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame consultarLocaisFrame = new JFrame("Consultar Locais de Recolha");
                consultarLocais conLocais = new consultarLocais(utilizadorAtual, consultarLocaisFrame);
                consultarLocaisFrame.setContentPane(conLocais.getPanel());
                consultarLocaisFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                consultarLocaisFrame.setSize(700, 300);
                consultarLocaisFrame.setVisible(true);

                currentFrame.setVisible(false);

                consultarLocaisFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e){
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        consultarDadosPessoaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual != null) {
                    String dados = "Nome de Utilizador: " + utilizadorAtual.getNomeUtilizador() + "\n" +
                            "Nome: " + utilizadorAtual.getNome() + "\n" +
                            "Número do Cartão de Cidadão: " + utilizadorAtual.getNumeroCartaoCidadao() + "\n" +
                            "Número Fiscal: " + utilizadorAtual.getNumeroFiscal() + "\n" +
                            "Telefone: " + utilizadorAtual.getTelefone() + "\n" +
                            "Morada: " + utilizadorAtual.getMorada() + "\n" +
                            "Localidade: " + utilizadorAtual.getLocalidade() + "\n" +
                            "Tipo: " + utilizadorAtual.getTipo();
                    JOptionPane.showMessageDialog(null, dados, "Dados Pessoais", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        alterarDadosPessoaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame alterarDadosFrame = new JFrame("Alterar Dados Pessoais");
                alterarDadosPessoais alterarDados = new alterarDadosPessoais(utilizadorAtual, alterarDadosFrame);
                alterarDadosFrame.setContentPane(alterarDados.getPanel());
                alterarDadosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                alterarDadosFrame.pack();
                alterarDadosFrame.setVisible(true);

                currentFrame.setVisible(false);

                alterarDadosFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuPres;
    }
}
