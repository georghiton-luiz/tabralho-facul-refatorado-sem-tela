package service;

import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import exception.CampoObrigatorioException;
import exception.EmailInvalidoException;
import exception.StatusCPFException;
import exception.TipoVacinaException;
import model.Contatos;
import model.Documentos;
import model.Endereco;
import model.Paciente;
import model.Vacina;
import repository.CadastroDAO;
import repository.PesquisarCpfDAO;

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
			paciente.setNomeCompleto(JOptionPane.showInputDialog("Digite o Nome Completo do paciente"));

			while (paciente.getNomeCompleto().equals("")) {

				if (paciente.getNomeCompleto().equals("")) {
					throw new CampoObrigatorioException();
				}

				paciente.setNomeCompleto(JOptionPane.showInputDialog(
						"Campo Obrigatório!\nPreencha com nome completo: " + "Digite o Nome Completo do paciente"));
			}

			DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatBR.parse(FormatarDados
					.getDataFormatado(JOptionPane.showInputDialog("Digite a data de nascimento DD/MM/YYYY")));

			DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
			String dataConvertida = formatUS.format(date);
			LocalDate data = LocalDate.parse(dataConvertida);

			paciente.setDataNasc(data);

			doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente"));

			boolean auxCpf = ValidarDados.isCPF(doc.getCpf());
			while (!auxCpf || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(doc.getCpf()))) {

				if (!auxCpf || PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(doc.getCpf()))) {
					throw new StatusCPFException(doc.getCpf());
				}

				doc.setCpf(JOptionPane.showInputDialog("CPF inválido ou já cadastrado\nDigite CPF"));
				auxCpf = ValidarDados.isCPF(doc.getCpf());
			}
			doc.setCpf(FormatarDados.getCpfFormatado(doc.getCpf()));

			doc.setRg(JOptionPane.showInputDialog("Digite o R.G."));

			doc.setOrgEmissor(JOptionPane.showInputDialog("Digite o Orgão emissor").toUpperCase());

			doc.setNumSus(JOptionPane.showInputDialog("Digite seu número do SUS"));
			paciente.setDoc(doc);

			contato.setFone(FormatarDados
					.getFoneFormatado(JOptionPane.showInputDialog("Digite seu número de telefone fixo com DDD")));

			contato.setCelular(FormatarDados
					.getCelFormatado(JOptionPane.showInputDialog("Digite seu número de telefone celular com DDD")));

			contato.setEmail(JOptionPane.showInputDialog("Digite seu E-mail"));

			if (contato.getEmail() == null || contato.getEmail().equals("")) {
				contato.setEmail("");
			} else {

				while (!ValidarDados.isEmailValido(contato.getEmail())) {

					if (!ValidarDados.isEmailValido(contato.getEmail())) {
						throw new EmailInvalidoException(contato.getEmail());
					}

					contato.setEmail(JOptionPane
							.showInputDialog("E-mail inválido!\nDigitar um E-mail válido:\nDigite seu E-mail"));
				}
			}
			paciente.setContatos(contato);

			end.setRua(JOptionPane.showInputDialog("Digite seu endereço" + "\nDigite a Rua/Avenida/Lagradouro"));

			end.setNum(JOptionPane.showInputDialog("Digite seu Número"));

			end.setBairro(JOptionPane.showInputDialog("Digite o Bairro"));

			end.setCidade(JOptionPane.showInputDialog("Digite o Cidade"));

			end.setUf(JOptionPane.showInputDialog("Digite o UF").toUpperCase());

			end.setComplemento(JOptionPane.showInputDialog("Digite o Complemento"));

			end.setCep(JOptionPane.showInputDialog("Digite o CEP"));
			paciente.setEndereco(end);

			String resp;

			do {
				resp = ValidarDados.getTipoVacina(Integer.parseInt(JOptionPane.showInputDialog(null, """
						Qual vacina será aplicada?
						[1] = CoronaVac | [2] = Oxford/Astrazeneca
						Escolha de 1 ou 2 referente a vacina aplicada!
						Digita um opção valida!""")));

				if (!resp.equals("CoronaVac") && !resp.equals("Oxford/Astrazeneca")) {
					throw new TipoVacinaException();
				}

			} while (!resp.equals("CoronaVac") && !resp.equals("Oxford/Astrazeneca"));

			vac.setTpVacina(resp);

			if (resp.equals("CoronaVac")) {
				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(FormatarDados
						.getDataFormatado(JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY")));

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				dataVac = vac.getDataVacina1().plusDays(21);
				vac.setDataVacina2(dataVac);

			} else if (resp.equals("Oxford/Astrazeneca")) {
				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(FormatarDados
						.getDataFormatado(JOptionPane.showInputDialog("Digite a data da 1ª Dose: DD/MM/YYYY")));

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				dataVac = vac.getDataVacina1().plusDays(90);
				vac.setDataVacina2(dataVac);
			}

			paciente.setVacina(vac);

			CadastroDAO.cadastroPaciente(paciente);

		} catch (HeadlessException | NullPointerException | ParseException | NumberFormatException
				| EmailInvalidoException | TipoVacinaException	| CampoObrigatorioException
				| StatusCPFException e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "Erro inesperado!");
		}

	}
}
