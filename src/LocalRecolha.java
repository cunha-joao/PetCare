import java.util.*;
public class LocalRecolha {
    private String morada;
    private String localidade;
    private String numeroTelefone;
    private String tipoServico;
    private List<Funcionario> funcionarios;

    // Construtor
    public LocalRecolha(String morada, String localidade, String numeroTelefone, String tipoServico) {
        this.morada = morada;
        this.localidade = localidade;
        this.numeroTelefone = numeroTelefone;
        this.tipoServico = tipoServico;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    // Outros métodos relacionados ao Local de Recolha
}
