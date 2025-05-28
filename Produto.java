// Define a classe Produto como pública
public class Produto {
    // Atributos privados da classe Produto
    private String nome;
    private double preco;

    // Construtor que recebe e define o nome e o preço do produto
    public Produto(String nome, double preco) {
        this.nome = nome;     // Atribui o nome ao atributo da classe
        this.preco = preco;   // Atribui o preço ao atributo da classe
    }

    // Método getter para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Método setter para alterar o nome do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o preço do produto
    public double getPreco() {
        return preco;
    }

    // Método setter para alterar o preço do produto
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método toString sobrescrito para retornar uma representação textual do produto
    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: R$ " + String.format("%.2f", preco);
    }
}
