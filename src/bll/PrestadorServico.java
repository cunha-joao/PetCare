package bll;

import java.util.ArrayList;
import java.util.*;


public class PrestadorServico extends Utilizador {
    private List<Local> locaisRecolha;
    private List<Funcionario> funcionarios;
    private List<Marcacao> marcacoes;
    private static Map<Local, PrestadorServico> localPrestadorMap = new HashMap<>();
    private static Map<PrestadorServico, List<Local>> prestadorLocaisMap = new HashMap<>();

    public PrestadorServico(String nomeUtilizador, String password, String nome,
                            String numeroCartaoCidadao, String numeroFiscal, String telefone,
                            String morada, String localidade, TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone,
                morada, localidade, tipo);
        this.locaisRecolha = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }
    public List<Local> getLocaisRecolha() {
        return locaisRecolha;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Marcacao> consultarMarcacoes() {
        if (marcacoes == null) {
            marcacoes = new ArrayList<>();
        }
        return marcacoes;
    }

    public static Map<Local, PrestadorServico> getLocalPrestadorMap() {
        return localPrestadorMap;
    }

    public static Map<PrestadorServico, List<Local>> getPrestadorLocaisMap() {
        return prestadorLocaisMap;
    }

    public List<Local> getLocaisAssociados(String nomePrestador) {
        List<Local> locaisAssociados = new ArrayList<>();
        for (Map.Entry<PrestadorServico, List<Local>> entry : prestadorLocaisMap.entrySet()) {
            PrestadorServico prestador = entry.getKey();
            if (prestador.getNome().equals(nomePrestador)) {
                locaisAssociados.addAll(entry.getValue());
            }
        }
        return locaisAssociados;
    }
}
