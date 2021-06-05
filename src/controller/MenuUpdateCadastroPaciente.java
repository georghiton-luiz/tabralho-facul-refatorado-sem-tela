package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import dao.PesquisarCpfDAO;
import dao.UpdateRegistroPacienteDAO;
import servico.FormatarDados;
import servico.ValidarDados;

public class MenuUpdateCadastroPaciente {

	public static void alterarCadastro() {
		try {
			String CPF = (JOptionPane.showInputDialog("Digite o CPF do paciente: "));

			boolean auxCpf = ValidarDados.isCPF(CPF);
			while (!auxCpf || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(CPF))) {
				CPF = JOptionPane.showInputDialog("CPF inválido ou já cadastrado\nDigite CPF");
				auxCpf = ValidarDados.isCPF(CPF);
			}
			CPF = FormatarDados.getCpfFormatado(CPF);

			int op1;
			do {
				int op2;
				op1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
						Escolha o item que deseja alterar:
						[1] Dados Paciente
						[2] Endereço
						[3] Contato
						[4] Vacina
						[0] Voltar ao menu principal
						Digite sua opção:\s"""));
				switch (op1) {
				case 1:
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informação que deseja alterar:
							[1] Nome
							[2] Data de nasc
							[3] CPF
							[4] R.G
							[5] Orgão emissor
							[6] Número SUS
							[0] Voltar ao menu principal
							Digite sua opção:\s"""));
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

