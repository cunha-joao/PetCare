import java.util.*;
public class Marcacao {
    private Cliente cliente;
    private PrestadorServico prestadorServico;
    private LocalRecolha localRecolha;
    private Funcionario funcionario;
    private Servico servico;
    private Date dataHora;
    private String estado;

    // Construtor
    public Marcacao(Cliente cliente, PrestadorServico prestadorServico, LocalRecolha localRecolha, Funcionario funcionario, Servico servico, Date dataHora) {
        this.cliente = cliente;
        this.prestadorServico = prestadorServico;
        this.localRecolha = localRecolha;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.estado = "Pendente"; // Estado inicial
    }

    public void confirmarServiço() {
        this.estado = "Confirmado";
        // Lógica para adicionar produtos/serviços complementares e pagamento
    }

    public void anularServiço(String razao) {
        this.estado = "Anulado";
        // Lógica para lidar com a anulação e a razão fornecida
    }

    // Outros métodos relacionados à Marcação
}
