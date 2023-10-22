import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteNovo extends Cliente {
    
    public ClienteNovo(String nome, int cpf, String numeroCartao) {
        super(nome,cpf,numeroCartao);
    }

    public void descontoPrimeiraCompra() {
        if (verificarPrimeiraCompra()) {
            // Aplicar desconto de 30% na primeira compra
        } else {
            // Cliente não é elegível para o desconto de primeira compra
        }
    }

    private boolean verificarPrimeiraCompra() {
        // Configurar a conexão com o banco de dados
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Substitua 'sua_query_sql' pela consulta adequada para verificar as compras do cliente
            String sua_query_sql = "SELECT COUNT(*) FROM compras WHERE cliente_id = ?";

            connection = obterConexaoBancoDeDados(); // Implemente essa função para obter a conexão com o banco de dados

            statement = connection.prepareStatement(sua_query_sql);
            statement.setInt(1, this.getId()); // Supondo que o ID do cliente esteja disponível

            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int totalCompras = resultSet.getInt(1);
                return totalCompras == 0; // Retorna verdadeiro se o cliente não tem compras
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Feche todas as conexões e recursos
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
        }

        return false; // Em caso de erro, retornar falso por padrão
    }

    // Métodos para gerenciar conexão e recursos do banco de dados
    private Connection obterConexaoBancoDeDados() {
        // Implemente a lógica para obter a conexão com o banco de dados
        return null;
    }

    private void closeConnection(Connection connection) {
        // Implemente a lógica para fechar a conexão com o banco de dados
    }

    private void closeStatement(PreparedStatement statement) {
        // Implemente a lógica para fechar o PreparedStatement
    }

    private void closeResultSet(ResultSet resultSet) {
        // Implemente a lógica para fechar o ResultSet
    }
}

