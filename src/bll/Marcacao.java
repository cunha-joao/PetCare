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

    //Getters
    public Cliente getCliente() {

        return cliente;
    }

    public PrestadorServico getPrestadorServico() {

        return prestadorServico;
    }

    public Local getLocal() {

        return local;
    }

    public Funcionario getFuncionario() {

        return funcionario;
    }

    public Servico getServico() {

        return servico;
    }

    public Date getDataHora() {

        return dataHora;
    }

    public Estado getEstado() {

        return estado;
    }

    public void setEstado(Estado estado) {

        this.estado = estado;
    }
}
