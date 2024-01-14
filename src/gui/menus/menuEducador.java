package gui.menus;

import bll.Auxiliar;
import bll.Educador;
import bll.Marcacao;
import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menuEducador extends JFrame{
    private JPanel menuEdu;
    private JButton sairButton;
    private JButton consultarMarcacoesButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuEducador(Utilizador utilizador, JFrame eduFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = eduFrame;

        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof Educador educador) {
                    // Correct the variable name here
                    List<Marcacao> marcacoes = educador.consultarMarcacoes();

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
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return menuEdu;
    }
}
