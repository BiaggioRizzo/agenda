package agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import agenda.factory.ConnectionFactory;
import agenda.model.Contato;

public class ContatoDAO {

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
			 
			prepareStm.execute();
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
		String sql = "UPDATE agenda SET nome = ? , set apelido = ?, set nascimento = ? " +
						"WHERE id = ?";
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
	
	public void deletarContato (int id) {
		String sql = "DELETE FROM agenda WHERE id = ?";
		Connection conexao = null;
		PreparedStatement prepareStm = null;
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepareStm = conexao.prepareStatement(sql);
			
			prepareStm.setInt(1, id);
	
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

