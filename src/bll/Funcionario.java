package bll;

public class Funcionario extends Utilizador {
    private TipoFuncionario tipoFuncionario;

    // Construtor
    public Funcionario(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                       String numeroFiscal, String telefone, String morada, String localidade,
                       TipoFuncionario tipoFuncionario) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone, morada,
                localidade);
        this.tipoFuncionario = tipoFuncionario;
    }
}
