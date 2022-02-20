package agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";
	private static final String DATABASE_URL = "DATABASE_URL";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conexao;
	}
	
	public static void main (String[] args) throws Exception {
		
		Connection recuperaConexao = createConnectionToMySQL();
		
		if(recuperaConexao != null) {
			System.out.println("Conexao Estabelecida!");  
			recuperaConexao.close();
		}
	}
}

