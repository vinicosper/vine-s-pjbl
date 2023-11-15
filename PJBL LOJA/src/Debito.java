public class Debito extends MetodoPagamento implements PagAvista {
    private String mensagemProcessamento;

    public Debito(Double preco, String numeroCartao) {
        super(numeroCartao, preco);
    }

    @Override
    public void processarPagamento() {
        processarPagAvista(preco, 0); // No débito, a taxa é zero para pagamento à vista
    }

    @Override
    public void processarPagAvista(double preco, double taxa) {
        mensagemProcessamento = "Pagamento à vista no débito processado com sucesso. \n Recibo: Pagamento de R$" + preco;
    }

    public String getMensagemProcessamento() {
        return mensagemProcessamento;
    }
}