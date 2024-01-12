package bll;

import java.io.Serializable;
import java.util.*;

public class Cliente extends Utilizador implements Serializable {
    private List<Marcacao> marcacoes;
    private List<Servico> servicosContratados;

    public Cliente(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                   String numeroFiscal, String telefone, String morada, String localidade,
                   TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
        this.marcacoes = new ArrayList<>();
        this.servicosContratados = new ArrayList<>();
    }

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }
}

