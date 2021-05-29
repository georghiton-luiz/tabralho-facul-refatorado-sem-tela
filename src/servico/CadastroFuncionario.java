package servico;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import entidades.Funcionario;

public class CadastroFuncionario {

	private static String confSenha;

	public static void cadFuncionario() {

		try {

			Funcionario fun = new Funcionario();

			fun.setNome(JOptionPane.showInputDialog("Digite o nome completo do funcionario"));
			fun.setDoc(JOptionPane
					.showInputDialog("Digite documento do funcionario CPF(###.###.###-##)/Credencial(CRM/COREN)"));

			fun.setUserName(JOptionPane.showInputDialog("Digite um nome de usuário para login"));
			while (fun.pesquisarFuncionario()) {
				fun.setUserName(JOptionPane.showInputDialog("Nome de usuário ja cadastrado\nDigite outro nome de usuário"));
				fun.pesquisarFuncionario();
			}

			fun.setEmail(JOptionPane.showInputDialog("Digite seu E-mail"));
			while (fun.pesquisarFuncionario()) {
				fun.setEmail(JOptionPane.showInputDialog("E-mail ja cadastrado\nDigite outro e-mail"));
				fun.pesquisarFuncionario();
			}

			fun.setSenha(JOptionPane.showInputDialog("Digite sua senha de login"));
			confSenha = JOptionPane.showInputDialog("Repita sua senha para confirmar");

			while (!confSenha.equals(fun.getSenha())) {
				if (JOptionPane.showConfirmDialog(null, "Senha não conrresponde!\nRepita sua senha para confirmar",
						"WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					confSenha = JOptionPane.showInputDialog("Repita sua senha para confirmar");
				}
			}

			CadastroBd.cadastroFuncionario(fun);

		} catch (HeadlessException | NullPointerException | NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro inesperado!");
		}

	}

}
