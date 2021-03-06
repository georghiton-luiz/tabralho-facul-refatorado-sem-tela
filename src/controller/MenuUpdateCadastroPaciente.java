package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import exception.EmailInvalidoException;
import exception.StatusCPFException;
import exception.TipoVacinaException;
import repository.PesquisarCpfDAO;
import repository.PesquisarVacinaDAO;
import repository.UpdateRegistroPacienteDAO;
import service.FormatarDados;
import service.ValidarDados;

public class MenuUpdateCadastroPaciente {
	
	public static void alterarCadastro() {
		
		try {			
			String CPF = JOptionPane.showInputDialog("Digite o CPF do registro do paciente que deseja editar");
			
			while(!ValidarDados.isCPF(CPF) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(CPF))){
				
				if(!ValidarDados.isCPF(CPF) || !PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(CPF))){
					throw new StatusCPFException(CPF);
				}
				
				CPF = JOptionPane.showInputDialog("CPF invalido ou n?o cadastrado\nDigite CPF");
			}
			CPF = FormatarDados.getCpfFormatado(CPF);


			int op1;
			do {
				int op2;
				op1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
						Escolha o item que deseja alterar:
						[1] Dados Paciente
						[2] Endere?o
						[3] Contato
						[4] Vacina
						[0] Voltar ao menu principal
						Digite sua op??o:\s"""));
				switch (op1) {
				case 1:
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informa??o que deseja alterar:
							[1] Nome
							[2] Data de nasc
							[3] CPF
							[4] R.G
							[5] Org?o emissor
							[6] N?mero SUS
							[0] Voltar ao menu principal
							Digite sua op??o:\s"""));
					do {
						switch (op2) {
						case 1 -> {
							String nome = JOptionPane.showInputDialog("Digite o nome do paciente");

							UpdateRegistroPacienteDAO.alterarNomePaciente(nome, CPF);
							op2 = 0;
						}
						case 2 -> {
							DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
							Date date = formatBR
									.parse(JOptionPane.showInputDialog("Digite a data de nascimento DD/MM/YYYY"));
							DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
							String dataConvertida = formatUS.format(date);
							LocalDate data = LocalDate.parse(dataConvertida);

							UpdateRegistroPacienteDAO.alterarDataNascPaciente(data, CPF);
							op2 = 0;
						}
						case 3 -> {

							String auxCPF = JOptionPane.showInputDialog("Digite o CPF corrigido do paciente");
							
							while (!ValidarDados.isCPF(auxCPF) || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(auxCPF))) {
								if(!ValidarDados.isCPF(auxCPF) || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(auxCPF))) {
									throw new StatusCPFException(auxCPF);
								}
								auxCPF = JOptionPane.showInputDialog("CPF inv?lido ou j? cadastrado\nDigite CPF");
								
							}
							auxCPF = FormatarDados.getCpfFormatado(auxCPF);

							UpdateRegistroPacienteDAO.alterarCPFPaciente(auxCPF, CPF);
							op2 = 0;
						}
						case 4 -> {
							String rg = JOptionPane.showInputDialog("Digite o novo R.G. do paciente");

							UpdateRegistroPacienteDAO.alterarRGPaciente(rg, CPF);
							op2 = 0;
						}
						case 5 -> {
							String org_emissor = JOptionPane.showInputDialog("Digite o novo org?o emissor do paciente")
									.toUpperCase();

							UpdateRegistroPacienteDAO.alterarOrgEmissorPaciente(org_emissor, CPF);
							op2 = 0;
						}
						case 6 -> {
							String num_sus = JOptionPane.showInputDialog("Digite o novo n?mero do SUS do paciente");

							UpdateRegistroPacienteDAO.alterarNumSUSPaciente(num_sus, CPF);
							op2 = 0;
						}
						case 0 -> {
							JOptionPane.showMessageDialog(null, "Saindo do menu");
							op1 = 0;
						}
						default -> JOptionPane.showMessageDialog(null, "Op??o invalida!\nEscolha uma op??o valida");
						}
					} while (op2 != 0);
					break;

				case 2:
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informa??o que deseja alterar:
							[1] Rua
							[2] N?mero da casa
							[3] Bairro
							[4] Cidade
							[5] UF
							[6] Complemento
							[7] CEP
							[0] Voltar ao menu principal
							Digite sua op??o:\s"""));

					do {
						switch (op2) {
						case 1 -> {
							String rua = JOptionPane
									.showInputDialog("Digite seu novo ender?o\nRua/Avenida/Lagradouro");
							UpdateRegistroPacienteDAO.alterarRuaPaciente(rua, CPF);
							op2 = 0;
						}
						case 2 -> {
							String num = JOptionPane.showInputDialog("Digite o novo n?mero da residencia do paciente");
							UpdateRegistroPacienteDAO.alterarNumPaciente(num, CPF);
							op2 = 0;
						}
						case 3 -> {
							String bairro = JOptionPane.showInputDialog("Digite o novo bairro do endere?o do paciente");

							UpdateRegistroPacienteDAO.alterarBairroPaciente(bairro, CPF);
							op2 = 0;
						}
						case 4 -> {
							String cidade = JOptionPane.showInputDialog("Digite a nova cidade do endere?o do paciente");

							UpdateRegistroPacienteDAO.alterarCidadePaciente(cidade, CPF);
							op2 = 0;
						}
						case 5 -> {
							String uf = JOptionPane.showInputDialog("Digite o novo estado do endere?o do paciente")
									.toUpperCase();
							UpdateRegistroPacienteDAO.alterarUfPaciente(uf, CPF);
							op2 = 0;
						}
						case 6 -> {
							String complemento = JOptionPane
									.showInputDialog("Digite o novo complemento do endere?o do paciente");

							UpdateRegistroPacienteDAO.alterarComplementoPaciente(complemento, CPF);
							op2 = 0;
						}
						case 7 -> {
							String CEP = FormatarDados.getCepFormatado(
									JOptionPane.showInputDialog("Digite o novo CEP do endere?o do paciente"));

							UpdateRegistroPacienteDAO.alterarCEPPaciente(CEP, CPF);
							op2 = 0;
						}
						case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
						default -> JOptionPane.showMessageDialog(null, "Op??o invalida!\nEscolha uma op??o valida:");
						}
					} while (op2 != 0);
					break;

				case 3:

					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informa??o que deseja alterar:
							[1] Fone Fixo
							[2] Celular
							[3] E-mail"""));
					do {
						switch (op2) {
						case 1 -> {
							String fone = FormatarDados.getFoneFormatado(
									JOptionPane.showInputDialog("Digite o novo n?mero de telefone fixo com DDD"));

							UpdateRegistroPacienteDAO.alterarFonePaciente(fone, CPF);
							op2 = 0;
						}
						case 2 -> {
							String celular = FormatarDados.getCelFormatado(
									JOptionPane.showInputDialog("Digite o novo n?mero de telefone celular com DDD"));

							UpdateRegistroPacienteDAO.alterarCelularPaciente(celular, CPF);
							op2 = 0;
						}
						case 3 -> {
							String email = JOptionPane.showInputDialog("Digite o novo E-mail do paciente");

							if (email == null || email.equals("")) {
								email = "";
							} else {

								while (!ValidarDados.isEmailValido(email)) {
									if(!ValidarDados.isEmailValido(email)) {
										throw new EmailInvalidoException(email);
									}
									email = JOptionPane.showInputDialog(
											"E-mail inv?lido!\nDigitar o novo E-mail do paciente v?lido:");
								}
							}
							UpdateRegistroPacienteDAO.alterarEmailPaciente(email, CPF);
							op2 = 0;
						}
						case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
						default -> JOptionPane.showMessageDialog(null, "Op??o invalida!\nEscolha uma op??o valida:");
						}
					} while (op2 != 0);
					op1 = 0;

				case 4:
					String resp = null;
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informa??o que deseja alterar:
							[1] Tipo de Vacina
							[2] Data da 1? dose
							"""));
					do {
						switch (op2) {
						case 1 -> {
							do {								
								resp = ValidarDados.getTipoVacina(Integer.parseInt(JOptionPane.showInputDialog(null, """
										Qual vacina ser? aplicada?
										[1] = CoronaVac | [2] = Oxford/Astrazeneca
										Escolha de 1 ou 2 referente a vacina aplicada!
										Digita um op??o valida!""")));
								if(!resp.equals("CoronaVac") && !resp.equals("Oxford/Astrazeneca")) {
									throw new TipoVacinaException();
								}
								
							}while(!resp.equals("CoronaVac") && !resp.equals("Oxford/Astrazeneca"));
							
							UpdateRegistroPacienteDAO.alterarTipoVacinaPaciente(resp, CPF);
							op2 = 0;
						}
						case 2 -> {
							resp = PesquisarVacinaDAO.pesquisarTipoVacina(CPF);
							DateFormat formatBR;
							DateFormat formatUS;
							Date date;
							String dataConvertida;
							LocalDate dataVacina1 = null, dataVacina2 = null;
							if (resp.equals("CoronaVac")) {
								formatBR = new SimpleDateFormat("dd/MM/yyyy");
								date = formatBR.parse(FormatarDados.getDataFormatado(
										JOptionPane.showInputDialog("Digite a data da 1? Dose: DD/MM/YYYY")));

								formatUS = new SimpleDateFormat("yyyy-MM-dd");
								dataConvertida = formatUS.format(date);
								LocalDate dataVac = LocalDate.parse(dataConvertida);
								dataVacina1 = dataVac;
								dataVac = dataVacina1.plusDays(21);
								dataVacina2 = dataVac;

							} else if (resp.equals("Oxford/Astrazeneca")) {
								formatBR = new SimpleDateFormat("dd/MM/yyyy");
								date = formatBR.parse(FormatarDados.getDataFormatado(
										JOptionPane.showInputDialog("Digite a data da 1? Dose: DD/MM/YYYY")));

								formatUS = new SimpleDateFormat("yyyy-MM-dd");
								dataConvertida = formatUS.format(date);
								LocalDate dataVac = LocalDate.parse(dataConvertida);
								dataVacina1 = dataVac;
								dataVac = dataVacina1.plusDays(90);
								dataVacina2 = dataVac;
							}
							UpdateRegistroPacienteDAO.alterarDataPriDosePaciente(dataVacina1, CPF);
							UpdateRegistroPacienteDAO.alterarDataSegDosePaciente(dataVacina2, CPF);
							op2 = 0;
						}
						case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
						default -> JOptionPane.showMessageDialog(null, "Op??o invalida!\nEscolha uma op??o valida:");
						}
					} while (op2 != 0);
					op1 = 0;
					break;

				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do menu");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Op??o invalida!\nEscolha uma op??o valida:");
				}

			} while (op1 != 0);			

		} catch (StatusCPFException | ParseException | TipoVacinaException | EmailInvalidoException | NumberFormatException e) {
			e.printStackTrace();
			MenuUpdateCadastroPaciente.alterarCadastro();

		}
	}
}