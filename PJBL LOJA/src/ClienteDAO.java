import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ClienteDAO extends Cliente {

    public ClienteDAO(String nome, String cpf, String senha, String numero_cartao, int qtd_compras) {
        super(nome, cpf, senha, numero_cartao, qtd_compras);
    }
    


    public boolean verificarLogin(String nomeUsuario, String senhaUsuario) {
        String sql = "SELECT * FROM cliente WHERE nome_cliente = ? AND senha = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nomeUsuario);
            ps.setString(2, senhaUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cadastrarCliente(String nome, String cpf, String senha, String numero_cartao, int qtd_compras) {
        String sql = "INSERT INTO cliente (nome_cliente, cpf, senha, numero_cartao, qtd_compras) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, senha);
            ps.setString(4, numero_cartao);
            ps.setInt(5, qtd_compras);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

}