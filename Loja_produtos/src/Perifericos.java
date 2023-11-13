import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Perifericos extends Produto {
    private int quantidade;
    private String descricao;
    private String marca;

    // Construtor
    public Perifericos(int id, String nome, Double preco, int quantidade, String descricao, String marca) {
        super(id, nome, preco);
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.marca = marca;
    }

    // Método para recuperar periférico do banco de dados pelo ID
    public static Perifericos getPerifericoById(int id) {
        try {
            Connection conn = Conexao.getConexao();
            String query = "SELECT * FROM perifericos WHERE ID_periferico = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                String descricao = rs.getString("descricao");
                String marca = rs.getString("marca");
                Double preco = rs.getDouble("preco");

                return new Perifericos(id, null, preco, quantidade, descricao, marca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