							auxCpf = ValidarDados.isCPF(auxCPF);
							while (!auxCpf || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(auxCPF))) {
								auxCPF = JOptionPane.showInputDialog("CPF inválido ou já cadastrado\nDigite CPF");
								auxCpf = ValidarDados.isCPF(auxCPF);
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
							String org_emissor = JOptionPane.showInputDialog("Digite o novo orgão emissor do paciente")
									.toUpperCase();

							UpdateRegistroPacienteDAO.alterarOrgEmissorPaciente(org_emissor, CPF);
							op2 = 0;
						}
						case 6 -> {
							String num_sus = JOptionPane.showInputDialog("Digite o novo número do SUS do paciente");

							UpdateRegistroPacienteDAO.alterarNumSUSPaciente(num_sus, CPF);
							op2 = 0;
						}
						case 0 -> {
							JOptionPane.showMessageDialog(null, "Saindo do menu");
							op1 = 0;
						}
						default -> JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida");
						}
					} while (op2 != 0);
					break;

				case 2:
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informação que deseja alterar:
							[1] Rua
							[2] Número da casa
							[3] Bairro
							[4] Cidade
							[5] UF
							[6] Complemento
							[7] CEP
							[0] Voltar ao menu principal
							Digite sua opção:\s"""));

					do {
						switch (op2) {
						case 1 -> {
							String rua = JOptionPane
									.showInputDialog("Digite seu novo enderço" + "\nDigite a Rua/Avenida/Lagradouro");
							UpdateRegistroPacienteDAO.alterarRuaPaciente(rua, CPF);
							op2 = 0;
						}
						case 2 -> {
							String num = JOptionPane.showInputDialog("Digite o novo número da residencia do paciente");
							UpdateRegistroPacienteDAO.alterarNumPaciente(num, CPF);
							op2 = 0;
						}
						case 3 -> {
							String bairro = JOptionPane.showInputDialog("Digite o novo bairro do endereço do paciente");

							UpdateRegistroPacienteDAO.alterarBairroPaciente(bairro, CPF);
							op2 = 0;
						}
						case 4 -> {
							String cidade = JOptionPane.showInputDialog("Digite a nova cidade do endereço do paciente");

							UpdateRegistroPacienteDAO.alterarCidadePaciente(cidade, CPF);
							op2 = 0;
						}
						case 5 -> {
							String uf = JOptionPane.showInputDialog("Digite o novo estado do endereço do paciente")
									.toUpperCase();
							UpdateRegistroPacienteDAO.alterarUfPaciente(uf, CPF);
							op2 = 0;
						}
						case 6 -> {
							String complemento = JOptionPane
									.showInputDialog("Digite o novo complemento do endereço do paciente");

							UpdateRegistroPacienteDAO.alterarComplementoPaciente(complemento, CPF);
							op2 = 0;
						}
						case 7 -> {
							String CEP = FormatarDados.getCepFormatado(
									JOptionPane.showInputDialog("Digite o novo CEP do endereço do paciente"));

							UpdateRegistroPacienteDAO.alterarCEPPaciente(CEP, CPF);
							op2 = 0;
						}
						case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
						default -> JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
						}
					} while (op2 != 0);
					break;

				case 3:

					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informação que deseja alterar:
							[1] Fone Fixo
							[2] Celular
							[3] E-mail"""));
					do {
						switch (op2) {
						case 1 -> {
							String fone = FormatarDados.getFoneFormatado(
									JOptionPane.showInputDialog("Digite o novo número de telefone fixo com DDD"));

							UpdateRegistroPacienteDAO.alterarFonePaciente(fone, CPF);
							op2 = 0;
						}
						case 2 -> {
							String celular = FormatarDados.getCelFormatado(
									JOptionPane.showInputDialog("Digite o novo número de telefone celular com DDD"));

							UpdateRegistroPacienteDAO.alterarCelularPaciente(celular, CPF);
							op2 = 0;
						}
						case 3 -> {
							String email = JOptionPane.showInputDialog("Digite o novo E-mail do paciente");

							if (email == null || email.equals("")) {
								email = "";
							} else {

								while (!ValidarDados.isEmailValido(email)) {
									email = JOptionPane.showInputDialog(
											"E-mail inválido!\nDigitar o novo E-mail do paciente válido:");
								}
							}
							UpdateRegistroPacienteDAO.alterarEmailPaciente(email, CPF);
							op2 = 0;
						}
						case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
						default -> JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
						}
					} while (op2 != 0);
					op1 = 0;

				case 4:
					String resp = null;
					op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
							Escolha a informação que deseja alterar:
							[1] Tipo de Vacina
							[2] Data da 1ª dose
							"""));
					do {
						switch (op2) {
						case 1 -> {
							resp = ValidarDados.getTipoVacina(Integer.parseInt(JOptionPane.showInputDialog(null, """
									Qual vacina será aplicada?
									[1] = CoronaVac | [2] = Oxford/Astrazeneca
									Escolha de 1 ou 2 referente a vacina aplicada!
									Digita um opção valida!""")));

							boolean ok = false;
							while (!ok) {
								try {

									while (!resp.equals("CoronaVac") && !resp.equals("Oxford/Astrazeneca")) {
										resp = ValidarDados
												.getTipoVacina(Integer.parseInt(JOptionPane.showInputDialog(null, """
														Qual vacina será aplicada?
														[1] = CoronaVac | [2] = Oxford/Astrazeneca
														Escolha de 1 ou 2 referente a vacina aplicada!
														Digita um opção valida!""")));
									}
									ok = true;

								} catch (Exception ignored) {

								}
							}
							UpdateRegistroPacienteDAO.alterarTipoVacinaPaciente(resp, CPF);
							op2 = 0;
						}
						case 2 -> {
							DateFormat formatBR;
							DateFormat formatUS;
							Date date;
							String dataConvertida;
							LocalDate dataVacina1 = null, dataVacina2 = null;
							if (resp.equals("CoronaVac")) {
								formatBR = new SimpleDateFormat("dd/MM/yyyy");
								date = formatBR.parse(FormatarDados.getDataFormatado(
										JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY")));

								formatUS = new SimpleDateFormat("yyyy-MM-dd");
								dataConvertida = formatUS.format(date);
								LocalDate dataVac = LocalDate.parse(dataConvertida);
								dataVacina1 = dataVac;
								dataVac = dataVacina1.plusDays(21);
								dataVacina2 = dataVac;

							} else if (resp.equals("Oxford/Astrazeneca")) {
								formatBR = new SimpleDateFormat("dd/MM/yyyy");
								date = formatBR.parse(FormatarDados.getDataFormatado(
										JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY")));

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
						default -> JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
						}
					} while (op2 != 0);
					op1 = 0;
					break;

				case 0:
					JOptionPane.showMessageDialog(null, "Saindo do menu");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
				}

			} while (op1 != 0);
			JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}

/*
 * case 2:op2=Integer.parseInt(JOptionPane.showInputDialog(null,""" Escolha a
 * informação que deseja alterar: [1] Rua [2] Número da casa [3] Bairro [4]
 * Cidade [5] UF [6] Complemento [7] CEP [0] Voltar ao menu principal Digite sua
 * opção:\s"""));
 * 
 * Integer.parseInt(JOptionPane.showInputDialog(null,""" Escolha a informação
 * que deseja alterar: [1] Fone Fixo [2] Celular [3] E-mail"""));
 * 
 * boolean ok =
 * false;while(!ok){try{vac.setResp(Integer.parseInt(JOptionPane.showInputDialog
 * (null,""" Qual vacina será aplicada? [1] = CoronaVac | [2] =
 * Oxford/Astrazeneca Escolha de 1 ou 2 referende a vacina aplicada! Digita um
 * opção valida!""")));
 * 
 * while(vac.getResp()<=0&&vac.getResp()>2){vac.setResp(Integer.parseInt(
 * JOptionPane.showInputDialog(null,""" Qual vacina será aplicada? [1] =
 * CoronaVac | [2] = Oxford/Astrazeneca Escolha de 1 ou 2 referende a vacina
 * aplicada! Digita um opção valida!""")));}ok=true;
 * 
 * 
 * 
 * DateFormat formatBR; DateFormat formatUS; Date date; String
 * dataConvertida;if(vac.getResp()==1||vac.getResp()==4){
 * 
 * formatBR=new SimpleDateFormat("dd/MM/yyyy");date=formatBR.parse(JOptionPane.
 * showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));
 * 
 * formatUS=new
 * SimpleDateFormat("yyyy-MM-dd");dataConvertida=formatUS.format(date);
 * LocalDate dataVac = LocalDate.parse(
 * dataConvertida);vac.setDataVacina1(dataVac);dataVac=vac.getDataVacina1().
 * plusDays(28);vac.setDataVacina2(dataVac);
 * 
 * }else if(vac.getResp()==2||vac.getResp()==3){formatBR=new
 * SimpleDateFormat("dd/MM/yyyy");date=formatBR.parse(JOptionPane.
 * showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));
 * 
 * formatUS=new
 * SimpleDateFormat("yyyy-MM-dd");dataConvertida=formatUS.format(date);
 * LocalDate dataVac = LocalDate.parse(
 * dataConvertida);vac.setDataVacina1(dataVac);dataVac=vac.getDataVacina1().
 * plusDays(21);vac.setDataVacina2(dataVac);
 * 
 * }else if(vac.getResp()==5){formatBR=new
 * SimpleDateFormat("dd/MM/yyyy");date=formatBR.parse(JOptionPane.
 * showInputDialog("Digite a data da Dose única: DD/MM/YYYY"));
 * 
 * formatUS=new
 * SimpleDateFormat("yyyy-MM-dd");dataConvertida=formatUS.format(date);
 * LocalDate dataVac =
 * LocalDate.parse(dataConvertida);vac.setDataVacina1(dataVac);vac.
 * setDataVacina2(dataVac);
 * 
 * }else if(vac.getResp()==6){formatBR=new
 * SimpleDateFormat("dd/MM/yyyy");date=formatBR.parse(JOptionPane.
 * showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));
 * 
 * formatUS=new
 * SimpleDateFormat("yyyy-MM-dd");dataConvertida=formatUS.format(date);
 * LocalDate dataVac = LocalDate.parse(
 * dataConvertida);vac.setDataVacina1(dataVac);dataVac=vac.getDataVacina1().
 * plusDays(90);vac.setDataVacina2(dataVac);}
 * 
 * op1 = Integer.parseInt(JOptionPane.showInputDialog(null, """ Escolha o item
 * que deseja alterar: [1] Dados Paciente [2] Endereço [3] Contato [4] Vacina
 * [0] Voltar ao menu principal Digite sua opção:\s"""))
 * 
 */