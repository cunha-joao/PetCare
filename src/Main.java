public class Main {
    public static void main(String[] args) {
        import java.util.*;

// Exemplo de Implementação Simplificada

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

        public class Cliente extends Utilizador {
            private List<Marcação> marcações;

            // Construtor
            public Cliente(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade) {
                super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
                this.marcações = new ArrayList<>();
            }

            public List<Marcação> consultarMarcações() {
                return marcações;
            }

            // Outros métodos relacionados ao Cliente
        }

        public class PrestadorServico extends Utilizador {
            private List<LocalRecolha> locaisRecolha;

            // Construtor
            public PrestadorServico(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade) {
                super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
                this.locaisRecolha = new ArrayList<>();
            }

            public void registarNovoLocalRecolha(LocalRecolha local) {
                locaisRecolha.add(local);
            }

            public List<LocalRecolha> consultarLocaisRecolha() {
                return locaisRecolha;
            }

            // Outros métodos relacionados ao Prestador de Serviço
        }

        public class LocalRecolha {
            private String morada;
            private String localidade;
            private String numeroTelefone;
            private String tipoServico;
            private List<Funcionario> funcionarios;

            // Construtor
            public LocalRecolha(String morada, String localidade, String numeroTelefone, String tipoServico) {
                this.morada = morada;
                this.localidade = localidade;
                this.numeroTelefone = numeroTelefone;
                this.tipoServico = tipoServico;
                this.funcionarios = new ArrayList<>();
            }

            public void adicionarFuncionario(Funcionario funcionario) {
                funcionarios.add(funcionario);
            }

            public List<Funcionario> listarFuncionarios() {
                return funcionarios;
            }

            // Outros métodos relacionados ao Local de Recolha
        }

        public class Funcionario extends Utilizador {
            private String tipoFuncionario;

            // Construtor
            public Funcionario(String nome, String numeroCartaoCidadao, String numeroFiscal, String telefone, String morada, String localidade, String tipoFuncionario) {
                super(nome, numeroCartaoCidadao, numeroFiscal, telefone, morada, localidade);
                this.tipoFuncionario = tipoFuncionario;
            }

            // Outros métodos relacionados ao Funcionário
        }

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

        public class Marcação {
            private Cliente cliente;
            private PrestadorServico prestadorServico;
            private LocalRecolha localRecolha;
            private Funcionario funcionario;
            private Servico servico;
            private Date dataHora;
            private String estado;

            // Construtor
            public Marcação(Cliente cliente, PrestadorServico prestadorServico, LocalRecolha localRecolha, Funcionario funcionario, Servico servico, Date dataHora) {
                this.cliente = cliente;
                this.prestadorServico = prestadorServico;
                this.localRecolha = localRecolha;
                this.funcionario = funcionario;
                this.servico = servico;
                this.dataHora = dataHora;
                this.estado = "Pendente"; // Estado inicial
            }

            public void confirmarServiço() {
                this.estado = "Confirmado";
                // Lógica para adicionar produtos/serviços complementares e pagamento
            }

            public void anularServiço(String razao) {
                this.estado = "Anulado";
                // Lógica para lidar com a anulação e a razão fornecida
            }

            // Outros métodos relacionados à Marcação
        }

    }
}