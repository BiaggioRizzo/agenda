package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";
	private static final String DATABASE_URL = "DATABASE_URL";
	// Cria conex�o com banco de dados enviando as informacoes necessarias
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conexao;
	}
	//Faz conexao
	public static void main (String[] args) throws Exception {
		
		Connection recuperaConexao = createConnectionToMySQL();
		
		if(recuperaConexao != null) {
			System.out.println("Conex�o Estabelecida!");  
			recuperaConexao.close();
		}
	}
}

