package gui;

import bll.TipoUtilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class loginPanel {
    private JPanel Login;
    private JTextField utilizador;
    private JPasswordField password;
    private JButton entrarButton;
    private JButton registarButton;

    private JFrame parentFrame; // Referência ao JFrame pai

    public loginPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("adicionarUtilizador");
                adicionarUtilizador utilizador = new adicionarUtilizador(frame);
                frame.setContentPane(utilizador.getPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
                frame.pack();
                frame.setVisible(true);

                // Oculta a janela de login
                parentFrame.setVisible(false);

                // Adiciona um WindowListener para saber quando a janela de registro é fechada
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Torna a janela de login visível novamente
                        parentFrame.setVisible(true);
                    }
                });
            }
        });
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TipoUtilizador tipoUtilizador = login(utilizador.getText(), new String(password.getPassword()));
                    if (tipoUtilizador != null) {
                        JOptionPane.showMessageDialog(Login, "Login bem-sucedido!");
                        abrirInterfaceApropriada(tipoUtilizador); // Abre a interface com base no tipo
                    } else {
                        JOptionPane.showMessageDialog(Login, "Utilizador ou senha incorretos!");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Login, "Erro ao ler o ficheiro: " + ex.getMessage());
                }
            }
        });
    }

    private TipoUtilizador login(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("utilizadores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(";");
                if (userDetails.length >= 3 && userDetails[0].equals(username) && userDetails[1].equals(password)) {
                    return TipoUtilizador.fromString(userDetails[7]); // Supondo que o tipo está na terceira posição
                }
            }
        }
        return null;
    }
    private void abrirInterfaceApropriada(TipoUtilizador tipoUtilizador) {
        switch (tipoUtilizador) {
            case ADMIN:
                // Abrir a interface de admin
                break;
            case VETERINARIO:
                // Abrir a interface de veterinário
                break;
            case EDUCADOR:
                // Abrir a interface de veterinário
                break;
            case AUXILIAR:
                // Abrir a interface de veterinário
                break;
            case SECRETARIADO:
                // Abrir a interface de veterinário
                break;
            case CLIENTE:
                // Abrir a interface de veterinário
                break;
            case PRESTADOR:
                // Abrir a interface de veterinário
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
