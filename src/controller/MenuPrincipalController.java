package controller;

import javax.swing.JOptionPane;

import repository.DeleteRegistroDAO;
import repository.PesquisarCpfDAO;
import repository.PesquisarDAO;
import repository.RelatorioDAO;
import service.CadastroFuncionario;
import service.CadastroPaciente;
import service.FormatarDados;
import service.ValidarDados;

public class MenuPrincipalController {

	private static int op;

	public static void menuPrincipalAdmin() {
		try {
			do {

				op = Integer.parseInt(JOptionPane.showInputDialog(null, """
						Escola a função desejada
						      [1] Cadastrar Funcionário
						      [2] Cadastrar Paciente
						      [3] Pesquisar Paciente
						      [4] Alterar Paciente
						      [5] Relatório Pacientes
						      [6] Relatório Funcionarios
						      [7] Deletar Paciente
						      [8] Tela Login
						      [0] Sair"""));
				switch (op) {
				case 1:
					CadastroFuncionario.cadFuncionario();
					break;
				case 2:
					CadastroPaciente.cadastroPaciente();
					break;
				case 3:
					String cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja pesquisar");
					PesquisarDAO.pesquisarCadastro(cpf);				
					break;
				case 4:
					MenuUpdateCadastroPaciente.alterarCadastro();
					break;
				case 5:
					RelatorioDAO.relatorioPaciente();
					break;
				case 6:
					RelatorioDAO.relatorioFuncionario();
					break;
				case 7:
					try {
						cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja deletar");
						boolean auxCpf = ValidarDados.isCPF(cpf);
						while(!auxCpf || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
							auxCpf = ValidarDados.isCPF(cpf = JOptionPane.showInputDialog("CPF invalido ou já cadastrado\nDigite CPF"));
						}
						cpf = FormatarDados.getCpfFormatado(cpf);
						
						if (DeleteRegistroDAO.deletarCadastro(cpf)) {
							JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
						}

					} catch (Exception ignored) {

					}
					break;
				case 8:
					LoginController.login();
					
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção válida:");
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
						Escola a função desejada
						      [1] Cadastrar Paciente
						      [2] Pesquisar Paciente
						      [3] Alterar Paciente
						      [4] Relatório Pacientes
						      [5] Deletar Paciente
						      [6] Tela Login
						      [0] Sair"""));
				switch (op) {
				case 1:
					CadastroPaciente.cadastroPaciente();
					break;
				case 2:
					String cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja pesquisar");
					PesquisarDAO.pesquisarCadastro(cpf);					
					break;
				case 3:
					MenuUpdateCadastroPaciente.alterarCadastro();
					break;
				case 4:
					RelatorioDAO.relatorioPaciente();
					break;
				case 5:
					try {
						cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja deletar");
						boolean auxCpf = ValidarDados.isCPF(cpf);
						while(!auxCpf || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
							auxCpf = ValidarDados.isCPF(cpf = JOptionPane.showInputDialog("CPF invalido ou já cadastrado\nDigite CPF"));
						}
						cpf = FormatarDados.getCpfFormatado(cpf);
						
						if (DeleteRegistroDAO.deletarCadastro(cpf)) {
							JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
						}

					} catch (Exception ignored) {

					}
					break;
				case 6:
					LoginController.login();
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção válida:");
				}
			} while (op != 0);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
