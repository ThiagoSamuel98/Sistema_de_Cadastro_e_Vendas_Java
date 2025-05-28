// Classe Produto representa um item comum com nome e preço
public class Produto {
    private static int contador = 1;
    private int id;
    // Atributo que armazena o nome do produto
    private String nome;
    // Atributo que armazena o preço do produto
    private double preco;

    // Construtor que inicializa o nome e o preço do produto
    public Produto(String nome, double preco) {
        this.id = contador++;
        // Atribui o valor do parâmetro nome ao atributo nome
        this.nome = nome;
        // Atribui o valor do parâmetro preco ao atributo preco
        this.preco = preco;
    }

    // Método getter que retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Método getter que retorna o preço do produto
    public double getPreco() {
        return preco;
    }

    @Override
    // Método que retorna uma representação textual do produto
    public String toString() {
        return "ID: " + id + " | " + nome + " | R$" + preco;
    }
}
