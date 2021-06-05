package dao;

import java.sql.ResultSet;

public class PesquisarCpfDAO {
	
    public static boolean pesquisarCpf(String cpf) {
        String auxCpf = "";
        try {
            String query = "SELECT cpf_paciente FROM dados_paciente WHERE dados_paciente.cpf_paciente = '"
                    + cpf + "'";
            ResultSet rs = ConexaoDAO.getInstance().executaBusca(query);

            while (rs.next()) {
                auxCpf = rs.getString("cpf_paciente");
            }
            return auxCpf.equals(cpf);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
