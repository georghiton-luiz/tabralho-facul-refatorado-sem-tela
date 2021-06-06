package repository;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import service.FormatarDados;

public class UpdateRegistroPacienteDAO {

	public UpdateRegistroPacienteDAO() {

	}

	public static void alterarNomePaciente(String update, String CPF) {

		String query = "UPDATE dados_paciente SET nome_paciente = '" + update
				+ "' WHERE dados_paciente.cpf_paciente = '" + CPF + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarDataNascPaciente(LocalDate update, String CPF) {

		String query = "UPDATE dados_paciente SET data_nasc_paciente = '" + update
				+ "' WHERE dados_paciente.cpf_paciente = '" + CPF + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarCPFPaciente(String update, String CPF) {

		String query = "UPDATE dados_paciente SET cpf_paciente = '" + FormatarDados.getCpfFormatado(update)
				+ "WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF) + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarRGPaciente(String update, String CPF) {

		String query = "UPDATE dados_paciente SET rg_paciente = '" + update + "' WHERE dados_paciente.cpf_paciente = '"
				+ FormatarDados.getCpfFormatado(CPF) + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarOrgEmissorPaciente(String update, String CPF) {

		String query = "UPDATE dados_paciente SET org_emissor_paciente = '" + update
				+ "' WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF) + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarNumSUSPaciente(String update, String CPF) {

		String query = "UPDATE dados_paciente SET num_sus_paciente = '" + update
				+ "' WHERE dados_paciente.cpf_paciente = '" + CPF + "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarRuaPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET rua_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarNumPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET num_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarBairroPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET bairro_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarCidadePaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET cidade_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarUfPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET num_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarComplementoPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET complemento_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarCEPPaciente(String update, String CPF) {

		String query = "UPDATE endereco_paciente SET cep_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarFonePaciente(String update, String CPF) {

		String query = "UPDATE contato_paciente SET fone_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarCelularPaciente(String update, String CPF) {

		String query = "UPDATE contato_paciente SET celular_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarEmailPaciente(String update, String CPF) {

		String query = "UPDATE contato_paciente SET email_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarTipoVacinaPaciente(String update, String CPF) {

		String query = "UPDATE vacina_paciente SET tipo_vac_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarDataPriDosePaciente(LocalDate update, String CPF) {

		String query = "UPDATE vacina_paciente SET data1_vac_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

	public static void alterarDataSegDosePaciente(LocalDate update, String CPF) {

		String query = "UPDATE vacina_paciente SET data2_vac_paciente = '" + update + "' "
				+ "FROM dados_paciente WHERE dados_paciente.cpf_paciente = '" + FormatarDados.getCpfFormatado(CPF)
				+ "'";
		ConexaoDAO.getInstance().executaSQL(query);
		ConexaoDAO.getInstance().fecharConexao();
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

	}

}
