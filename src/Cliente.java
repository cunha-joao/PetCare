import java.util.ArrayList;
import java.util.List;

public class Cliente extends Utilizador {
    private List<Marcacao> marcacoes;
    private List<Servico> servicosContratados;

    public Cliente(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
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
        // Lógica para realizar o pagamento
        // Exemplo: atualizar estado da marcação para "pago"
        marcacao.setEstado(Estado.confirmado);
    }
}

