package gui;

import bll.Local;
import bll.PrestadorServico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class presconsultarlocais extends JFrame {
    private JComboBox<String> comboBoxLocais;
    private JTextArea textAreaInfo;
    private PrestadorServico prestador;

    public presconsultarlocais(PrestadorServico prestador) {
        this.prestador = prestador;
        setTitle("Consultar Locais");
        setSize(400, 300);
        setLayout(new BorderLayout());

        comboBoxLocais = new JComboBox<>();
        textAreaInfo = new JTextArea();
        textAreaInfo.setEditable(false);

        List<Local> locais = prestador.consultarLocaisRecolha();
        if (locais.isEmpty()) {
            comboBoxLocais.addItem("Nenhum local encontrado");
        } else {
            for (Local local : locais) {
                comboBoxLocais.addItem(local.toString());
            }
        }

        comboBoxLocais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!locais.isEmpty()) {
                    int selectedIdx = comboBoxLocais.getSelectedIndex();
                    Local selectedLocal = locais.get(selectedIdx);
                    textAreaInfo.setText("Morada: " + selectedLocal.getMorada() +
                            "\nLocalidade: " + selectedLocal.getLocalidade() +
                            "\nNúmero de Telefone: " + selectedLocal.getNumeroTelefone());
                    textAreaInfo.repaint();
                    textAreaInfo.revalidate();
                }
            }
        });

        add(comboBoxLocais, BorderLayout.NORTH);
        add(new JScrollPane(textAreaInfo), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}


