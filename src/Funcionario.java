import java.util.*;
public class Funcionario extends Utilizador {
    private String tipoFuncionario;

    // Construtor
    public Funcionario(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade, String tipoFuncionario) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
        this.tipoFuncionario = tipoFuncionario;
    }

    // Outros métodos relacionados ao Funcionário
}
