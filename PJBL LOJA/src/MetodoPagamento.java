public abstract class MetodoPagamento {
    protected Double preco;
    protected String numeroCartao;

    public MetodoPagamento(String numeroCartao, Double preco) {
        this.numeroCartao = numeroCartao;
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public abstract void processarPagamento(); // Declarado como abstrato, deve ser implementado pelas subclasses

    public void gerarRecibo() {
        System.out.println("Recibo: Pagamento de R$" + preco +
                numeroCartao.substring(numeroCartao.length() - 4));
    }

    public abstract String getMensagemProcessamento();

}
