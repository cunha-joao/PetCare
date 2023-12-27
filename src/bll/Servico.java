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

    public void adicionarProdutoAssociado(String produto) {
        produtosAssociados.add(produto);
    }
}