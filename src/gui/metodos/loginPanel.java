package gui.metodos;

import bll.*;
import gui.menus.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class loginPanel {
    private JPanel Login;
    private JTextField utilizador;
    private JPasswordField password;
    private JButton entrarButton;
    private JButton registarButton;
    private JFrame currentFrame;

    public loginPanel(JFrame loginFrame) {
        this.currentFrame = loginFrame;

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utilizador utilizadorLogin = login(utilizador.getText(), new
                            String(password.getPassword()));
                    if (utilizadorLogin != null) {
                        abrirInterface(utilizadorLogin);
                    } else {
                        JOptionPane.showMessageDialog(Login, "Utilizador ou senha incorretos!");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Login, "Erro ao ler o ficheiro: " +
                            ex.getMessage());
                }
            }
        });
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registarFrame = new JFrame("Registar");
                adicionarUtilizador adicionarUtil = new adicionarUtilizador(registarFrame);
                registarFrame.setContentPane(adicionarUtil.getPanel());
                registarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registarFrame.pack();
                registarFrame.setVisible(true);

                currentFrame.setVisible(false);

                registarFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
    }

    private Utilizador login(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails.length >= 3 && userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    if(Objects.equals(userDetails[8], TipoUtilizador.ADMINISTRADOR.toString())){
                        return new Administrador(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.VETERINARIO.toString())){
                        return new Veterinario(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.EDUCADOR.toString())){
                        return new Educador(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    } else if(Objects.equals(userDetails[8], TipoUtilizador.AUXILIAR.toString())){
                        return new Auxiliar(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.SECRETARIADO.toString())){
                        return new Secretario(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.CLIENTE.toString())){
                        return new Cliente(username, password, userDetails[2], userDetails[3],
                                userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                                TipoUtilizador.fromString(userDetails[8])
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.PRESTADOR.toString())){
                        return new PrestadorServico(username, password, userDetails[2], userDetails[3],
                            userDetails[4], userDetails[5], userDetails[6], userDetails[7],
                            TipoUtilizador.fromString(userDetails[8])
                        );
                    }
                }
            }
        }
        return null;
    }

    private void abrirInterface(Utilizador utilizador) {
        switch (utilizador.getTipo()) {
            case ADMINISTRADOR:
                JFrame adminFrame = new JFrame("Menu de Administrador");
                menuAdmin menuAdministrador = new menuAdmin(utilizador, adminFrame);
                adminFrame.setContentPane(menuAdministrador.getPanel());
                adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                adminFrame.pack();
                adminFrame.setVisible(true);

                currentFrame.setVisible(false);

                adminFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case VETERINARIO:
                JFrame vetFrame = new JFrame("Menu de Veterinário");
                menuVeterinario menuVet = new menuVeterinario(utilizador, vetFrame);
                vetFrame.setContentPane(menuVet.getPanel());
                vetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                vetFrame.pack();
                vetFrame.setVisible(true);

                currentFrame.setVisible(false);

                vetFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case EDUCADOR:
                JFrame eduFrame = new JFrame("Menu de Educador");
                menuEducador menuEdu = new menuEducador(utilizador, eduFrame);
                eduFrame.setContentPane(menuEdu.getPanel());
                eduFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                eduFrame.pack();
                eduFrame.setVisible(true);

                currentFrame.setVisible(false);

                eduFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case AUXILIAR:
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
                break;
            case SECRETARIADO:
                JFrame secFrame = new JFrame("Menu de Secretário");
                menuSecretariado menuSecre = new menuSecretariado(utilizador, secFrame);
                secFrame.setContentPane(menuSecre.getPanel());
                secFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                secFrame.pack();
                secFrame.setVisible(true);

                currentFrame.setVisible(false);

                secFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case CLIENTE:
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
                break;
            case PRESTADOR:
                JFrame presFrame = new JFrame("Menu de Prestador");
                menuPrestador menuPre = new menuPrestador(utilizador, presFrame);
                presFrame.setContentPane(menuPre.getPanel());
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
                break;
            default:
                // Tratar o caso padrão ou tipos desconhecidos
                break;
        }
    }

    public JPanel getPanel() {
        return Login;
    }
}
