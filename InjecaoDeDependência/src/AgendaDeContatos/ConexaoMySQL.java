package AgendaDeContatos;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConexaoMySQL {

	    public static Connection conectar() {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost/" + "agenda";
	            return DriverManager.getConnection(url,"root","");
	        } catch (Exception e) {
	            System.err.println("Erro conexão bd");
	            e.printStackTrace();
	            return null;
	        }
	
	}
}
