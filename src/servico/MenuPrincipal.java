package servico;

import javax.swing.JOptionPane;

public class MenuPrincipal {

	private static int op;

	public static void menuPrincipalAdmin() {
		try {
			do {

				op = Integer.parseInt(JOptionPane.showInputDialog(null, """
						Escola a fun��o desejada
						      [1] Cadastrar Funcion�rio
						      [2] Cadastrar Paciente
						      [3] Pesquisar Paciente
						      [4] Alterar Paciente
						      [5] Relat�rio dos Pacientes
							  [6] Relat�rio dos Funcionarios
						      [7] Deletar Paciente
						      [0] Sair"""));
				switch (op) {
				case 1:
					CadastroFuncionario.cadFuncionario();
					break;
				case 2:
					CadastroPaciente.cadastroPaciente();
					break;
				case 3:
					PesquisaBD.pesquisaPaciente();					
					break;
				case 4:
					AlterarRegistroBD.alterarCadastro();
					Conexao.getInstance().fecharConexao();
					break;

				case 5:
					RelatorioBD.relatorioPaciente();
					break;
				case 6:
					RelatorioBD.relatorioPaciente();
					break;
				case 7:
					try {
						if (DeleteRegistroBD.deletarCadastro()) {
							JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
						}

					} catch (Exception ignored) {

					}
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Op��o invalida!\nEscolha uma op��o v�lida:");
				}
			} while (op != 0);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void menuPrincipalUsuario() {
		try {
			do {

				op = Integer.parseInt(JOptionPane.showInputDialog(null, """
						Escola a fun��o desejada
						      [2] Cadastrar Paciente
						      [3] Pesquisar Paciente
						      [4] Alterar Paciente
						      [5] Relat�rio dos Pacientes
							  [6] Relat�rio dos Funcionarios
						      [7] Deletar Paciente
						      [0] Sair"""));
				switch (op) {
				case 1:
					CadastroPaciente.cadastroPaciente();
					break;
				case 2:
					PesquisaBD.pesquisaPaciente();					
					break;
				case 3:
					AlterarRegistroBD.alterarCadastro();
					Conexao.getInstance().fecharConexao();
					break;

				case 4:
					RelatorioBD.relatorioPaciente();
					break;
				case 5:
					RelatorioBD.relatorioPaciente();
					break;
				case 6:
					try {
						if (DeleteRegistroBD.deletarCadastro()) {
							JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
						}

					} catch (Exception ignored) {

					}
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Op��o invalida!\nEscolha uma op��o v�lida:");
				}
			} while (op != 0);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
