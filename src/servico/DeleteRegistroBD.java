package servico;

import javax.swing.JOptionPane;

import entidades.Documentos;

public class DeleteRegistroBD {
	


	public DeleteRegistroBD() {

	}

	public static boolean deletarCadastro() {
		Documentos doc = new Documentos();
		
		doc.setCpf(JOptionPane.showInputDialog("Digite o CPF do paciente:"));
		try {
			while (!doc.isCPF() && !doc.pesquisarCpf()) {
				doc.setCpf(JOptionPane.showInputDialog("CFP invalido ou não encontrado!\nDigitar um CPF valido:"));
			}

			String query = "delete from dados_paciente where cpf_paciente = '" + doc.getCpfFormatado() + "'";
			Conexao.getInstance().executaSQL(query);
			Conexao.getInstance().fecharConexao();
			return true;

		} catch (Exception ignored) {

		}
		return false;
	}

}
