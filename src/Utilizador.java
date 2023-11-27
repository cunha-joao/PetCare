import java.util.*;

public class Utilizador {
    private String nomeUtilizador;
    private String password;
    private String nome;
    private String numeroCartaoCidadao;
    private String numeroFiscal;
    private String telefone;
    private String morada;
    private String localidade;

    // Construtor
    public Utilizador(String nomeUtilizador, String password, String nome, String numeroCartaoCidadao,
                      String numeroFiscal, String telefone, String morada, String localidade) {
        this.nome = nome;
        this.numeroCartaoCidadao = numeroCartaoCidadao;
        this.numeroFiscal = numeroFiscal;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCartaoCidadao() {
        return numeroCartaoCidadao;
    }

    public void setNumeroCartaoCidadao(String numeroCartaoCidadao) {
        this.numeroCartaoCidadao = numeroCartaoCidadao;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}