// Define a classe Cliente
public class Cliente {
    // Atributos privados que representam os dados do cliente
    private String nome;
    private String cpf;

    // Construtor que inicializa os atributos nome e cpf
    public Cliente(String nome, String cpf) {
        this.nome = nome; // Define o nome do cliente
        this.cpf = cpf;   // Define o CPF do cliente
    }

    // Método getter para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método setter para alterar o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o CPF do cliente
    public String getCpf() {
        return cpf;
    }

    // Método setter para alterar o CPF do cliente
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
