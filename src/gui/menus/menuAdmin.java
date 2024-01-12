package gui.menus;

import bll.Utilizador;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class menuAdmin extends JFrame{
    private JPanel menuAdmin;
    private JButton consultarQuantidadeDeServicosButton;
    private JButton consultarValoresPagosButton;
    private JButton desativarEmpresaButton;
    private JButton desativarPrestadorButton;
    private JButton consultarMenuDeClienteButton;
    private JButton consultarMenuDePrestadorButton;
    private JButton consultarMenuDeAuxiliarButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;
    private JFrame currentFrame;

    public menuAdmin(Utilizador utilizador, JFrame adminFrame){
        this.utilizadorAtual = utilizador;
        this.currentFrame = adminFrame;

        consultarMenuDeClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cliFrame = new JFrame("Menu de Cliente");
                menuCliente menuCli = new menuCliente(utilizador, cliFrame);
                cliFrame.setContentPane(menuCli.getPanel());
                cliFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cliFrame.pack();
                cliFrame.setVisible(true);

                currentFrame.setVisible(false);

                cliFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        consultarMenuDePrestadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame presFrame = new JFrame("Menu de Prestador");
                menuPrestador menuPres = new menuPrestador(utilizador, presFrame);
                presFrame.setContentPane(menuPres.getPanel());
                presFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                presFrame.pack();
                presFrame.setVisible(true);

                currentFrame.setVisible(false);

                presFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        consultarMenuDeAuxiliarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame auxFrame = new JFrame("Menu de Auxiliar");
                menuAuxiliar menuAux = new menuAuxiliar(utilizador, auxFrame);
                auxFrame.setContentPane(menuAux.getPanel());
                auxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                auxFrame.pack();
                auxFrame.setVisible(true);

                currentFrame.setVisible(false);

                auxFrame.addWindowListener(new WindowAdapter() {
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
        return menuAdmin;
    }
}
