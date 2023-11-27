import java.util.*;

public class Cliente extends Utilizador {
    private List<Marcacao> marcacoes;

    public Cliente(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone,
                   String morada, String localidade) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
        this.marcacoes = new ArrayList<>();
    }

    public List<Marcacao> getMarcacoes() {
        return marcacoes;
    }
}
