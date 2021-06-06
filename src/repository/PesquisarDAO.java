package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.PesquisarCadastro;
import service.FormatarDados;

public class PesquisarDAO {

	public PesquisarDAO() {

	}

	public static void pesquisarCadastro(String cpf) {

		ResultSet rs = ConexaoDAO.getInstance()
				.executaBusca("SELECT * FROM dados_paciente AS DADOS INNER JOIN endereco_paciente AS ENDERECO "
						+ "ON DADOS.id_paciente = ENDERECO.id_paciente INNER JOIN contato_paciente AS CONTATO "
						+ "ON DADOS.id_paciente = CONTATO.id_paciente INNER JOIN vacina_paciente AS VACINA "
						+ "ON DADOS.id_paciente = VACINA.id_paciente WHERE DADOS.cpf_paciente LIKE '"
						+ FormatarDados.getCpfFormatado(cpf) + "'");

		try {
			while (rs.next()) {
				PesquisarCadastro.setNome(rs.getString("nome_paciente"));
				PesquisarCadastro.setDataNasc(rs.getDate("data_nasc_paciente"));
				PesquisarCadastro.setRg(rs.getString("rg_paciente"));
				PesquisarCadastro.setOrg(rs.getString("org_emissor_paciente"));
				PesquisarCadastro.setCpf(rs.getString("cpf_paciente"));
				PesquisarCadastro.setNumSus(rs.getString("num_sus_paciente"));
				PesquisarCadastro.setRua(rs.getString("rua_paciente"));
				PesquisarCadastro.setNum(rs.getString("num_paciente"));
				PesquisarCadastro.setBairro(rs.getString("bairro_paciente"));
				PesquisarCadastro.setCidade(rs.getString("cidade_paciente"));
				PesquisarCadastro.setUf(rs.getString("uf_paciente"));
				PesquisarCadastro.setComp(rs.getString("complemento_paciente"));
				PesquisarCadastro.setCep(rs.getString("cep_paciente"));
				PesquisarCadastro.setFone(rs.getString("fone_paciente"));
				PesquisarCadastro.setCel(rs.getString("celular_paciente"));
				PesquisarCadastro.setEmail(rs.getString("email_paciente"));
				PesquisarCadastro.setTpVacina(rs.getString("tipo_vac_paciente"));
				PesquisarCadastro.setData1Vac(rs.getDate("data1_vac_paciente"));
				PesquisarCadastro.setData2Vac(rs.getDate("data2_vac_paciente"));

				DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
				PesquisarCadastro.setDataNasConvertida(formatUS.format(PesquisarCadastro.getDataNasc()));
				LocalDate data = LocalDate.parse(PesquisarCadastro.getDataNasConvertida());
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				PesquisarCadastro.setDataNasConvertida(fmt.format(data));

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				PesquisarCadastro.setDataVac1Convertida(formatUS.format(PesquisarCadastro.getData1Vac()));
				data = LocalDate.parse(PesquisarCadastro.getDataVac1Convertida());
				fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				PesquisarCadastro.setDataVac1Convertida(fmt.format(data));

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				PesquisarCadastro.setDataVac2Convertida(formatUS.format(PesquisarCadastro.getData2Vac()));
				data = LocalDate.parse(PesquisarCadastro.getDataVac2Convertida());
				fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				PesquisarCadastro.setDataVac2Convertida(fmt.format(data));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, PesquisarCadastro.getTexto());
	}

	public static boolean pesquisarLoginFuncionario(String login, String senha) {

		try {
			String query = "SELECT * FROM cad_funcionario AS FUN WHERE FUN.user_name_fun LIKE '" + login
					+ "' AND FUN.senha_fun LIKE '" + senha + "'";

			ResultSet rs = ConexaoDAO.getInstance().executaBusca(query);

			String userName = "";
			String auxSenha = "";

			while (rs.next()) {

				userName = rs.getString("user_name_fun");
				auxSenha = rs.getString("senha_fun");
			}
			if (userName.equals(login) && auxSenha.equals(senha)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static boolean pesquisarCadastroFuncionarioUserName(String userName) {

		try {
			String query = "SELECT * FROM cad_funcionario AS FUN WHERE FUN.user_name_fun LIKE '" + userName + "'";

			ResultSet rs = ConexaoDAO.getInstance().executaBusca(query);

			String auxUserName = "";

			while (rs.next()) {

				auxUserName = rs.getString("user_name_fun");
			}
			if (auxUserName.equals(userName)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static boolean pesquisarCadastroFuncionarioEmail(String email) {

		try {
			String query = "SELECT * FROM cad_funcionario AS FUN WHERE FUN.email_fun LIKE '" + email + "'";

			ResultSet rs = ConexaoDAO.getInstance().executaBusca(query);

			String auxEmail = "";

			while (rs.next()) {

				auxEmail = rs.getString("email_fun");
			}
			if (auxEmail.equals(email)) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
}
