import java.util.*;

public class PrestadorServico extends Utilizador {
    private List<LocalRecolha> locaisRecolha;

    // Construtor
    public PrestadorServico(String nome, String numeroCartaoCidadao, String numeroFiscal,
                            String telefone, String morada, String localidade) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
        this.locaisRecolha = new ArrayList<>();
    }

    public List<LocalRecolha> getLocaisRecolha() {
        return locaisRecolha;
    }

    public void registarNovoLocalRecolha(LocalRecolha local) {
        locaisRecolha.add(local);
    }
}
