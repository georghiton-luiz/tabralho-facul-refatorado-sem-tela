package servico;

import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import entidades.Contatos;
import entidades.Documentos;
import entidades.Endereco;
import entidades.Paciente;
import entidades.Vacina;

public class CadastroPaciente {
	
	public CadastroPaciente() {
		
	}

	public static void cadastroPaciente() {
		
			Paciente paciente = new Paciente();
			Documentos doc = new Documentos();
			Contatos contato = new Contatos();
			Endereco end = new Endereco();
			Vacina vac = new Vacina();
			
			try {
			paciente.setNomeCompleto(JOptionPane.showInputDialog("Cadastro"
					+ "\nDigite o Nome Completo do paciente: "));
			
			while (paciente.getNomeCompleto().equals("")) {
				paciente.setNomeCompleto(JOptionPane.showInputDialog("Campo Obrigatório!\nPreencha com nome completo: "
						+ "Digite o Nome Completo do paciente: "));			
			}
			
			DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatBR.parse(JOptionPane.showInputDialog("Digite a data de nascimento DD/MM/YYYY"));

			DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");		
			String dataConvertida = formatUS.format(date);
			LocalDate data = LocalDate.parse(dataConvertida);
			
			paciente.setDataNasc(data);

			
			doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente: "));
			
			while(doc.pesquisarCpf()) {
				doc.setCpf(JOptionPane.showInputDialog("CFP já cadastrado!\nDigitar um CPF válido não cadastrado\nDigite o CPF do paciente: "));
				doc.pesquisarCpf();
			}

			while (!doc.isCPF()) {
				doc.setCpf(JOptionPane.showInputDialog("CFP inválido!\nDigitar um CPF válido!\nDigite o CPF do paciente: "));
			}
			
			doc.setRg(JOptionPane.showInputDialog("Digite o R.G.: "));
			
			doc.setOrgEmissor(JOptionPane.showInputDialog("Digite o Orgão emissor").toUpperCase());
			
			doc.setNumSus(JOptionPane.showInputDialog("Digite seu número do SUS: "));
			paciente.setDoc(doc);
						
			contato.setFone(JOptionPane.showInputDialog("Digite seu número de telefone fixo com DDD: "));	
					
			contato.setCelular(JOptionPane.showInputDialog("Digite seu número de telefone celular com DDD: "));
			
			contato.setEmail(JOptionPane.showInputDialog("Digite seu E-mail: "));
			
			if(contato.getEmail() == null || contato.getEmail().equals("")) {
				contato.setEmail("");			
			}else {

				while (!Contatos.isEmailValido(contato.getEmail())) {
					contato.setEmail(JOptionPane.showInputDialog("E-mail inválido!\nDigitar um E-mail válido:\nDigite seu E-mail: "));
				}			
			}
			paciente.setContatos(contato);
					
			end.setRua(JOptionPane.showInputDialog("Digite seu enderço"
					+ "\nDigite a Rua/Avenida/Lagradouro: "));
			
			end.setNum(JOptionPane.showInputDialog("Digite seu Número: "));

			end.setBairro(JOptionPane.showInputDialog("Digite o Bairro: "));		
			
			end.setCidade(JOptionPane.showInputDialog("Digite o Cidade: "));

			end.setUf(JOptionPane.showInputDialog("Digite o UF: ").toUpperCase());

			end.setComplemento(JOptionPane.showInputDialog("Digite o Complemento: "));

			end.setCep(JOptionPane.showInputDialog("Digite o CEP: "));
			paciente.setEndereco(end);
			
			boolean ok = false;
			while(!ok) {
					vac.setResp(Integer.parseInt(JOptionPane.showInputDialog(null, """
							Qual vacina será aplicada?
							[1] = CoronaVac | [2] = Pfizer | [3] = Sputinik V | [4] = Covaxin | [5] = Johnson | [6] = Covishield
							Escolha de 1 a 6 referende a vacina aplicada!
							Digita um opção valida!""")));

					while (vac.getResp() <= 0 && vac.getResp() > 2) {
						vac.setResp(Integer.parseInt(JOptionPane.showInputDialog(null, """
								Qual vacina será aplicada?
								[1] = CoronaVac | [2] = Pfizer | [3] = Sputinik V | [4] = Covaxin | [5] = Johnson | [6] = Covishield
								Escolha de 1 a 6 referende a vacina aplicada!
								Digita um opção valida!""")));
					}
					ok = true;		
			}
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
					date = formatBR.parse(JOptionPane.showInputDialog("Digite a data da Dose única: DD/MM/YYYY"));

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
			
			paciente.setVacina(vac);

			CadastroBd.salvarCadastro(paciente);
			
		} catch (HeadlessException | NullPointerException | ParseException | NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro inesperado!");
		}

	}
}
