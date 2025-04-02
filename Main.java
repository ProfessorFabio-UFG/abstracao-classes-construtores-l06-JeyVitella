import java.util.Scanner;

class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    private String tipo;
    private double valor;

    // Construtores
    public Produto(int codigo) {
        this.codigo = codigo;
    }

    public Produto(int codigo, String nome) {
        this(codigo);
        this.nome = nome;
    }

    public Produto(int codigo, String nome, int quantidade) {
        this(codigo, nome);
        this.quantidade = quantidade;
    }

    public Produto(int codigo, String nome, int quantidade, String tipo, double valor) {
        this(codigo, nome, quantidade);
        this.tipo = tipo;
        this.valor = valor;
    }

    // Métodos
    public void vender(int quantidadeVendida) {
        if (quantidadeVendida > this.quantidade) {
            System.out.println("Estoque insuficiente!");
        } else {
            this.quantidade -= quantidadeVendida;
            double totalVenda = quantidadeVendida * this.valor;
            System.out.println("Venda realizada! Total: R$" + totalVenda);
        }
    }

    public void comprar(int quantidadeComprada, double novoValor) {
        this.quantidade += quantidadeComprada;
        this.valor = novoValor;
        System.out.println("Compra realizada! Novo estoque: " + this.quantidade);
    }

    public void comprar(int quantidadeComprada) {
        this.quantidade += quantidadeComprada;
        System.out.println("Compra realizada! Novo estoque: " + this.quantidade);
    }

    public void inserir(String nome, int quantidade, String tipo, double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor = valor;
    }

    public boolean igual(Produto outro) {
        return this.nome.equals(outro.nome) && this.tipo.equals(outro.tipo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Tipo: " + tipo + ", Valor: R$" + valor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = null;
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Criar novo produto");
            System.out.println("2 - Vender");
            System.out.println("3 - Comprar");
            System.out.println("4 - Consultar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            
            if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer
                    
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    
                    scanner.nextLine(); // limpar buffer
                    System.out.print("Digite o tipo: ");
                    String tipo = scanner.nextLine();
                    
                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();
                    
                    produto = new Produto(codigo, nome, quantidade, tipo, valor);
                    System.out.println("Produto criado com sucesso!");
                    break;
                case 2:
                    if (produto == null) {
                        System.out.println("Nenhum produto criado!");
                        break;
                    }
                    System.out.print("Digite a quantidade a vender: ");
                    int qtdVenda = scanner.nextInt();
                    produto.vender(qtdVenda);
                    break;
                case 3:
                    if (produto == null) {
                        System.out.println("Nenhum produto criado!");
                        break;
                    }
                    System.out.print("Digite a quantidade a comprar: ");
                    int qtdCompra = scanner.nextInt();
                    System.out.print("Digite o novo valor do produto (ou 0 para manter o atual): ");
                    double novoValor = scanner.nextDouble();
                    if (novoValor > 0) {
                        produto.comprar(qtdCompra, novoValor);
                    } else {
                        produto.comprar(qtdCompra);
                    }
                    break;
                case 4:
                    if (produto == null) {
                        System.out.println("Nenhum produto criado!");
                        break;
                    }
                    System.out.println(produto);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
