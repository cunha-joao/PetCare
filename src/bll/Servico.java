package bll;

import java.util.*;

public class Servico {
    private TipoServico tipo;
    private double preco;
    private List<String> produtosAssociados;

    // Construtor
    public Servico(TipoServico tipo) {
        this.tipo = tipo;
        this.preco = 14.99;
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

    public String toString(){
        return "Tipo de Serviço: " + tipo.toString() + "; Preço: " + preco + "€; Produtos Associados: " + produtosAssociados;
    }
}