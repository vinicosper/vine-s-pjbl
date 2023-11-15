

public class Cliente {
    protected String nome;
    protected String cpf;
    protected String senha;
    protected String numero_cartao;
    protected int qtd_compras;

    public Cliente(String nome, String cpf, String senha, String nuemro_cartao, int qtd_compras){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.numero_cartao = nuemro_cartao;
        this.qtd_compras = qtd_compras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public int getQtd_compras() {
        return qtd_compras;
    }

    public void setQtd_compras(int qtd_compras) {
        this.qtd_compras = qtd_compras;
    }
}
