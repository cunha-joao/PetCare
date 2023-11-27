import java.util.*;
public class Servico {
    private String tipo;
    private double preço;
    private List<String> produtosAssociados;

    // Construtor
    public Servico(String tipo, double preço) {
        this.tipo = tipo;
        this.preço = preço;
        this.produtosAssociados = new ArrayList<>();
    }

    public void adicionarProdutoAssociado(String produto) {
        produtosAssociados.add(produto);
    }

    // Outros métodos relacionados ao Serviço
}