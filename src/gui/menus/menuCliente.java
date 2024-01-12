package gui.menus;

import bll.Administrador;
import bll.Cliente;
import bll.Marcacao;
import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class menuCliente extends JFrame{
    private JPanel menuCli;
    private JButton marcacaoButton;
    private JButton pagarServicoButton;
    private JButton consultarMarcacoesButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;

    public menuCliente(Utilizador utilizador){
        this.utilizadorAtual = utilizador;
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuCliente.this.dispose();
            }
        });

        consultarMarcacoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof Cliente) {
                    Cliente cliente = (Cliente) utilizadorAtual;
                    List<Marcacao> marcacoes = cliente.consultarMarcacoes();

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
        return menuCli;
    }
}
