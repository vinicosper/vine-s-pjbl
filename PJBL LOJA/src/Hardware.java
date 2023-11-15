public class Hardware extends Produto {
    private String descricao;
    private String marca;

    // Construtor
    public Hardware(int id, String nome, Double preco, int quantidade, String descricao, String marca) {
        super(id, nome, preco, quantidade);
        this.descricao = descricao;
        this.marca = marca;
    }

    // Métodos getters e setters para descrição e marca, se necessário
    // ...

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
