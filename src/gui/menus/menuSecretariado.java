package gui.menus;

import bll.Marcacao;
import bll.Secretario;
import bll.Utilizador;
import gui.metodos.alterarEstadoMarcacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class menuSecretariado extends JFrame{
    private JPanel menuSecre;
    private JButton consultarMarcacoesButton;
    private JButton alterarEstadoButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuSecretariado(Utilizador utilizador, JFrame secFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = secFrame;

        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof Secretario secretario) {
                    // Correct the variable name here
                    List<Marcacao> marcacoes = secretario.consultarMarcacoes();

                    if (marcacoes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ainda não tem nenhuma marcação.", "Sem Marcações", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder dadosMarcacoes = new StringBuilder();

                        for (Marcacao marcacao : marcacoes) {
                            dadosMarcacoes.append("Cliente:\n").append(marcacao.getCliente())
                                    .append("\n\nPrestador:\n").append(marcacao.getPrestadorServico())
                                    .append("\n\nLocal de Recolha:\n").append(marcacao.getLocal())
                                    .append("\n\nFuncionário:\n").append(marcacao.getFuncionario())
                                    .append("\n\nData:\n").append(marcacao.getDataHora())
                                    .append("\n\nServiço:\n").append(marcacao.getServico().getTipo())
                                    .append("\n\nEstado:\n").append(marcacao.getEstado())
                                    .append("\n");
                        }

                        JOptionPane.showMessageDialog(null, dadosMarcacoes.toString(), "Marcações", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A funcionalidade de consultar marcações não está disponível", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        alterarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame alterarEstadoFrame = new JFrame("Alterar Estado da Marcação");
                alterarEstadoMarcacao alterarEstado = new alterarEstadoMarcacao(utilizadorAtual, alterarEstadoFrame);
                alterarEstadoFrame.setContentPane(alterarEstado.getPanel());
                alterarEstadoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                alterarEstadoFrame.pack();
                alterarEstadoFrame.setVisible(true);

                currentFrame.setVisible(false);

                alterarEstadoFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
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
        return menuSecre;
    }
}
