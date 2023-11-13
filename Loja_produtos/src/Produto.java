public abstract class Produto {
    protected Double preco;

    public Produto(Double preco) {
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }
}
