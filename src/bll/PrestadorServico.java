package bll;

import java.util.ArrayList;
import java.util.*;

public class PrestadorServico extends Utilizador {
    private List<LocalRecolha> locaisRecolha;
    private List<Auxiliar> funcionarios;

    // Construtor
    public PrestadorServico(String nomeUtilizador, String password, String nome,
                            String numeroCartaoCidadao, String numeroFiscal, String telefone,
                            String morada, String localidade, TipoUtilizador tipo) {
        super(nomeUtilizador, password, nome, numeroCartaoCidadao, numeroFiscal, telefone,
                morada, localidade, tipo);
        this.locaisRecolha = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public List<LocalRecolha> getLocaisRecolha() {
        return locaisRecolha;
    }

    public void registarNovoLocalRecolha(LocalRecolha local) {
        locaisRecolha.add(local);
    }

    public void consultarAlterarDados() {
        // Lógica para consultar e alterar dados do prestador de serviço
    }

    public void confirmarAnularMarcacao(Marcacao marcacao, boolean confirmar) {
        // Lógica para confirmar ou anular marcação
    }
}
