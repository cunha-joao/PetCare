import java.util.*;
public class PrestadorServico extends Utilizador {
    private List<LocalRecolha> locaisRecolha;

    // Construtor
    public PrestadorServico(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
        this.locaisRecolha = new ArrayList<>();
    }

    public void registarNovoLocalRecolha(LocalRecolha local) {
        locaisRecolha.add(local);
    }

    public List<LocalRecolha> consultarLocaisRecolha() {
        return locaisRecolha;
    }

    // Outros métodos relacionados ao Prestador de Serviço
}
