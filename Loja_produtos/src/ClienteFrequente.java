import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFrequente extends Cliente {

    public ClienteFrequente(String nome, int cpf, String numeroCartao) {
        super(nome, cpf, numeroCartao);
    }

    public void descontoFidelidade() {
        if (verificarComprasAnteriores()) {
            // Aplicar desconto de fidelidade
        } else {
            // Cliente não possui compras anteriores
        }
    }

    public void aplicarDescontoClienteFrequente(double valorDaCompra) {
        // Aplicar desconto de 20% no valor da compra
        double desconto = valorDaCompra * 0.20;
        double valorComDesconto = valorDaCompra - desconto;
        System.out.println("Desconto aplicado: 20%");
        System.out.println("Valor da compra com desconto: " + valorComDesconto);
    }

    private boolean verificarComprasAnteriores() {
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
                return totalCompras > 0;
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
        // implementar a conexão com o banco de dados
        return null;
    }

    private void closeConnection(Connection connection) {
        // implementar para fechar a conexão com o banco de dados
    }

    private void closeStatement(PreparedStatement statement) {
        // implementar para fechar o PreparedStatement
    }

    private void closeResultSet(ResultSet resultSet) {
        // implementar para fechar o ResultSet
    }
}

