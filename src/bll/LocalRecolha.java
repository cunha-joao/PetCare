package bll;

import java.util.*;

public class LocalRecolha {
    private String morada;
    private String localidade;
    private String numeroTelefone;
    private String tipoServico;
    private List<Auxiliar> funcionarios;
    private List<Servico> servicos;

    // Construtor
    public LocalRecolha(String morada, String localidade, String numeroTelefone, String tipoServico) {
        this.morada = morada;
        this.localidade = localidade;
        this.numeroTelefone = numeroTelefone;
        this.tipoServico = tipoServico;
        this.funcionarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    public List<Auxiliar> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Auxiliar funcionario) {
        funcionarios.add(funcionario);
    }
    public List<Marcacao> consultarMarcacoes() {
        // Lógica para consultar marcações no local de recolha
        return null;
    }
}
