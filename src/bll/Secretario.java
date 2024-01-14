package bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Secretario extends Utilizador implements Serializable {
    private List<Marcacao> marcacoes;

    public Secretario(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                    String numeroFiscal, String telefone, String morada, String localidade,
                    TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
    }

    public List<Marcacao> consultarMarcacoes() {
        if (marcacoes == null) {
            marcacoes = new ArrayList<>();
        }
        return marcacoes;
    }
}
