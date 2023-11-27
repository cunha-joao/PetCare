import java.util.*;

public class Cliente extends Utilizador {
    private List<Marcacao> marcacoes;
    private List<Servico> servicosContratados;

    public Cliente(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                   String numeroFiscal, String telefone, String morada, String localidade) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade);
        this.marcacoes = new ArrayList<>();
        this.servicosContratados = new ArrayList<>();
    }

    public List<Marcacao> consultarMarcacoes() {
        return marcacoes;
    }

    public List<Servico> consultarServiçosContratados() {
        return servicosContratados;
    }

    public void realizarPagamento(Marcacao marcacao, double valor) {
        marcacao.setEstado(Estado.CONFIRMADO);
    }
}

