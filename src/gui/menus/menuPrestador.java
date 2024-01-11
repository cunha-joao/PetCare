package gui.menus;

import bll.Local;
import bll.PrestadorServico;
import bll.Utilizador;
import gui.metodos.alterarDadosPessoais;
import gui.metodos.presconsultarlocais;

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

    public menuPrestador(Utilizador utilizador) {
        this.utilizadorAtual = utilizador;

        consultarLocaisDeRecolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof PrestadorServico prestador) {
                    List<Local> locais = prestador.consultarLocaisRecolha();
                    mostrarLocais(locais);
                } else {
                    // Tratar o caso em que utilizadorAtual não é um PrestadorServico
                }
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
                // Abre a interface de alteração de dados pessoais
                alterarDadosPessoais alterarDados = new alterarDadosPessoais(utilizadorAtual);
                alterarDados.setContentPane(alterarDados.getPanel());
                alterarDados.setVisible(true);
                alterarDados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                alterarDados.pack();
                alterarDados.setVisible(true);

                // Oculta a interface atual
                menuPrestador.this.setVisible(false);

                // Adiciona um WindowListener para tornar visível a interface menuPrestador quando a interface alterarDadosPessoais for fechada
                alterarDados.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        menuPrestador.this.setVisible(true);
                    }
                });
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPrestador.this.dispose();
            }
        });
    }


    private void mostrarLocais(List<Local> locais) {
        PrestadorServico prestador = (PrestadorServico) utilizadorAtual; // Cast para PrestadorServico
        presconsultarlocais telaLocais = new presconsultarlocais(prestador);
        telaLocais.setVisible(true);
    }


// ... Restante do código da classe menuPrestador ...

  /*  private void mostrarLocais(List<Local> locais) {
        // Implementar a lógica para mostrar os locais
        // Exemplo: pode usar um JOptionPane para exibir os locais
        StringBuilder locaisStr = new StringBuilder();
        for (Local local : locais) {
            locaisStr.append(local.toString()).append("\n"); // Assumindo que a classe Local tem um método toString adequado
        }
        JOptionPane.showMessageDialog(this, locaisStr.toString());
    }*/

    public JPanel getPanel() {
        return menuPres;
    }
}
