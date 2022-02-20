package agenda.aplicacao;

import agenda.dao.ContatoDAO;
import agenda.model.Contato;
import agenda.util.Util;

public class main {

	public static void main(String[] args) throws Exception {
		
		ContatoDAO contatoDao = new ContatoDAO();
		Util auxiliar = new Util();
		Contato contato = new Contato();
		contato.setNome("Marcos");
		contato.setApelido("Marquinhos");
		String data = "20/10/2000";
	    contato.setNascimento(auxiliar.converterStringParaDataBanco(data));
		
		//Insere contatos na agenda Banco de Dados 
		contatoDao.inserirContatos(contato);
		
		//Deletar contato atrav�s do ID
		//contatoDao.deletarContato(3);
		
		//Visualiza os registros banco de dados Array
		//for(Contato c : contatoDao.ListaContatos()) {
		//	System.out.println("Contato: " + c.getNome());
		//}
		
		
	}

}
