import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends Cliente {
    private String usuario;
    private String senha;

    public Cadastro(String usuario, String senha, String nome, int cpf, String numeroCartao) {
        super(nome,cpf, numeroCartao);
        this.usuario = usuario;
        this.senha = senha;
    }

    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente(nome_cliente, cpf, qtd_compras, numero_cartao) VALUES(?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(1, usuario.getCpf());
            ps.setString(1, usuario.getNome());
            ps.setString(1, usuario.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
