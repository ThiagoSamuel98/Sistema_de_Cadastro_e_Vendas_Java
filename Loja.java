// Importa a classe ArrayList da biblioteca util para usar listas dinâmicas
import java.util.ArrayList;

// Define a classe Loja
public class Loja {
    // Lista de produtos disponíveis na loja
    private ArrayList<Produto> produtos;
    
    // Lista de vendas realizadas pela loja
    private ArrayList<Venda> vendas;

    // Construtor da loja que inicializa as listas de produtos e vendas
    public Loja() {
        produtos = new ArrayList<>();  // Inicializa a lista de produtos
        vendas = new ArrayList<>();    // Inicializa a lista de vendas
    }

    // Método para cadastrar um novo produto na loja
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);  // Adiciona o produto à lista
    }

    // Método para listar todos os produtos como String
    public String listarProdutos() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto).append("\n");
        }
        return sb.toString();
    }

    // Método para buscar um produto pelo nome
    public Produto buscarProduto(String nome) {
        // Percorre todos os produtos
        for (Produto produto : produtos) {
            // Compara ignorando maiúsculas/minúsculas
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;  // Retorna o produto se encontrado
            }
        }
        return null;  // Retorna null se não encontrar
    }

    // Método para registrar uma nova venda
    public void registrarVenda(Venda venda) {
        vendas.add(venda);  // Adiciona a venda à lista
    }

    // Método para listar todas as vendas como String
    public String listarVendas() {
        StringBuilder sb = new StringBuilder();
        for (Venda venda : vendas) {
            sb.append(venda).append("\n\n");
        }
        return sb.toString();
    }
}
