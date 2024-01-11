package bll;

import java.util.*;

public class Local {
    private String morada;
    private String localidade;
    private String numeroTelefone;
    private List<Funcionario> funcionarios;
    private List<Servico> servicos;

    // Construtor
    public Local(String morada, String localidade, String numeroTelefone) {
        this.morada = morada;
        this.localidade = localidade;
        this.numeroTelefone = numeroTelefone;
        this.funcionarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    // Métodos Getter
    public String getMorada() {
        return morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }
    public List<Marcacao> consultarMarcacoes() {
        // Lógica para consultar marcações no local de recolha
        return null;
    }

    public String toString() {
        return morada + ";" + localidade + ";" + numeroTelefone + ";" + funcionarios + ";" +
                servicos;
    }
}
