package service;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import exception.EmailCadastradoException;
import exception.EmailCadastradoOuInvalido;
import exception.SenhaNaoCorrespondeException;
import exception.UsuarioCadastradoException;
import model.Funcionario;
import repository.CadastroDAO;
import repository.PesquisarDAO;

public class CadastroFuncionario {

	private static String confSenha;

	public static void cadFuncionario() {

		try {

			Funcionario fun = new Funcionario();

			fun.setNome(JOptionPane.showInputDialog("Digite o nome completo do funcionario"));
			fun.setDoc(JOptionPane
					.showInputDialog("Digite documento do funcionario CPF(###.###.###-##)/Credencial(CRM/COREN)"));

			fun.setUserName(JOptionPane.showInputDialog("Digite um nome de usuário para login"));
			while (PesquisarDAO.pesquisarCadastroFuncionarioUserName(fun.getUserName())) {
				if(PesquisarDAO.pesquisarCadastroFuncionarioUserName(fun.getUserName())) {
					throw new UsuarioCadastradoException(fun.getUserName());
				}				
				fun.setUserName(JOptionPane.showInputDialog("Nome de usuário ja cadastrado\nDigite outro nome de usuário"));
				PesquisarDAO.pesquisarCadastroFuncionarioUserName(fun.getUserName());
			}

			fun.setEmail(JOptionPane.showInputDialog("Digite seu E-mail"));
			while (PesquisarDAO.pesquisarCadastroFuncionarioEmail(fun.getEmail()) || ValidarDados.isEmailValido(fun.getEmail())) {
				if (PesquisarDAO.pesquisarCadastroFuncionarioEmail(fun.getEmail())) {
					throw new EmailCadastradoOuInvalido(fun.getEmail());
				}
				fun.setEmail(JOptionPane.showInputDialog("E-mail ja cadastrado\nDigite outro e-mail"));
				PesquisarDAO.pesquisarCadastroFuncionarioEmail(fun.getEmail());
				ValidarDados.isEmailValido(fun.getEmail());
			}

			fun.setSenha(JOptionPane.showInputDialog("Digite sua senha de login"));
			confSenha = JOptionPane.showInputDialog("Repita sua senha para confirmar");
			
				while (!confSenha.equals(fun.getSenha())) {
					if(!confSenha.equals(fun.getSenha())) {
						throw new SenhaNaoCorrespondeException();
					}
					
					if (JOptionPane.showConfirmDialog(null, "Senha não conrresponde!\nRepita sua senha para confirmar",
							"WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
						confSenha = JOptionPane.showInputDialog("Repita sua senha para confirmar");
					}
				}	
				
			CadastroDAO.cadastroFuncionario(fun);

		} catch (HeadlessException | NullPointerException | NumberFormatException | UsuarioCadastradoException | SenhaNaoCorrespondeException | EmailCadastradoOuInvalido e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Erro inesperado!");
		}

	}

}
