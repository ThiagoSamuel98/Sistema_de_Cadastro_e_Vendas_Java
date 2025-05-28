// Define a classe Venda
public class Venda {
    // Atributos privados: cliente e produto relacionados à venda
    private Cliente cliente;
    private Produto produto;

    // Construtor da classe que recebe o cliente e o produto vendidos
    public Venda(Cliente cliente, Produto produto) {
        this.cliente = cliente;   // Atribui o cliente à venda
        this.produto = produto;   // Atribui o produto à venda
    }

    // Método getter para obter o cliente da venda
    public Cliente getCliente() {
        return cliente;
    }

    // Método setter para alterar o cliente da venda
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método getter para obter o produto da venda
    public Produto getProduto() {
        return produto;
    }

    // Método setter para alterar o produto da venda
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // Sobrescreve o método toString para exibir os dados da venda
    @Override
    public String toString() {
        // Exibe o nome do cliente, CPF e dados do produto
        return "Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")\n" +
               "Produto: " + produto;
    }
}
