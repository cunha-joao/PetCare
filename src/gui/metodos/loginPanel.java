package gui.metodos;

import bll.PrestadorServico;
import bll.TipoUtilizador;
import bll.Utilizador;
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
    private JFrame currentFrame; // Referência ao JFrame pai

    public loginPanel(JFrame frameLogin) {
        this.currentFrame = frameLogin;
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAdicionar = new JFrame("Registar");
                adicionarUtilizador adicionarUtil = new adicionarUtilizador(frameAdicionar);
                adicionarUtil.setContentPane(adicionarUtil.getPanel());
                adicionarUtil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                adicionarUtil.pack();
                adicionarUtil.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                adicionarUtil.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
            }
        });
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utilizador utilizadorLogin = login(utilizador.getText(), new
                            String(password.getPassword()));
                    if (utilizadorLogin != null) {
                        abrirInterface(utilizadorLogin); // Abre a interface com base no tipo
                    } else {
                        JOptionPane.showMessageDialog(Login, "Utilizador ou senha incorretos!");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Login, "Erro ao ler o ficheiro: " +
                            ex.getMessage());
                }
            }
        });
    }

    private Utilizador login(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails.length >= 3 && userDetails[0].equals(username) && userDetails[1]
                        .equals(password)) {
                    // Cria um objeto com os detalhes lidos do arquivo
                    if(Objects.equals(userDetails[8], TipoUtilizador.ADMINISTRADOR.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.VETERINARIO.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.EDUCADOR.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    } else if(Objects.equals(userDetails[8], TipoUtilizador.AUXILIAR.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.SECRETARIADO.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.CLIENTE.toString())){
                        return new PrestadorServico(
                                username, // Supondo que o username é o primeiro elemento
                                password, // Supondo que a password é o segundo elemento
                                userDetails[2], // Nome
                                userDetails[3], // Número do Cartão de Cidadão
                                userDetails[4], // Número Fiscal
                                userDetails[5], // Telefone
                                userDetails[6], // Morada
                                userDetails[7], // Localidade
                                TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
                        );
                    }else if(Objects.equals(userDetails[8], TipoUtilizador.PRESTADOR.toString())){
                        return new PrestadorServico(
                            username, // Supondo que o username é o primeiro elemento
                            password, // Supondo que a password é o segundo elemento
                            userDetails[2], // Nome
                            userDetails[3], // Número do Cartão de Cidadão
                            userDetails[4], // Número Fiscal
                            userDetails[5], // Telefone
                            userDetails[6], // Morada
                            userDetails[7], // Localidade
                            TipoUtilizador.fromString(userDetails[8]) // Tipo de Utilizador
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
                // Abrir a interface de admin
                menuAdmin menuAdministrador = new menuAdmin(utilizador);
                menuAdministrador.setContentPane(menuAdministrador.getPanel());
                menuAdministrador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuAdministrador.pack();
                menuAdministrador.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuAdministrador.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case VETERINARIO:
                // Abrir a interface de veterinário
                menuVeterinario menuVet = new menuVeterinario(utilizador);
                menuVet.setContentPane(menuVet.getPanel());
                menuVet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuVet.pack();
                menuVet.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuVet.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case EDUCADOR:
                // Abrir a interface de educador
                menuEducador menuEdu = new menuEducador(utilizador);
                menuEdu.setContentPane(menuEdu.getPanel());
                menuEdu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuEdu.pack();
                menuEdu.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuEdu.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case AUXILIAR:
                // Abrir a interface de auxiliar
                menuAuxiliar menuAux = new menuAuxiliar(utilizador);
                menuAux.setContentPane(menuAux.getPanel());
                menuAux.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuAux.pack();
                menuAux.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuAux.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case SECRETARIADO:
                // Abrir a interface de secretariado
                menuSecretariado menuSecre = new menuSecretariado(utilizador);
                menuSecre.setContentPane(menuSecre.getPanel());
                menuSecre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuSecre.pack();
                menuSecre.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuSecre.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case CLIENTE:
                // Abrir a interface de cliente
                menuCliente menuCli = new menuCliente(utilizador);
                menuCli.setContentPane(menuCli.getPanel());
                menuCli.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuCli.pack();
                menuCli.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuCli.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        currentFrame.setVisible(true);
                    }
                });
                break;
            case PRESTADOR:
                // Abrir a interface de prestador
                menuPrestador menuPre = new menuPrestador(utilizador);
                menuPre.setContentPane(menuPre.getPanel());
                menuPre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                menuPre.pack();
                menuPre.setVisible(true);

                // Oculta a janela de login
                currentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                menuPre.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
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
