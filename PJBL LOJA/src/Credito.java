import java.text.DecimalFormat;

public class Credito extends MetodoPagamento implements PagAvista {

    private int qntParcela;
    private Double taxa;

    public Credito(int qntParcela, Double taxa, Double preco, String numeroCartao) {
        super(numeroCartao, preco);
        this.qntParcela = qntParcela;
        this.taxa = taxa;
    }

    @Override
    public void processarPagAvista(double preco, double taxa) {
        System.out.println("Pagamento à vista no crédito processado com sucesso.");
    }

    @Override
    public void processarPagamento() {
        if (qntParcela == 1) {
            double total = getPreco() + taxa;
            System.out.println("Pagamento à vista no crédito processado com sucesso. Valor total: R$" + total);
        } else {
            System.out.println("Pagamento à vista no crédito não disponível para mais de uma parcela.");
        }
    }

    public void parcelar() {
        if (qntParcela >= 2 && qntParcela <= 6) {
            double valorParcela = getPreco() / qntParcela;
            System.out.println("Sua compra será parcelada em " + qntParcela + " vezes de R$" + valorParcela + " cada.");
        } else {
            System.out
                    .println("Opção de pagamento inválida para parcelamento. Por favor, escolha entre 2 e 6 parcelas.");
        }
    }

    @Override
    public String getMensagemProcessamento() {
        if (qntParcela == 1) {
            double total = getPreco() + taxa;
            return "Pagamento à vista no crédito processado com sucesso. Valor total: R$" + total + "\n Recibo: Pagamento de R$" + preco ;  
        } else if (qntParcela >= 2 && qntParcela <= 6) {
            double valorParcela = getPreco() / qntParcela;
            DecimalFormat df = new DecimalFormat("#.##");
            String valorParcelaFormatado = df.format(valorParcela);
            return "Sua compra será parcelada em " + qntParcela + " vezes de R$" + valorParcelaFormatado + " cada. \n Recibo: Pagamento de R$" + preco ;
        } else {
                    
            return "Pagamento no crédito não disponível para mais de " + qntParcela + " parcelas.";
        }
    }
}

