public class Debito extends MetodoPagamento implements PagAvista {
    public Debito(int QntParcela, Double taxa, Double preco, String numeroCartao) {
        super(numeroCartao, preco);
    }

    public void processarPagAvista(double preco, double taxa) {

        System.out.println("Processando pagamento à vista de R$" + preco);

        gerarRecibo(preco);
    }

    private void gerarRecibo(double preco) {
        System.out.println("Recibo gerado para pagamento de R$" + preco);
    }
}
