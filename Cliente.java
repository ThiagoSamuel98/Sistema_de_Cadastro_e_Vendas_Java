// Classe Cliente representa um comprador com CPF validado
// Declaração da classe Cliente com atributos nome e CPF
public class Cliente {
    // Atributo que armazena o nome do cliente
    private String nome;
    // Atributo que armazena o CPF do cliente
    private String cpf;

    // Construtor que inicializa o cliente com nome e CPF
    public Cliente(String nome, String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }
        // Atribui o valor do parâmetro nome ao atributo nome
        this.nome = nome;
        // Atribui o valor do parâmetro cpf ao atributo cpf
        this.cpf = cpf;
    }

    // Método getter que retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método getter que retorna o CPF do cliente
    public String getCpf() {
        return cpf;
    }

    @Override
    // Método que retorna uma representação textual do cliente
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}
