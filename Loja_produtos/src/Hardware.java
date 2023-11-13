import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hardware extends Produto {
    private int quantidade;
    private String descricao;
    private String marca;

    // Construtor
    public Hardware(int id, String nome, Double preco, int quantidade, String descricao, String marca) {
        super(id, nome, preco);
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
    }

    // Método para recuperar hardware do banco de dados pelo ID
    public static Hardware getHardwareById(int id) {
        try {
            Connection conn = Conexao.getConexao();
            String query = "SELECT * FROM hardware WHERE ID_Hardware = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                String descricao = rs.getString("descricao");
                String marca = rs.getString("marca");
                Double preco = rs.getDouble("preco");

                return new Hardware(id, null, preco, quantidade, descricao, marca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
