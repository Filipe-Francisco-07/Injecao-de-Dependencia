package AgendaDeContatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
        
        public static Connection conectar() {
        	String url = "jdbc:postgresql://localhost:5432/agenda";
            String user = "postgres";
            String password = "123";
        try {
            // Carregar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão
            Connection connection = DriverManager.getConnection(url, user, password);

            // Agora você pode usar a conexão para executar consultas

            // Fechar a conexão quando não for mais necessária
            connection.close();
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return null;
        
        }
}