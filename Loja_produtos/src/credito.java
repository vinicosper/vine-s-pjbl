public class credito extends MetodoPagamento implements PagAvista{
    public int QntParcela;
    public Double taxa;
    public credito(Double preco, int QntParcela, Double taxa){
        super(preco);
        this.QntParcela = QntParcela;
        this.taxa = taxa;
    }
    public void parcelar(Double preco, int QntParcela){
        if (QntParcela == 2){
            this.preco = preco / 2;
            String mensagem = String.format("Sua parcela ficará em %s vezes", toString());
            System.out.println(mensagem);
        }else if (QntParcela == 3){          
        this.preco = preco / 3;
        String mensagem = String.format("Sua parcela ficará em %s vezes", toString());
        System.out.println(mensagem);
        }else if (QntParcela == 4){          
            this.preco = preco / 4;
            String mensagem = String.format("Sua parcela ficará em %s vezes", toString());
            System.out.println(mensagem);
            }else if (QntParcela == 5){          
                this.preco = preco / 5;
                String mensagem = String.format("Sua parcela ficará em %s vezes", toString());
                System.out.println(mensagem);
                }else if (QntParcela == 6){          
                    this.preco = preco / 6;
                    String mensagem = String.format("Sua parcela ficará em %s vezes", toString());
                    System.out.println(mensagem);
                    }else {          
                        String mensagem = String.format("Opçao invalida, por favor tente novamente!");
                        System.out.println(mensagem);
                        }

    }   
       public void processarPagAvista(double preco, double taxa){
        taxa = preco * 0.90;
        this.preco = preco + taxa;
        System.out.println("Processando pagamento à vista com a taxa do credito de R$" + preco);

        gerarRecibo(preco);
       }
    private void gerarRecibo(double preco) {
        System.out.println("Recibo gerado para pagamento de R$" + preco);
    }
}
