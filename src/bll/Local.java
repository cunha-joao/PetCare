package bll;

import java.util.*;

public class Local {
    private String morada;
    private String localidade;
    private String numeroTelefone;
    private List<Funcionario> funcionarios;
    private List<Servico> servicos;

    public Local(String morada, String localidade, String numeroTelefone) {
        this.morada = morada;
        this.localidade = localidade;
        this.numeroTelefone = numeroTelefone;
        this.funcionarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

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

    public List<Servico> getServicos() {
        return servicos;
    }

    public String toString(){
        return "Morada: " + getMorada() + "; Localidade: " + getLocalidade() + "; Telefone: " + getNumeroTelefone();
    }
}
