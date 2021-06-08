package controller;

import javax.swing.JOptionPane;

import exception.StatusCPFException;
import repository.ConexaoDAO;
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
					if(PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf)) && ValidarDados.isCPF(cpf)) {
						PesquisarDAO.pesquisarCadastro(FormatarDados.getCpfFormatado(cpf));	
					}else {
						throw new StatusCPFException(cpf);
					}					
					break;
				case 4:
					MenuUpdateCadastroPaciente.alterarCadastro();
					break;
				case 5:
					ConexaoDAO.getInstance();
					RelatorioDAO.relatorioPaciente();
					break;
				case 6:
					ConexaoDAO.getInstance();
					RelatorioDAO.relatorioFuncionario();
					break;
				case 7:					
						cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja deletar");
						
						while(!ValidarDados.isCPF(cpf) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
							
							if(!ValidarDados.isCPF(cpf) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
								throw new StatusCPFException(cpf);
							}
							
							cpf = JOptionPane.showInputDialog("CPF invalido ou já cadastrado\nDigite CPF");
						}
						cpf = FormatarDados.getCpfFormatado(cpf);
						
						if (DeleteRegistroDAO.deletarCadastro(cpf)) {
							JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
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

		} catch (StatusCPFException e) {
			e.printStackTrace();
			MenuPrincipalController.menuPrincipalAdmin();
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
					if(PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf)) && ValidarDados.isCPF(cpf)) {
						PesquisarDAO.pesquisarCadastro(FormatarDados.getCpfFormatado(cpf));	
					}else {
						throw new StatusCPFException(cpf);
					}								
					break;
				case 3:
					MenuUpdateCadastroPaciente.alterarCadastro();
					break;
				case 4:
					RelatorioDAO.relatorioPaciente();
					break;
				case 5:
					cpf = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja deletar");
					
					while(!ValidarDados.isCPF(cpf) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
						
						if(!ValidarDados.isCPF(cpf) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))){
							throw new StatusCPFException(cpf);
						}
						
						cpf = JOptionPane.showInputDialog("CPF invalido ou já cadastrado\nDigite CPF");
					}
					cpf = FormatarDados.getCpfFormatado(cpf);
					
					if (DeleteRegistroDAO.deletarCadastro(cpf)) {
						JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
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

		} catch (StatusCPFException e) {
			e.printStackTrace();
			MenuPrincipalController.menuPrincipalUsuario();
		}

	}
}
