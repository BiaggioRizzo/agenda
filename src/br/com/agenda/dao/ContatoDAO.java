package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	
	public Connection conexao;
	//Pega conexao do banco de dados
	public ContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirContatos (Contato contato) {
		String sql = "INSERT INTO agenda (nome, apelido, nascimento) VALUES(?, ?, ?)";
		Connection conexao = null;
		PreparedStatement prepareStm = null;
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			
			prepareStm = conexao.prepareStatement(sql);
			prepareStm.setString(1, contato.getNome());
			prepareStm.setString(2, contato.getApelido());
			prepareStm.setDate(3, (Date) contato.getNascimento());	  
			 
			prepareStm.execute(); //Executa comando SQL
			System.out.println("Contato salvo com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStm != null) {
					prepareStm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//Metodo que busca as informacoes atraves do nome inserido
	public Contato buscarContato (Contato nome) {
		String sql = "SELECT * FROM agenda WHERE nome = ?";
		Connection conexao = null;
		PreparedStatement prepareStm = null;
		ResultSet resultSet = null;
		Contato contatoResult = new Contato();
		
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepareStm = conexao.prepareStatement(sql);
			prepareStm.setString(1, nome.getNome());
			resultSet = prepareStm.executeQuery();
			while(resultSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultSet.getInt("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setApelido(resultSet.getString("apelido"));
				contato.setNascimento(resultSet.getDate("nascimento"));
				contatoResult = contato;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStm != null) {
					prepareStm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatoResult;
	}
	
	// Insere todas as informcoes do banco de dados dentro de uma lista
	public List<Contato> ListaContatos() throws Exception{

		String sql = "SELECT * FROM agenda";
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conexao = null;
		PreparedStatement prepareStm = null;		
		ResultSet resultSet = null;
		
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepareStm = conexao.prepareStatement(sql);
			resultSet = prepareStm.executeQuery();
			//Enquanto tiver contato sera preenchido na lista contatos
			while (resultSet.next()) {
				Contato contato = new Contato();
				contato.setId(resultSet.getInt("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setApelido(resultSet.getString("apelido"));
				contato.setNascimento(resultSet.getDate("nascimento"));
				
				contatos.add(contato);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(resultSet != null) {		
				resultSet.close();
				}
				if(prepareStm != null) {
					prepareStm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch(Exception e){
				e.printStackTrace();				
			}
		}
		return contatos;
	}
	
	public void atualizarContato (Contato contato) {
		String sql = "UPDATE agenda SET nome = ?,  apelido = ?,  nascimento = ?" + 
					 	"WHERE id = ? ";
		Connection conexao = null;
		PreparedStatement prepareStm = null;
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepareStm = conexao.prepareStatement(sql);
			
			prepareStm.setString(1, contato.getNome());
			prepareStm.setString(2, contato.getApelido());
			prepareStm.setDate(3, (Date) contato.getNascimento());
			prepareStm.setInt(4, contato.getId());
			
			prepareStm.execute();
			System.out.println("Contato atualizado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStm != null) {
					prepareStm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletarContato (Contato contato) {
		String sql = "DELETE FROM agenda WHERE nome = ? AND apelido = ? AND nascimento = ?";
		Connection conexao = null;
		PreparedStatement prepareStm = null;
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepareStm = conexao.prepareStatement(sql);
			
			prepareStm.setString(1, contato.getNome());
			prepareStm.setString(2, contato.getApelido());
			prepareStm.setDate(3, (Date) contato.getNascimento());
	
			prepareStm.execute();
			System.out.println("Contato deletado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(prepareStm != null) {
					prepareStm.close();
				}
				if (conexao != null) {
					conexao.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

