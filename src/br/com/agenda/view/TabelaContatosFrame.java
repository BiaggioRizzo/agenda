package br.com.agenda.view;


import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.controller.TabelaContatosController;
import br.com.agenda.model.Contato;
import br.com.agenda.util.Util;

public class TabelaContatosFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane painelScroll;
	private DefaultTableModel modelo;
	private JTable tabela;
	private TabelaContatosController tabelaContatosController;
	
	
	public TabelaContatosFrame() throws Exception {
		super("Tabela de Contatos");
		Container container = getContentPane();
		setLayout(null);
		setResizable(false);
		
		tabela = new JTable();
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		modelo = (DefaultTableModel) tabela.getModel();
		
		modelo.addColumn("Identificador do Contato");
		modelo.addColumn("Nome do Contato");
		modelo.addColumn("Apelido");
		modelo.addColumn("Data de Nascimento");
		preencherTabela();
		tabela.repaint();
		tabela.setBounds(10,10,550,250);
		painelScroll = new JScrollPane();
		painelScroll.setBounds(10,10,550,250);
		container.add(painelScroll);
		painelScroll.setViewportView(tabela);
		
		
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
			
	}
	// Pega as informações da lista do tipo Contatos
	public void preencherTabela() throws Exception {
		tabelaContatosController = new TabelaContatosController();
		List<Contato> contatos = tabelaContatosController.ListarTabela();
		Util aux = new Util(); // chamando classe criada para converter a data
		
		// método para atualizar a tabela em tempo de execução!
		((DefaultTableModel) tabela.getModel()).setRowCount(0);

		for (Contato contato : contatos) { // Adiciona linhas no modelo com os dados de cada Produto recuperado
		// Cria um array de Object com os dados de cada linha
			modelo.addRow(new Object[] { contato.getId(), contato.getNome(), contato.getApelido(),
					aux.converterDataBancoParaString(contato.getNascimento()) }); 
		}
		
	}
}
