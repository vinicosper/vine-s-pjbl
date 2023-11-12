import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/LOJA";
    private static final String user = "root";
    private static final String password = "PUC@1234";

    private static Connection conn;

    public static Connection getConexao(){
        try{    
            if (conn == null){
            
                conn = DriverManager.getConnection(url, user, password);

            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return conn;
    }
}
