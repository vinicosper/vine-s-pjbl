public abstract class Cliente {
        protected String nome;
        protected int cpf;
        protected String numeroCartao;

        public Cliente(String nome, int cpf, String numeroCartao) {
                this.nome = nome;
                this.cpf = cpf;
                this.numeroCartao = numeroCartao;
        }

        public void comprar(MetodoPagamento metodoPagamento, Double valorCompra) {
                System.out.println(nome + " está coamprando...");

                metodoPagamento.setPreco(valorCompra);
                metodoPagamento.setNumeroCartao(numeroCartao);
                // metodoPagamento.processarPagamento();

                System.out.println(nome + " comprou um total de R$" + valorCompra);
        }

        public String getNome() {
                return nome;
        }

        public String getNumeroCartao() {
                return numeroCartao;
        }
}
