// Classe Livro herda de Produto e adiciona o campo autor
// Declaração da classe Livro que herda de Produto e adiciona o atributo autor
public class Livro extends Produto {
    // Atributo que armazena o autor do livro
    private String autor;

    // Construtor que inicializa nome, preço e autor do livro
    public Livro(String nome, double preco, String autor) {
        // Chama o construtor da superclasse Produto para inicializar nome e preço
        super(nome, preco);
        // Atribui o valor do parâmetro autor ao atributo autor
        this.autor = autor;
    }

    // Método getter que retorna o autor do livro
    public String getAutor() {
        return autor;
    }

    @Override
    // Método que retorna uma representação textual do livro
    public String toString() {
        return super.toString() + " | Autor: " + autor;
    }
}
