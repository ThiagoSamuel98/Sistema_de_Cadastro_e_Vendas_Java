// Importa a classe ArrayList da biblioteca java.util para manipulação de listas
import java.util.ArrayList;

// Define a classe Venda que representa uma venda realizada por um cliente
public class Venda {
    // Atributo que representa o cliente que realizou a venda
    private Cliente cliente; // Cliente associado à venda

    // Lista de produtos incluídos na venda
    private ArrayList<Produto> produtos = new ArrayList<>(); // Lista de produtos da venda

    // Construtor da classe Venda que recebe um cliente como parâmetro
    public Venda(Cliente cliente) {
        // Atribui o cliente passado ao atributo da classe
        this.cliente = cliente;
    }

    // Método público para adicionar um produto à lista de produtos da venda
    public void adicionarProduto(Produto produto) {
        // Adiciona o produto na lista de produtos da venda
        produtos.add(produto);
    }

    // Método que calcula o valor total da venda
    public double calcularTotal() {
        // Inicializa o total com zero
        double total = 0;

        // Percorre todos os produtos na lista de produtos
        for (Produto p : produtos) {
            // Soma o preço de cada produto ao total
            total += p.getPreco();
        }

        // Retorna o valor total da venda
        return total;
    }

    // Método toString sobrescrito para retornar uma descrição textual da venda
    public String toString() {
        // Cria uma StringBuilder para montar a descrição dos produtos comprados
        StringBuilder detalhesProdutos = new StringBuilder();
        for (Produto p : produtos) {
            // Adiciona o nome e o preço de cada produto
            detalhesProdutos.append("  - ").append(p.getNome()).append(" (R$ ").append(p.getPreco()).append(")\n");
        }

        // Retorna uma string contendo o nome do cliente, os produtos comprados e o total da venda formatado
        return "Cliente: " + cliente.getNome() + "\nProdutos comprados:\n" + detalhesProdutos.toString() + "Total pago: R$ " + calcularTotal();
    }
}
