public class Pix extends MetodoPagamento implements PagAvista {
    private String mensagemProcessamento;

    public Pix(Double preco, String numeroCartao) {
        super(numeroCartao, preco);
    }

    @Override
    public void processarPagamento() {
        processarPagAvista(preco, 0); // No Pix, a taxa é zero para pagamento à vista
    }

    @Override
    public void processarPagAvista(double preco, double taxa) {
        mensagemProcessamento = "Pagamento instantâneo no Pix processado com sucesso. \n Recibo: Pagamento de R$" + preco;
    }

    public String getMensagemProcessamento() {
        return mensagemProcessamento;
    }
}