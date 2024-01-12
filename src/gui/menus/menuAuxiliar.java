package gui.menus;

import bll.Auxiliar;
import bll.Marcacao;
import bll.PrestadorServico;
import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menuAuxiliar extends JFrame{
    private JPanel menuAuxiliar;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;

    public menuAuxiliar(Utilizador utilizador){
        this.utilizadorAtual = utilizador;
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuAuxiliar.this.dispose();
            }
        });

        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof Auxiliar) {
                    // Correct the variable name here
                    Auxiliar auxiliar = (Auxiliar) utilizadorAtual;
                    List<Marcacao> marcacoes = auxiliar.consultarMarcacoes();

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

    }

    public JPanel getPanel() {
        return menuAuxiliar;
    }
}
