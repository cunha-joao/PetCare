package bll;

import java.io.Serializable;

public class Educador extends Utilizador implements Serializable {
    public Educador(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                    String numeroFiscal, String telefone, String morada, String localidade,
                    TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
    }
}
