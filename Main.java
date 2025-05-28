// Importa classes do pacote javax.swing para criar interfaces gráficas
import javax.swing.*;
// Importa classes do pacote AWT para uso de layouts
import java.awt.*;
// Importa ArrayList para armazenamento de listas
import java.util.ArrayList;

// Classe principal do programa, contendo o método main
public class Main {
    // Instância da loja, que gerencia clientes, produtos e vendas
    private static Loja loja = new Loja();

    // Método main: ponto de entrada da aplicação
    public static void main(String[] args) {
        // Cria uma janela principal com título
        JFrame frame = new JFrame("Sistema de Vendas com Livros");
        frame.setSize(400, 400); // Define tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha aplicação ao fechar a janela
        frame.setLayout(new GridLayout(7, 1)); // Define layout com 7 linhas e 1 coluna

        // Cria botões para as opções do sistema
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastrarProduto = new JButton("Cadastrar Produto/Livro");
        JButton btnRegistrarVenda = new JButton("Registrar Venda");
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnListarVendas = new JButton("Listar Vendas");
        JButton btnSair = new JButton("Sair");

        // Adiciona os botões à janela
        frame.add(btnCadastrarCliente);
        frame.add(btnCadastrarProduto);
        frame.add(btnRegistrarVenda);
        frame.add(btnListarClientes);
        frame.add(btnListarProdutos);
        frame.add(btnListarVendas);
        frame.add(btnSair);

        // Ação do botão de cadastrar cliente
        btnCadastrarCliente.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome do cliente:"); // Solicita nome do cliente
            String cpf = JOptionPane.showInputDialog("CPF (11 dígitos):"); // Solicita CPF
            try {
                if (!cpf.matches("\\d{11}")) { // Verifica se CPF contém exatamente 11 dígitos
                    throw new IllegalArgumentException("CPF inválido.");
                }
                loja.cadastrarCliente(new Cliente(nome, cpf)); // Cadastra cliente na loja
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso."); // Mensagem de sucesso
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage()); // Mostra mensagem de erro
            }
        });

        // Ação do botão de cadastrar produto
        btnCadastrarProduto.addActionListener(e -> {
            // Oferece opções de tipo de produto
            String[] opcoes = {"Produto comum", "Livro"};
            int tipo = JOptionPane.showOptionDialog(null, "Escolha o tipo:", "Tipo de Produto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            String nome = JOptionPane.showInputDialog("Nome:"); // Solicita nome do produto
            String precoStr = JOptionPane.showInputDialog("Preço:"); // Solicita preço do produto

            try {
                double preco = Double.parseDouble(precoStr); // Converte string do preço para double

                if (tipo == 1) { // Se for livro
                    String autor = JOptionPane.showInputDialog("Autor:"); // Solicita nome do autor
                    loja.cadastrarProduto(new Livro(nome, preco, autor)); // Cadastra livro
                } else {
                    loja.cadastrarProduto(new Produto(nome, preco)); // Cadastra produto comum
                }

                JOptionPane.showMessageDialog(null, "Produto cadastrado."); // Mensagem de sucesso
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Preço inválido."); // Mostra erro se preço for inválido
            }
        });

        // Ação do botão de registrar venda
        btnRegistrarVenda.addActionListener(e -> {
            String nomeCliente = JOptionPane.showInputDialog("Nome do cliente:"); // Solicita nome do cliente
            Cliente cliente = loja.buscarCliente(nomeCliente); // Busca cliente pelo nome
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado."); // Caso cliente não exista
                return;
            }

            ArrayList<Produto> itens = new ArrayList<>(); // Lista para armazenar produtos da venda
            while (true) {
                String nomeProduto = JOptionPane.showInputDialog("Nome do produto (deixe em branco para finalizar):"); // Solicita nome do produto
                if (nomeProduto == null || nomeProduto.isBlank()) break; // Sai do loop se for vazio

                Produto produto = loja.buscarProduto(nomeProduto); // Busca produto
                if (produto != null) {
                    itens.add(produto); // Adiciona produto à lista de itens
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado."); // Mensagem de erro
                }
            }

            if (!itens.isEmpty()) {
                Venda venda = new Venda(cliente); // Cria nova venda com o cliente
                for (Produto p : itens) {
                    venda.adicionarProduto(p); // Adiciona produto à venda
                }
                loja.registrarVenda(venda); // Registra a venda na loja
                JOptionPane.showMessageDialog(null, "Venda registrada. Total: R$ " + venda.calcularTotal()); // Mostra valor total
            }
        });

        // Ações dos botões de listagem
        btnListarClientes.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, loja.listarClientes()); // Exibe lista de clientes
        });

        btnListarProdutos.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, loja.listarProdutos()); // Exibe lista de produtos
        });

        btnListarVendas.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, loja.listarVendas()); // Exibe lista de vendas
        });

        // Ação do botão sair
        btnSair.addActionListener(e -> System.exit(0)); // Encerra o programa

        frame.setVisible(true); // Torna a janela visível na tela
    }
}
