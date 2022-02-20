package br.com.agenda.controller;

import java.sql.Connection;
import java.util.List;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class TabelaContatosController {
	
	private ContatoDAO contatoDAO;
	
	public TabelaContatosController() throws Exception {
		Connection conexao = ConnectionFactory.createConnectionToMySQL();
		this.contatoDAO = new ContatoDAO(conexao);
	}
	
	public List<Contato> ListarTabela() throws Exception{
		return this.contatoDAO.ListaContatos();
	}
}
