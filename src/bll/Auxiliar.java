package bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Auxiliar extends Utilizador implements Serializable {

    private List<Marcacao> marcacoes;

    public Auxiliar(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                         String numeroFiscal, String telefone, String morada, String localidade,
                         TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
    }

    public List<Marcacao> consultarMarcacoes() {
        // Ensure that marcacoes is not null and return it
        if (marcacoes == null) {
            marcacoes = new ArrayList<>(); // Initialize the list if it's null
        }
        return marcacoes;
    }
}
