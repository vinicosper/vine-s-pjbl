public abstract class Cliente {
    protected String nome;
    protected int cpf;
    protected String numeroCartao;

    public Cliente(String nome, int cpf, String numeroCartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroCartao = numeroCartao;
    }
    public String getnome(){
        return nome;
    }
    public String getnumeroCartao(){
        return numeroCartao;
    }
    public int getCpf() {
        return cpf;
    }

    public void comprar(MetodoPagamento metodoPagamento, Double valorCompra) {
        System.out.println(nome + " está comprando...");

        // Realiza a compra e processa o pagamento usando o método de pagamento selecionado
        metodoPagamento.setPreco(valorCompra);
        metodoPagamento.setNumeroCartao(numeroCartao);

        System.out.println(nome + " comprou um total de R$" + valorCompra);
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }
}

