package model;

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

}