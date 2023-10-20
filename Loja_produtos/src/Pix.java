public class Pix extends MetodoPagamento implements PagAvista {
    public Pix(Double preco){
        super(preco);
    
}
public void processarPagAvista(double preco, double taxa){

    System.out.println("Processando pagamento no pix de R$" + preco);

    gerarRecibo(preco);
   }
private void gerarRecibo(double preco) {
    System.out.println("Recibo gerado para pagamento de R$" + preco);
}
}
