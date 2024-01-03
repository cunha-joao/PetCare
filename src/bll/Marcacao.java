package bll;

import java.util.*;

public class Marcacao {
    private Cliente cliente;
    private PrestadorServico prestadorServico;
    private LocalRecolha localRecolha;
    private Auxiliar funcionario;
    private Servico servico;
    private Date dataHora;
    private Estado estado;

    // Construtor
    public Marcacao(Cliente cliente, PrestadorServico prestadorServico, LocalRecolha localRecolha,
                    Auxiliar funcionario, Servico servico, Date dataHora) {
        this.cliente = cliente;
        this.prestadorServico = prestadorServico;
        this.localRecolha = localRecolha;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.estado = Estado.PENDENTE;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
