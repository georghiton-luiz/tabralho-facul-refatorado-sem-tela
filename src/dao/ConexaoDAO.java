package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class ConexaoDAO {

	private Connection con;
	private static ConexaoDAO conexaoService;

	public ConexaoDAO() {
		String url = "jdbc:postgresql://localhost:5432/bd_trabalho";
		String usuario = "postgres";
		String senha = "root";

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executaSQL(String query) {

		try {
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executaBusca(String query) {

		try {
			Statement stm = con.createStatement();

			return stm.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ConexaoDAO getInstance() {
		if (Objects.nonNull(conexaoService)) {
			return conexaoService;
		}
		conexaoService = new ConexaoDAO();
		return conexaoService;
	}
}
