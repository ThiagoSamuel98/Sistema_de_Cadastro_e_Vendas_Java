// Importa a classe ArrayList para armazenar listas
import java.util.ArrayList;

// Classe Loja gerencia clientes, produtos e vendas
public class Loja {
    // Lista que armazena os clientes cadastrados
    private ArrayList<Cliente> clientes = new ArrayList<>();
    // Lista que armazena os produtos cadastrados
    private ArrayList<Produto> produtos = new ArrayList<>();
    // Lista que armazena as vendas realizadas
    private ArrayList<Venda> vendas = new ArrayList<>();

    // Método que adiciona um novo cliente à lista de clientes
    public void cadastrarCliente(Cliente cliente) {
        // Adiciona o cliente recebido por parâmetro à lista
        clientes.add(cliente);
    }

    // Método que adiciona um novo produto à lista de produtos
    public void cadastrarProduto(Produto produto) {
        // Adiciona o produto recebido por parâmetro à lista
        produtos.add(produto);
    }

    // Método que busca um cliente pelo nome (ignorando maiúsculas/minúsculas)
    public Cliente buscarCliente(String nome) {
        for (Cliente c : clientes) {
            // Compara o nome do cliente com o nome informado
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        // Retorna null se o cliente não for encontrado
        return null;
    }

    // Método que busca um produto pelo nome (ignorando maiúsculas/minúsculas)
    public Produto buscarProduto(String nome) {
        for (Produto p : produtos) {
            // Compara o nome do produto com o nome informado
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        // Retorna null se o produto não for encontrado
        return null;
    }

    // Método que registra uma nova venda
    public void registrarVenda(Venda venda) {
        // Adiciona a venda recebida por parâmetro à lista de vendas
        vendas.add(venda);
    }

    // Método que retorna uma string com a lista de todos os clientes
    public String listarClientes() {
        StringBuilder sb = new StringBuilder("Clientes:\n");
        for (Cliente c : clientes) {
            // Adiciona cada cliente à string de retorno
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    // Método que retorna uma string com a lista de todos os produtos
    public String listarProdutos() {
        StringBuilder sb = new StringBuilder("Produtos:\n");
        for (Produto p : produtos) {
            // Adiciona cada produto à string de retorno
            sb.append(p).append("\n");
        }
        return sb.toString();
    }

    // Método que retorna uma string com a lista de todas as vendas
    public String listarVendas() {
        StringBuilder sb = new StringBuilder("Vendas:\n");
        for (Venda v : vendas) {
            // Adiciona cada venda à string de retorno
            sb.append(v).append("\n\n");
        }
        return sb.toString();
    }
}
