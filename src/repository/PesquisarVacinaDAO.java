package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import service.FormatarDados;

public class PesquisarVacinaDAO {
	
    public static String pesquisarTipoVacina(String cpf) {
        String tpVacina = "";
        try {
            String query = "SELECT * FROM dados_paciente AS DADOS INNER JOIN endereco_paciente AS ENDERECO "
					+ "ON DADOS.id_paciente = ENDERECO.id_paciente INNER JOIN contato_paciente AS CONTATO "
					+ "ON DADOS.id_paciente = CONTATO.id_paciente INNER JOIN vacina_paciente AS VACINA "
					+ "ON DADOS.id_paciente = VACINA.id_paciente WHERE DADOS.cpf_paciente LIKE '"
					+ FormatarDados.getCpfFormatado(cpf) + "'";
            ResultSet rs = ConexaoDAO.getInstance().executaBusca(query);

            while (rs.next()) {
                tpVacina = rs.getString("tipo_vac_paciente");
            }
            return tpVacina;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
