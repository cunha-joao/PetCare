package bll;

import java.util.*;

public class Marcacao {
    private Cliente cliente;
    private PrestadorServico prestadorServico;
    private Local local;
    private Funcionario funcionario;
    private Servico servico;
    private Date dataHora;
    private Estado estado;

    // Construtor
    public Marcacao(Cliente cliente, PrestadorServico prestadorServico, Local local,
                    Funcionario funcionario, Servico servico, Date dataHora) {
        this.cliente = cliente;
        this.prestadorServico = prestadorServico;
        this.local = local;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
        this.estado = Estado.PENDENTE;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
