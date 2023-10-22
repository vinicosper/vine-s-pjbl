public class ClienteVip extends Cliente {

    public ClienteVip(String nome, int cpf, String numeroCartao) {
        super(nome, cpf, numeroCartao);
    }

    public void descontoVip() {
        if (verificarClienteVip()) {
            // Aplicar desconto VIP de 50%
        } else {
            // Cliente não é VIP
        }
    }

    private boolean verificarClienteVip() {
        // Implemente a lógica para verificar se o cliente é VIP, por exemplo, verificando no cadastro
        // Suponha que você tenha um campo "vip" em seu cadastro que indique se o cliente é VIP ou não
        //return this.isVip(); // Suponha que você tenha um método isVip() na classe Cliente
    }
}