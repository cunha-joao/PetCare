package gui.metodos;

import bll.Local;
import bll.PrestadorServico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class consultarLocais extends JFrame {
    private JPanel consultarLocais;
    private JComboBox<String> comboBoxLocais;
    private JTextArea textAreaInfo;
    private JButton sairButton;
    private PrestadorServico prestador;
    private JFrame currentFrame;

    public consultarLocais(PrestadorServico prestador, JFrame locaisFrame) {
        this.prestador = prestador;
        this.currentFrame = locaisFrame;

        comboBoxLocais = new JComboBox<>();
        textAreaInfo = new JTextArea();
        textAreaInfo.setEditable(false);

        System.out.println("Current prestadorLocaisMap: " + PrestadorServico.getPrestadorLocaisMap());
        List<Local> locais = PrestadorServico.getPrestadorLocaisMap().get(prestador);

        if (locais == null || locais.isEmpty()) {
            System.out.println("No locations found for Prestador: " + prestador);
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

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
            }
        });
    }

    public JPanel getPanel() {
        return consultarLocais;
    }
}


