import java.util.*;

public class Utilizador {
    private String nome;
    private String numeroCartaoCidadao;
    private String numeroFiscal;
    private String telefone;
    private String morada;
    private String localidade;

    // Construtor
    public Utilizador(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade) {
        this.nome = nome;
        this.numeroCartaoCidadao = numeroCartaoCidadao;
        this.numeroFiscal = numeroFiscal;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }

    // Getters e Setters (não mostrados para brevidade)
}