package bll;

import java.util.*;

public class Servico {
    private TipoServico tipo;
    private double preco;
    private List<String> produtosAssociados;

    // Construtor
    public Servico(TipoServico tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
        this.produtosAssociados = new ArrayList<>();
    }

    //Getters

    public TipoServico getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public List<String> getProdutosAssociados() {
        return produtosAssociados;
    }
}