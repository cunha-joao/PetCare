package bll;

import java.util.ArrayList;
import java.util.*;


public class PrestadorServico extends Utilizador {
    private List<Local> locaisRecolha;
    private List<Funcionario> funcionarios;

    private List<Marcacao> marcacoes;

    // Map que associa Local a PrestadorServico
    private static Map<Local, PrestadorServico> localPrestadorMap = new HashMap<>();

    // Map que associa PrestadorServico a lista de locaisRecolha
    private static Map<PrestadorServico, List<Local>> prestadorLocaisMap = new HashMap<>();


    // Construtor
    public PrestadorServico(String nomeUtilizador, String password, String nome,
                            String numeroCartaoCidadao, String numeroFiscal, String telefone,
                            String morada, String localidade, TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone,
                morada, localidade, tipo);
        this.locaisRecolha = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public List<Marcacao> consultarMarcacoes() {
        // Ensure that marcacoes is not null and return it
        if (marcacoes == null) {
            marcacoes = new ArrayList<>(); // Initialize the list if it's null
        }
        return marcacoes;
    }

    public static Map<Local, PrestadorServico> getLocalPrestadorMap() {
        return localPrestadorMap;
    }

    public static Map<PrestadorServico, List<Local>> getPrestadorLocaisMap() {
        return prestadorLocaisMap;
    }

    public void adicionarLocalMap(Local local) {
        locaisRecolha.add(local);
        localPrestadorMap.put(local, this);
        prestadorLocaisMap.put(this, locaisRecolha);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Local> consultarLocaisRecolha(){
        return new ArrayList<>(locaisRecolha);
    }
}
