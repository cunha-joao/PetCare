package bll;

import java.io.Serializable;

public class Funcionario extends Utilizador implements Serializable {

    public Funcionario(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                       String numeroFiscal, String telefone, String morada, String localidade,
                       TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade, tipo);
    }

    public String toString(){
        return "Nome: " + getNome() + "; Número do CC: " + getNumeroCartaoCidadao() + "; Número Fiscal: " +
                getNumeroFiscal() + "; Telefone: " + getTelefone() + "; Morada: " + getMorada() + "; Localidade: " +
                getLocalidade() + "; Tipo: " + getTipo();
    }
}
