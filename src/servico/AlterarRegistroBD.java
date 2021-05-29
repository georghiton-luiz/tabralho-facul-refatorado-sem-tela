package servico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import entidades.Contatos;
import entidades.Documentos;
import entidades.Endereco;
import entidades.Vacina;

public class AlterarRegistroBD {

	public AlterarRegistroBD() {

	}

	public static void alterarCadastro() {
		Documentos doc = new Documentos();

		doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente que deseja alterar:"));
		String query;
		try {
			if (!doc.isCPF()) {
				JOptionPane.showMessageDialog(null, "CFP invalido!");
			} else if (!doc.pesquisarCpf()) {
				JOptionPane.showMessageDialog(null, "CPF não encontrado");
			} else {

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
								query = "UPDATE dados_paciente SET nome_paciente = '" + nome
										+ "' WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 2 -> {
								DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
								Date date = formatBR
										.parse(JOptionPane.showInputDialog("Digite a data de nascimento DD/MM/YYYY"));
								DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
								String dataConvertida = formatUS.format(date);
								LocalDate data = LocalDate.parse(dataConvertida);
								query = "UPDATE dados_paciente SET data_nasc_paciente = '" + data
										+ "' WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 3 -> {
								doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente: "));
								while (doc.pesquisarCpf()) {
									doc.setCpf(JOptionPane.showInputDialog(
											"CFP já cadastrado!\nDigitar um CPF valido não cadastrado\nDigite o CPF do paciente: "));
									doc.pesquisarCpf();
								}
								while (!doc.isCPF()) {
									doc.setCpf(JOptionPane.showInputDialog(
											"CFP invalido!\nDigitar um CPF valido!\nDigite o CPF do paciente: "));
								}
								query = "UPDATE dados_paciente SET cpf_paciente = '" + doc.getCpfFormatado()
										+ "WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 4 -> {
								String rg = JOptionPane.showInputDialog("Digite o nome do paciente");
								query = "UPDATE dados_paciente SET rg_paciente = '" + rg
										+ "' WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 5 -> {
								String org_emissor = JOptionPane.showInputDialog("Digite o nome do paciente")
										.toUpperCase();
								query = "UPDATE dados_paciente SET org_emissor_paciente = '" + org_emissor
										+ "' WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 6 -> {
								String num_sus = JOptionPane.showInputDialog("Digite o nome do paciente");
								query = "UPDATE dados_paciente SET num_sus_paciente = '" + num_sus
										+ "' WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 0 -> {
								JOptionPane.showMessageDialog(null, "Saindo do menu");
								op1 = 0;
							}
							default -> JOptionPane.showMessageDialog(null,
									"Opção invalida!\nEscolha uma opção valida:");
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
										.showInputDialog("Digite seu enderço" + "\nDigite a Rua/Avenida/Lagradouro: ");
								query = "UPDATE endereco_paciente SET rua_paciente = '" + rua
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 2 -> {
								String num = JOptionPane.showInputDialog("Digite seu Número: ");
								query = "UPDATE endereco_paciente SET num_paciente = '" + num
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 3 -> {
								String bairro = JOptionPane.showInputDialog("Digite seu Número: ");
								query = "UPDATE endereco_paciente SET bairro_paciente = '" + bairro
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 4 -> {
								String cidade = JOptionPane.showInputDialog("Digite seu Número: ");
								query = "UPDATE endereco_paciente SET cidade_paciente = '" + cidade
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 5 -> {
								String uf = JOptionPane.showInputDialog("Digite seu Número: ").toUpperCase();
								query = "UPDATE endereco_paciente SET num_paciente = '" + uf
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 6 -> {
								String complemento = JOptionPane.showInputDialog("Digite seu Número: ");
								query = "UPDATE endereco_paciente SET complemento_paciente = '" + complemento
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 7 -> {
								Endereco end = new Endereco();
								end.setCep(JOptionPane.showInputDialog("Digite o CEP: "));
								query = "UPDATE endereco_paciente SET num_paciente = '" + end.getCepFormatado()
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
							default -> JOptionPane.showMessageDialog(null,
									"Opção invalida!\nEscolha uma opção valida:");
							}
						} while (op2 != 0);
						break;

					case 3:
						Contatos contato = new Contatos();
						op2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
								Escolha a informação que deseja alterar:
								[1] Fone Fixo
								[2] Celular
								[3] E-mail"""));
						do {
							switch (op2) {
							case 1 -> {
								contato.setFone(
										JOptionPane.showInputDialog("Digite seu número de telefone fixo com DDD: "));
								query = "UPDATE contato_paciente SET fone_paciente = '" + contato.gerFoneFormatado()
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 2 -> {
								contato.setCelular((JOptionPane
										.showInputDialog("Digite seu número de telefone celular com DDD: ")));
								query = "UPDATE contato_paciente SET celular_paciente = '" + contato.getCelFormatado()
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 3 -> {
								contato.setEmail((JOptionPane.showInputDialog("Digite seu E-mail: ")));
								query = "UPDATE contato_paciente SET email_paciente = '" + contato.getEmail()
										+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
										+ doc.getCpfFormatado() + "'";
								Conexao.getInstance().executaSQL(query);
								op2 = 0;
							}
							case 0 -> JOptionPane.showMessageDialog(null, "Saindo do menu");
							default -> JOptionPane.showMessageDialog(null,
									"Opção invalida!\nEscolha uma opção valida:");
							}
						} while (op2 != 0);
						op1 = 0;

					case 4:
						Vacina vac = new Vacina();
						JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");

						boolean ok = false;
						while (!ok) {
							try {
								vac.setResp(Integer.parseInt(JOptionPane.showInputDialog(null, """
										Qual vacina será aplicada?
										[1] = CoronaVac | [2] = Oxford/Astrazeneca
										Escolha de 1 ou 2 referende a vacina aplicada!
										Digita um opção valida!""")));

								while (vac.getResp() <= 0 && vac.getResp() > 2) {
									vac.setResp(Integer.parseInt(JOptionPane.showInputDialog(null, """
											Qual vacina será aplicada?
											[1] = CoronaVac | [2] = Oxford/Astrazeneca
											Escolha de 1 ou 2 referende a vacina aplicada!
											Digita um opção valida!""")));
								}
								ok = true;

							} catch (Exception ignored) {

							}
						}
						query = "UPDATE vacina_paciente SET tipo_vac_paciente = '" + vac.getTipoVacina()
								+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado()
								+ "'";
						Conexao.getInstance().executaSQL(query);

						DateFormat formatBR;
						DateFormat formatUS;
						Date date;
						String dataConvertida;
						if (vac.getResp() == 1 || vac.getResp() == 4) {

							formatBR = new SimpleDateFormat("dd/MM/yyyy");
							date = formatBR.parse(JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));

							formatUS = new SimpleDateFormat("yyyy-MM-dd");
							dataConvertida = formatUS.format(date);
							LocalDate dataVac = LocalDate.parse(dataConvertida);
							vac.setDataVacina1(dataVac);
							dataVac = vac.getDataVacina1().plusDays(28);
							vac.setDataVacina2(dataVac);

						} else if (vac.getResp() == 2 || vac.getResp() == 3) {
							formatBR = new SimpleDateFormat("dd/MM/yyyy");
							date = formatBR.parse(JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));

							formatUS = new SimpleDateFormat("yyyy-MM-dd");
							dataConvertida = formatUS.format(date);
							LocalDate dataVac = LocalDate.parse(dataConvertida);
							vac.setDataVacina1(dataVac);
							dataVac = vac.getDataVacina1().plusDays(21);
							vac.setDataVacina2(dataVac);

						} else if (vac.getResp() == 5) {
							formatBR = new SimpleDateFormat("dd/MM/yyyy");
							date = formatBR
									.parse(JOptionPane.showInputDialog("Digite a data da Dose única: DD/MM/YYYY"));

							formatUS = new SimpleDateFormat("yyyy-MM-dd");
							dataConvertida = formatUS.format(date);
							LocalDate dataVac = LocalDate.parse(dataConvertida);
							vac.setDataVacina1(dataVac);
							vac.setDataVacina2(dataVac);

						} else if (vac.getResp() == 6) {
							formatBR = new SimpleDateFormat("dd/MM/yyyy");
							date = formatBR.parse(JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY"));

							formatUS = new SimpleDateFormat("yyyy-MM-dd");
							dataConvertida = formatUS.format(date);
							LocalDate dataVac = LocalDate.parse(dataConvertida);
							vac.setDataVacina1(dataVac);
							dataVac = vac.getDataVacina1().plusDays(90);
							vac.setDataVacina2(dataVac);
						}
						query = "UPDATE vacina_paciente SET data1_vac_paciente = '" + vac.getDataVacina1()
								+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado()
								+ "'";
						Conexao.getInstance().executaSQL(query);

						query = "UPDATE vacina_paciente SET data2_vac_paciente = '" + vac.getDataVacina2()
								+ "' FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + doc.getCpfFormatado()
								+ "'";
						Conexao.getInstance().executaSQL(query);

						break;

					case 0:
						JOptionPane.showMessageDialog(null, "Saindo do menu");
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção invalida!\nEscolha uma opção valida:");
					}

				} while (op1 != 0);
				JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
			}

		} catch (Exception ignored) {

		}
	}

}
