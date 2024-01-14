package gui.menus;

import bll.Cliente;
import bll.Marcacao;
import bll.Utilizador;
import gui.metodos.marcarServico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


public class menuCliente extends JFrame{
    private JPanel menuCli;
    private JButton marcacaoButton;
    private JButton pagarServicoButton;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuCliente(Utilizador utilizador, JFrame cliFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = cliFrame;

        marcacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame marcarFrame = new JFrame("Marcar Serviço");
                marcarServico marcServico = new marcarServico(utilizadorAtual, marcarFrame);
                marcarFrame.setContentPane(marcServico.getPanel());
                marcarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                marcarFrame.setSize(300, 300);
                marcarFrame.setVisible(true);

                currentFrame.setVisible(false);

                marcarFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof Cliente) {
                    Cliente cliente = (Cliente) utilizadorAtual;
                    List<Marcacao> marcacoes = cliente.getMarcacoes();

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
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuCli;
    }
}
