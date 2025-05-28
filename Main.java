// Importa as classes necessárias da biblioteca Swing para criação da interface gráfica
import javax.swing.*;

// Importa as classes do pacote AWT (Abstract Window Toolkit) usadas no layout da interface
import java.awt.*;

public class Main {

    // Cria uma instância da classe Loja, que será usada para gerenciar os produtos, clientes e vendas
    private static Loja loja = new Loja();

    // Método principal do programa — é o ponto de entrada da aplicação Java
    public static void main(String[] args) {

        // Criação da janela principal do sistema usando a classe JFrame
        JFrame frame = new JFrame("Sistema de Cadastro e Vendas");

        // Define a ação padrão ao fechar a janela — neste caso, encerra o programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define o tamanho da janela (largura: 400px, altura: 400px)
        frame.setSize(400, 400);

        // Centraliza a janela na tela do computador
        frame.setLocationRelativeTo(null);

        // Cria um painel principal que servirá de container para os botões do menu
        JPanel panel = new JPanel();

        // Define o layout do painel como uma grade com 6 linhas, 1 coluna e espaçamento de 10px
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        // Criação dos botões que representam as funcionalidades do sistema
        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnBuscarProduto = new JButton("Buscar Produto");
        JButton btnRegistrarVenda = new JButton("Registrar Venda");
        JButton btnListarVendas = new JButton("Listar Vendas");
        JButton btnSair = new JButton("Sair");

        // Adiciona cada botão criado ao painel principal (na ordem definida acima)
        panel.add(btnCadastrarProduto);
        panel.add(btnListarProdutos);
        panel.add(btnBuscarProduto);
        panel.add(btnRegistrarVenda);
        panel.add(btnListarVendas);
        panel.add(btnSair);

        // Adiciona o painel com os botões à janela principal (frame)
        frame.add(panel);

        // Torna a janela visível para o usuário
        frame.setVisible(true);

        // Define a ação quando o botão "Cadastrar Produto" for clicado
        btnCadastrarProduto.addActionListener(e -> {
            // Solicita ao usuário o nome do livro a ser cadastrado
            String nome = JOptionPane.showInputDialog(frame, "Nome do livro:");

            // Solicita ao usuário o preço do livro (em formato de texto)
            String precoStr = JOptionPane.showInputDialog(frame, "Preço:");

            // Solicita o nome do autor do livro
            String autor = JOptionPane.showInputDialog(frame, "Autor:");

            try {
                // Converte o valor do preço de texto para double
                double preco = Double.parseDouble(precoStr);

                // Cria um novo objeto Livro com os dados informados
                Livro livro = new Livro(nome, preco, autor);

                // Cadastra o livro na loja (adiciona à lista de produtos)
                loja.cadastrarProduto(livro);

                // Exibe mensagem de sucesso para o usuário
                JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso.");

            } catch (NumberFormatException ex) {
                // Caso o valor do preço não seja numérico, exibe mensagem de erro
                JOptionPane.showMessageDialog(frame, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Define a ação para o botão "Listar Produtos"
        btnListarProdutos.addActionListener(e -> {
            // Chama o método da loja que retorna todos os produtos cadastrados em formato de texto
            String lista = loja.listarProdutos();

            // Verifica se a lista não está vazia
            if (!lista.isEmpty()) {
                // Exibe os produtos encontrados em uma caixa de diálogo
                JOptionPane.showMessageDialog(frame, "Produtos cadastrados:\n" + lista);
            } else {
                // Caso não haja produtos cadastrados, informa ao usuário
                JOptionPane.showMessageDialog(frame, "Nenhum produto cadastrado.");
            }
        });

        // Define a ação para o botão "Buscar Produto"
        btnBuscarProduto.addActionListener(e -> {
            // Solicita ao usuário o nome do produto a ser buscado
            String nomeBusca = JOptionPane.showInputDialog(frame, "Nome do produto:");

            // Busca o produto pelo nome utilizando o método da loja
            Produto produto = loja.buscarProduto(nomeBusca);

            // Verifica se o produto foi encontrado
            if (produto != null) {
                // Exibe os dados do produto encontrado
                JOptionPane.showMessageDialog(frame, "Produto encontrado:\n" + produto);
            } else {
                // Informa que o produto não foi encontrado
                JOptionPane.showMessageDialog(frame, "Produto não encontrado.");
            }
        });

        // Define a ação para o botão "Registrar Venda"
        btnRegistrarVenda.addActionListener(e -> {
            // Solicita ao usuário o nome do cliente
            String nomeCliente = JOptionPane.showInputDialog(frame, "Nome do cliente:");

            // Solicita o CPF do cliente
            String cpf = JOptionPane.showInputDialog(frame, "CPF:");

            // Solicita o nome do produto a ser vendido
            String nomeProduto = JOptionPane.showInputDialog(frame, "Nome do produto:");

            // Busca o produto na loja com base no nome informado
            Produto produto = loja.buscarProduto(nomeProduto);

            // Se o produto for encontrado, cria um objeto Cliente e registra a venda
            if (produto != null) {
                // Cria o cliente com os dados informados
                Cliente cliente = new Cliente(nomeCliente, cpf);

                // Cria uma venda associando o cliente ao produto
                Venda venda = new Venda(cliente, produto);

                // Registra a venda na loja (adiciona à lista de vendas)
                loja.registrarVenda(venda);

                // Informa o usuário que a venda foi registrada com sucesso
                JOptionPane.showMessageDialog(frame, "Venda registrada com sucesso.");

            } else {
                // Caso o produto não seja encontrado, informa ao usuário
                JOptionPane.showMessageDialog(frame, "Produto não encontrado.");
            }
        });

        // Define a ação para o botão "Listar Vendas"
        btnListarVendas.addActionListener(e -> {
            // Obtém a lista de vendas registradas na loja
            String lista = loja.listarVendas();

            // Verifica se a lista não está vazia
            if (!lista.isEmpty()) {
                // Exibe as vendas registradas
                JOptionPane.showMessageDialog(frame, "Vendas realizadas:\n" + lista);
            } else {
                // Informa que ainda não há nenhuma venda registrada
                JOptionPane.showMessageDialog(frame, "Nenhuma venda registrada.");
            }
        });

        // Define a ação para o botão "Sair"
        btnSair.addActionListener(e -> {
            // Exibe uma caixa de confirmação perguntando se o usuário realmente quer sair
            int opcao = JOptionPane.showConfirmDialog(frame, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);

            // Se o usuário escolher "Sim", encerra o sistema
            if (opcao == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Encerrando o sistema.");
                System.exit(0); // Finaliza o programa
            }
        });
    }
}
