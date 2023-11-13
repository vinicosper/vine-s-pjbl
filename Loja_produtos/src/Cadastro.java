import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends Cliente {

    public Cadastro(String usuario, String senha, String nome, int cpf, int numeroCartao, int qtd_compras) {
        super(nome,cpf, senha, numeroCartao, qtd_compras);
    }

    public void cadastrarCliente() {
        try (Connection conexao = Conexao.getConexao()) {
            String sql = "INSERT INTO cliente (nome_cliente, cpf, senha, qtd_compras) VALUES ('"+nome+"', '"+cpf+"', '"+senha+"', '"+qtd_compras+"')";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, getNome());
                statement.setInt(2, getCpf());
                statement.setString(3, getsenha());
                statement.setInt(4, getqtd_compras());
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

