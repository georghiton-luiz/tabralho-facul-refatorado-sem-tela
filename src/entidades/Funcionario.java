package entidades;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import aplicacao.Programa;
import servico.Conexao;

public class Funcionario {

	protected String nome;
	protected String userName;
	protected String senha;
	protected String doc;
	protected String email;

	public Funcionario() {

	}

	public Funcionario(String nome, String userName, String senha, String doc, String email) {

		this.nome = nome;
		this.userName = userName;
		this.senha = senha;
		this.doc = doc;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean pesquisarFuncionario() {
		
        try {
            String sql = "SELECT * FROM cad_funcionario AS FUN WHERE FUN.user_name_fun LIKE '" + getUserName()
					+ "' OR FUN.email_fun LIKE '" + getEmail() + "' AND FUN.senha_fun LIKE '" + getSenha() + "'";
            
            ResultSet rs = Conexao.getInstance().executaBusca(sql);

    		String userNome = "";
    		String email = "";
    		
    		try {
    			while (rs.next()) {
    				
    				userNome = rs.getString("nome_paciente");
    				email = rs.getString("email_fun");
    			}
    			if (this.userName.equals(userNome) && this.email.equals(email)) {
    				return true;
    			} else {
    				JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
    			}
    			Programa.login();
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
        return false;
    } catch (Exception e) {
		// TODO: handle exception
	}
		return false;
}
}