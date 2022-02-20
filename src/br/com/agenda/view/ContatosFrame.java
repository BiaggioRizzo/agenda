package br.com.agenda.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.agenda.controller.ContatoController;
import br.com.agenda.model.Contato;
import br.com.agenda.util.Util;


public class ContatosFrame extends JFrame{
		
	private static final long serialVersionUID = 1L;
	private JTextField textoNome, textoApelido,textoNascimento, textoLocalizar;
	private JButton botaoSalvar, botaoAlterar, botaoExcluir, botaoInicio, botaoEsquerda, botaoLimpar, botaoDireita, botaoFim, botaoExibir, botaoIr;
	private JLabel telaNome, telaApelido, telaNascimento, telaLocalizar;
	private ContatoController contatoController;
	private TabelaContatosFrame tabelaContatos;
	private int index;
	
	public ContatosFrame() {
		initComponents();
		}

		private void initComponents() {
			
			try {
				this.contatoController = new ContatoController();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			Container container = getContentPane();
			setLayout(null);
			telaNome = new JLabel("Nome");
			telaApelido = new JLabel("Apelido");
			telaNascimento = new JLabel("Data de Nascimento(dd/mm/aaaa)");

			telaNome.setBounds(10, 10, 240, 15);
			telaApelido.setBounds(10, 50, 240, 15);
			telaNascimento.setBounds(10, 90, 240, 15);

			telaNome.setForeground(Color.BLACK);
			telaApelido.setForeground(Color.BLACK);
			telaNascimento.setForeground(Color.BLACK);

			telaNome.setFont(new Font("Courier New", Font.BOLD, 14));
			telaApelido.setFont(new Font("Courier New", Font.BOLD, 14));
			telaNascimento.setFont(new Font("Courier New", Font.BOLD, 14));

			container.add(telaNome);
			container.add(telaApelido);
			container.add(telaNascimento);

			textoNome = new JTextField();
			textoApelido = new JTextField();
			textoNascimento = new JTextField();

			textoNome.setBounds(10, 25, 265, 20);
			textoApelido.setBounds(10, 65, 265, 20);
			textoNascimento.setBounds(10, 105, 265, 20);

			container.add(textoNome);
			container.add(textoApelido);
			container.add(textoNascimento);

			botaoSalvar = new JButton("Salvar");
			botaoAlterar = new JButton("Alterar");
			botaoExcluir = new JButton("Excluir");
			botaoExibir = new JButton("Exibir");
			botaoLimpar = new JButton("Limpar");
			botaoInicio = new JButton("|<");
			botaoEsquerda = new JButton("<<");
			botaoDireita = new JButton(">>");
			botaoFim = new JButton(">|");

			botaoSalvar.setBounds(280, 25, 80, 20);
			botaoAlterar.setBounds(280, 65, 80, 20);
			botaoExcluir.setBounds(280, 105, 80, 20);
			botaoExibir.setBounds(280, 158, 80, 20);
			
			container.add(botaoSalvar);
			container.add(botaoAlterar);
			container.add(botaoExcluir);
			container.add(botaoExibir);
			

			// Adicionar os bot�es de a��o ao Container
			

			botaoInicio.setBounds(10, 135, 50, 20);
			botaoEsquerda.setBounds(60, 135, 50, 20);
			botaoLimpar.setBounds(110, 135, 75, 20);
			botaoDireita.setBounds(185, 135, 50, 20);
			botaoFim.setBounds(235, 135, 50, 20);

			container.add(botaoInicio);
			container.add(botaoEsquerda);
			container.add(botaoLimpar);
			container.add(botaoDireita);
			container.add(botaoFim);

			telaLocalizar = new JLabel("Localizar por nome");
			telaLocalizar.setBounds(10, 160, 220, 20);

			textoLocalizar = new JTextField();
			textoLocalizar.setBounds(10, 180, 220, 20);

			botaoIr = new JButton("Ir");
			botaoIr.setBounds(230, 180, 55, 20);

			container.add(telaLocalizar);
			container.add(textoLocalizar);
			container.add(botaoIr);

			setSize(400, 250);
			setVisible(true);
			setLocationRelativeTo(null);

		
		/* ActionListener Bot�es (Acionadores) */
		botaoExibir.addActionListener(e-> {
			try {			
				ExibirTabelaContatos();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoExcluir.addActionListener(e-> {
			try {
				DeletarContato();
				
				limparTela();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoSalvar.addActionListener(e-> {
			try {
				SalvarContato();
				
				limparTela();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoAlterar.addActionListener(e-> {
			try {
				AlterarContato();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoIr.addActionListener(e-> {
			try {
				PesquisarContato();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoLimpar.addActionListener(e-> {
			try {
				limparTela();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoInicio.addActionListener(e-> {
			try {
				SetaInicio();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoFim.addActionListener(e-> {
			try {
				SetaFim();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoEsquerda.addActionListener(e-> {
			try {
				SetaEsquerda();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		botaoDireita.addActionListener(e-> {
			try {
				SetaDireita();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		}
		

		public void ExibirTabelaContatos() throws Exception {			
			tabelaContatos = new TabelaContatosFrame();
			tabelaContatos.setVisible(true);
			tabelaContatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Fecha somente a tela TabelaContatos
			botaoExibir.setEnabled(true);
		}

		private void SalvarContato() throws Exception {		
			if(!textoNome.getText().equals("")) {
				Util aux = new Util();
				botaoSalvar.setEnabled(true);
				// Passa informacoes obtidas atraves dos JTextFields em um contrutor da classe model Contato
				Contato contato = new Contato(textoNome.getText(), textoApelido.getText(),aux.converterStringParaDataBanco(textoNascimento.getText()));
				this.contatoController.salvarContatoController(contato);
				// Caso tabelaContatos estiver ativo ele vai atualizar em tempo de execu��o;
				if (tabelaContatos != null)
					tabelaContatos.preencherTabela();
				JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
			}
		}
		private void PesquisarContato() throws Exception{
			if (!textoLocalizar.getText().equals("")) {
				botaoIr.setEnabled(true);
				Contato contato = new Contato();
				contato.setNome(textoLocalizar.getText());
				setCamposTextFields(this.contatoController.buscarContatoNomeController(contato));
			}
		}
		
		private void AlterarContato() throws Exception{
			if (!textoNome.getText().equals("")) {
				Util aux = new Util();
				botaoAlterar.setEnabled(true);
				Contato contato = new Contato();
				contato.setNome(textoNome.getText());
				contato.setApelido(textoApelido.getText());
				contato.setNascimento(aux.converterStringParaDataBanco(textoNascimento.getText()));
				/*Faco laco de repeti��o verificando o tamanho da lista obtida atraves do banco e fa�o dois comparativos:
				 * Primeiro se o contato.getNome � igual a tabela do banco, caso seja eu pego Id, se nao for eu tento com apelido*/
				for (int index = 0; index < contatoController.ListarTabelaController().size(); index++) {
					if(contatoController.ListarTabelaController().get(index).getNome().equals(contato.getNome())){
						contato.setId(contatoController.ListarTabelaController().get(index).getId());
					}else if (contatoController.ListarTabelaController().get(index).getApelido().equals(contato.getApelido())) {
						contato.setId(contatoController.ListarTabelaController().get(index).getId());
					} 
				}
				this.contatoController.alterarContatoController(contato);
				if (tabelaContatos != null)
					tabelaContatos.preencherTabela();
				JOptionPane.showMessageDialog(this, "Contato alterado com sucesso!");
			}
		}

		private void DeletarContato() throws Exception{
			if (!textoNome.getText().equals("")) {
				Util aux = new Util();
				botaoExcluir.setEnabled(true);
				Contato contato = new Contato(textoNome.getText(), textoApelido.getText(),aux.converterStringParaDataBanco(textoNascimento.getText()));
				this.contatoController.deletarContatoController(contato);
				JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
				if (tabelaContatos != null)
					tabelaContatos.preencherTabela();
			}	
		}
		
		private void limparTela() {
			this.textoNome.setText("");
			this.textoApelido.setText("");
			this.textoNascimento.setText("");
			this.textoLocalizar.setText("");
			botaoLimpar.setEnabled(true);
		}

		/*Set as informacoes obtidas atraves da listaTabelaController {Lista Contato} apresentando na parte JTextFields*/
		private void setCamposTextFields(Contato setContato) throws Exception {
			Util aux = new Util();
			textoNome.setText(setContato.getNome());
			textoApelido.setText(setContato.getApelido());
			textoNascimento.setText(aux.converterDataBancoParaString(setContato.getNascimento()));
		}
		// Pega o primeiro contato da tabela
		private void SetaInicio() throws Exception {
			index = 0;
			setCamposTextFields(contatoController.ListarTabelaController().get(index));
			botaoInicio.setEnabled(true);
		}
		// Pega o ultimo contato da tabela
		private void SetaFim() throws Exception {
			index = contatoController.ListarTabelaController().size()-1;
			setCamposTextFields(contatoController.ListarTabelaController().get(index));
			botaoFim.setEnabled(true);
		}
		// Pega o contato anterior da tabela		
		private void SetaEsquerda() throws Exception {
			index --;
			
			if(index >= 0) {
				setCamposTextFields(contatoController.ListarTabelaController().get(index));
				
			}else {
				index = 0;
				setCamposTextFields(contatoController.ListarTabelaController().get(index));
				JOptionPane.showMessageDialog(this,"Voc� est� no primeiro contato!");
			}
			botaoEsquerda.setEnabled(true);
		}
		// Pega o proximo contato da tabela		
		private void SetaDireita() throws Exception {
			index ++;
			
			if (index < contatoController.ListarTabelaController().size()) {
				setCamposTextFields(contatoController.ListarTabelaController().get(index));
			} else {
		  		index = contatoController.ListarTabelaController().size()-1;
				setCamposTextFields(contatoController.ListarTabelaController().get(index));
		 		JOptionPane.showMessageDialog(this,"Voc� est� no �ltimo contato!");
			}
			botaoDireita.setEnabled(true);
		}
			
}