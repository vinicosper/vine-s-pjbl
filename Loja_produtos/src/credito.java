public class credito extends MetodoPagamento implements PagAvista {
    public int QntParcela;
    public Double taxa;

    public credito(int QntParcela, Double taxa, Double preco, String numeroCartao) {
        super(numeroCartao, preco);
        this.QntParcela = QntParcela;
        this.taxa = taxa;
    }

    public void parcelar(Double preco, int QntParcela) {
        if (QntParcela >= 2 && QntParcela <= 6) {
            this.preco = preco / QntParcela;
            String mensagem = String.format("Sua compra será parcelada em %d vezes de R$%.2f cada.", QntParcela,
                    this.preco);
            System.out.println(mensagem);
        } else {
            System.out.println("Opção de pagamento inválida. Por favor, tente novamente.");
        }
    }

    public void processarPagAvista(double preco, double taxa) {
        if (QntParcela == 1) {
            taxa = preco * 1.10;
            this.preco = preco + taxa;
            System.out.println("Processando pagamento à vista com a taxa do credito em 10% de R$" + preco);

            gerarRecibo(preco);
        } else {
            System.out.println("Opção de pagamento inválida. Por favor, tente novamente.");
        }
    }

    private void gerarRecibo(double preco) {
        System.out.println("Recibo gerado para pagamento de R$" + preco);
    }
}
