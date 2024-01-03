package bll;

import java.io.Serializable;

public class Veterinario extends Utilizador implements Serializable {
    public Veterinario(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                    String numeroFiscal, String telefone, String morada, String localidade,
                    TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
    }
}
