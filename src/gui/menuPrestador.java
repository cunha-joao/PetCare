package gui;

import bll.Local;
import bll.PrestadorServico;
import bll.Utilizador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menuPrestador extends JFrame{
    private JPanel menuPres;
    private JButton consultarMarcacoesButton;
    private JButton criarNovoLocalDeButton;
    private JButton consultarDadosPessoaisButton;
    private JButton alterarDadosPessoaisButton;
    private JButton consultarLocaisDeRecolhaButton;
    private JButton adicionarFuncionariosALocalButton;
    private JButton sairButton;
    private Utilizador utilizadorAtual;

    public menuPrestador(Utilizador utilizador) {
        this.utilizadorAtual = utilizador;

        consultarLocaisDeRecolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (utilizadorAtual instanceof PrestadorServico prestador) {
                    List<Local> locais = prestador.consultarLocaisRecolha();
                    mostrarLocais(locais);
                } else {
                    // Tratar o caso em que utilizadorAtual não é um PrestadorServico
                }
            }
        });
    }


    private void mostrarLocais(List<Local> locais) {
        PrestadorServico prestador = (PrestadorServico) utilizadorAtual; // Cast para PrestadorServico
        presconsultarlocais telaLocais = new presconsultarlocais(prestador);
        telaLocais.setVisible(true);
    }


// ... Restante do código da classe menuPrestador ...

  /*  private void mostrarLocais(List<Local> locais) {
        // Implementar a lógica para mostrar os locais
        // Exemplo: pode usar um JOptionPane para exibir os locais
        StringBuilder locaisStr = new StringBuilder();
        for (Local local : locais) {
            locaisStr.append(local.toString()).append("\n"); // Assumindo que a classe Local tem um método toString adequado
        }
        JOptionPane.showMessageDialog(this, locaisStr.toString());
    }*/

    public JPanel getPanel() {
        return menuPres;
    }
}
