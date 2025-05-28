// A classe Livro herda da classe Produto (é um tipo específico de produto)
public class Livro extends Produto {
    // Atributo privado específico da classe Livro: autor
    private String autor;

    // Construtor da classe Livro que chama o construtor da superclasse Produto
    public Livro(String nome, double preco, String autor) {
        super(nome, preco);     // Chama o construtor da classe Produto com nome e preço
        this.autor = autor;     // Define o autor do livro
    }

    // Método getter para obter o autor do livro
    public String getAutor() {
        return autor;
    }

    // Método setter para alterar o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Sobrescreve o método toString para retornar uma representação textual do livro
    @Override
    public String toString() {
        // Inclui nome, preço (formatado com 2 casas decimais) e autor
        return super.toString() + ", Autor: " + autor;
    }
}
