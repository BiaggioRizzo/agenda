package br.com.agenda.controller;

import java.sql.Connection;
import java.util.List;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoController {
	
	private ContatoDAO contatoDAO;
	
	public ContatoController() throws Exception {
		Connection conexao = ConnectionFactory.createConnectionToMySQL();
		this.contatoDAO = new ContatoDAO(conexao);
	}
	
	public List<Contato> ListarTabelaController() throws Exception{
		return this.contatoDAO.ListaContatos();
	}
	
	public void deletarContatoController(Contato contato) {
		this.contatoDAO.deletarContato(contato);
	}
	
	public void salvarContatoController(Contato contato) {
		this.contatoDAO.inserirContatos(contato);
	}
	
	public void alterarContatoController(Contato contato) {
		this.contatoDAO.atualizarContato(contato);
	}
	
	public Contato buscarContatoNomeController(Contato contato) {
		return this.contatoDAO.buscarContato(contato);
	}
	
}
