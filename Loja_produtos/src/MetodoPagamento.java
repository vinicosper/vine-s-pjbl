public abstract class MetodoPagamento {
    protected Double preco;
    protected String numeroCartao;

    public MetodoPagamento(String numeroCartao, Double preco) {
        this.numeroCartao = numeroCartao;
        this.preco = preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void gerarRecibo() {
        System.out.println("Recibo: Pagamento de R$" + preco + " com o cartão **** **** **** "
                + numeroCartao.substring(numeroCartao.length() - 4));
    }
}
