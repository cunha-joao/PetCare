import java.util.*;

public class Funcionario extends Utilizador {
    private TipoFuncionario tipoFuncionario;

    // Construtor
    public Funcionario(String nome, String numeroCartaoCidadao, String numeroFiscal,
                       String telefone, String morada, String localidade,
                       TipoFuncionario tipoFuncionario) {
        super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
        this.tipoFuncionario = tipoFuncionario;
    }
}
