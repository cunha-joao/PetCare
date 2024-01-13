package gui.metodos;

import bll.Local;
import bll.PrestadorServico;
import bll.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class consultarLocais{
    private JPanel consultarLocais;
    private JComboBox<String> comboBoxLocais;
    private JTextArea textAreaInfo;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public consultarLocais(Utilizador utilizador, JFrame locaisFrame) {
        this.utilizadorAtual = utilizador;
        this.currentFrame = locaisFrame;

        //Define the JTextArea
        textAreaInfo.setEditable(false);
        consultarLocais.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                Dimension size = e.getComponent().getSize();
                comboBoxLocais.setPreferredSize(new Dimension(size.width, comboBoxLocais.getPreferredSize().height));
                consultarLocais.revalidate();
            }
        });

        //Fill the JComboBox
        List<Local> locais;
        if (utilizadorAtual instanceof PrestadorServico) {
            locais = ((PrestadorServico) utilizadorAtual).getLocaisRecolha();
            if (locais.isEmpty()) {
                comboBoxLocais.addItem("Nenhum local encontrado");
            } else {
                for (Local local : locais) {
                    comboBoxLocais.addItem(local.getMorada());
                }
            }
        } else {
            locais = new ArrayList<>();
            comboBoxLocais.addItem("Utilizador não é um prestador de serviço");
        }
        //After selecting an item
        comboBoxLocais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!locais.isEmpty()) {
                    int selectedIdx = comboBoxLocais.getSelectedIndex();
                    Local selectedLocal = locais.get(selectedIdx);
                    textAreaInfo.setText("Morada: " + selectedLocal.getMorada() +
                            "\nLocalidade: " + selectedLocal.getLocalidade() +
                            "\nNúmero de Telefone: " + selectedLocal.getNumeroTelefone() +
                            "\nFuncionários: " + selectedLocal.getFuncionarios() +
                            "\nServiços: " + selectedLocal.getServicos());
                }
            }
        });
    }

    public JPanel getPanel() {
        return consultarLocais;
    }
}


