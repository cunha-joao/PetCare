package gui.metodos;

import bll.Estado;
import bll.Marcacao;
import bll.Secretario;
import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class alterarEstadoMarcacao {
    private JPanel alterarEstadoMarcacao;
    private JComboBox marcacoesDisponiveis;
    private JComboBox novoEstado;
    private JButton confirmarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public alterarEstadoMarcacao(Utilizador utilizador, JFrame alterarEstadoFrame) {
        this.utilizadorAtual = utilizador;
        this.currentFrame = alterarEstadoFrame;

        if (utilizadorAtual instanceof Secretario secretario) {
            List<Marcacao> marcacoes = secretario.consultarMarcacoes();

            // Preencher a JComboBox marcacoesDisponiveis
            for (Marcacao marcacao : marcacoes) {
                marcacoesDisponiveis.addItem(marcacao);
            }
            confirmarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (marcacoesDisponiveis.getSelectedItem() != null) {
                        Marcacao marcacaoSelecionada = (Marcacao) marcacoesDisponiveis.getSelectedItem();
                        String novoEstadoSelecionado = (String) novoEstado.getSelectedItem();

                        Estado novoEstadoEnum = Estado.valueOf(novoEstadoSelecionado);
                        marcacaoSelecionada.setEstado(novoEstadoEnum);

                        JOptionPane.showMessageDialog(currentFrame, "Estado da marcação alterado para: " + novoEstadoEnum);

                    } else {
                        JOptionPane.showMessageDialog(currentFrame, "Nenhuma marcação selecionada.");
                    }
                }
            });
        }
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel(){
        return alterarEstadoMarcacao;
    }
}
