package dao;

import servico.FormatarDados;

public class DeleteRegistroDAO {

	public DeleteRegistroDAO() {

	}

	public static boolean deletarCadastro(String cpf) {
		
		try {

			String query = "delete from dados_paciente where cpf_paciente = '" + FormatarDados.getCpfFormatado(cpf) + "'";
			ConexaoDAO.getInstance().executaSQL(query);
			ConexaoDAO.getInstance().fecharConexao();
			return true;

		} catch (Exception ignored) {

		}
		return false;
	}

}
