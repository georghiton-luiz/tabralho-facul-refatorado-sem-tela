package model;

import java.sql.Date;

import service.FormatarDados;

public class PesquisarCadastro {

	private static String nome = "";
	private static Date dataNasc;
	private static String dataNasConvertida = "";
	private static String rg = "";
	private static String org = "";
	private static String cpf = "";
	private static String numSus = "";
	private static String rua = "";
	private static String num = "";
	private static String bairro = "";
	private static String cidade = "";
	private static String uf = "";
	private static String comp = "";
	private static String cep = "";
	private static String fone = "";
	private static String cel = "";
	private static String email = "";
	private static String tpVacina = "";
	private static Date data1Vac;
	private static String dataVac1Convertida = "";
	private static Date data2Vac;
	private static String dataVac2Convertida = "";

	public PesquisarCadastro() {

	}

	public PesquisarCadastro(String nome, Date dataNasc, String dataNasConvertida, String rg, String org, String cpf,
			String numSus, String rua, String num, String bairro, String cidade, String uf, String comp, String cep,
			String fone, String cel, String email, String tpVacina, Date data1Vac, String dataVac1Convertida,
			Date data2Vac, String dataVac2Convertida) {
		PesquisarCadastro.nome = nome;
		PesquisarCadastro.dataNasc = dataNasc;
		PesquisarCadastro.dataNasConvertida = dataNasConvertida;
		PesquisarCadastro.rg = rg;
		PesquisarCadastro.org = org;
		PesquisarCadastro.cpf = cpf;
		PesquisarCadastro.numSus = numSus;
		PesquisarCadastro.rua = rua;
		PesquisarCadastro.num = num;
		PesquisarCadastro.bairro = bairro;
		PesquisarCadastro.cidade = cidade;
		PesquisarCadastro.uf = uf;
		PesquisarCadastro.comp = comp;
		PesquisarCadastro.cep = cep;
		PesquisarCadastro.fone = fone;
		PesquisarCadastro.cel = cel;
		PesquisarCadastro.email = email;
		PesquisarCadastro.tpVacina = tpVacina;
		PesquisarCadastro.data1Vac = data1Vac;
		PesquisarCadastro.dataVac1Convertida = dataVac1Convertida;
		PesquisarCadastro.data2Vac = data2Vac;
		PesquisarCadastro.dataVac2Convertida = dataVac2Convertida;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		PesquisarCadastro.nome = nome;
	}

	public static Date getDataNasc() {
		return dataNasc;
	}

	public static void setDataNasc(Date dataNasc) {
		PesquisarCadastro.dataNasc = dataNasc;
	}

	public static String getDataNasConvertida() {
		return dataNasConvertida;
	}

	public static void setDataNasConvertida(String dataNasConvertida) {
		PesquisarCadastro.dataNasConvertida = dataNasConvertida;
	}

	public static String getRg() {
		return rg;
	}

	public static void setRg(String rg) {
		PesquisarCadastro.rg = rg;
	}

	public static String getOrg() {
		return org;
	}

	public static void setOrg(String org) {
		PesquisarCadastro.org = org;
	}

	public static String getCpf() {
		return cpf;
	}

	public static void setCpf(String cpf) {
		PesquisarCadastro.cpf = cpf;
	}

	public static String getNumSus() {
		return numSus;
	}

	public static void setNumSus(String numSus) {
		PesquisarCadastro.numSus = numSus;
	}

	public static String getRua() {
		return rua;
	}

	public static void setRua(String rua) {
		PesquisarCadastro.rua = rua;
	}

	public static String getNum() {
		return num;
	}

	public static void setNum(String num) {
		PesquisarCadastro.num = num;
	}

	public static String getBairro() {
		return bairro;
	}

	public static void setBairro(String bairro) {
		PesquisarCadastro.bairro = bairro;
	}

	public static String getCidade() {
		return cidade;
	}

	public static void setCidade(String cidade) {
		PesquisarCadastro.cidade = cidade;
	}

	public static String getUf() {
		return uf;
	}

	public static void setUf(String uf) {
		PesquisarCadastro.uf = uf;
	}

	public static String getComp() {
		return comp;
	}

	public static void setComp(String comp) {
		PesquisarCadastro.comp = comp;
	}

	public static String getCep() {
		return cep;
	}

	public static void setCep(String cep) {
		PesquisarCadastro.cep = cep;
	}

	public static String getFone() {
		return fone;
	}

	public static void setFone(String fone) {
		PesquisarCadastro.fone = fone;
	}

	public static String getCel() {
		return cel;
	}

	public static void setCel(String cel) {
		PesquisarCadastro.cel = cel;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		PesquisarCadastro.email = email;
	}

	public static String getTpVacina() {
		return tpVacina;
	}

	public static void setTpVacina(String tpVacina) {
		PesquisarCadastro.tpVacina = tpVacina;
	}

	public static Date getData1Vac() {
		return data1Vac;
	}

	public static void setData1Vac(Date data1Vac) {
		PesquisarCadastro.data1Vac = data1Vac;
	}

	public static String getDataVac1Convertida() {
		return dataVac1Convertida;
	}

	public static void setDataVac1Convertida(String dataVac1Convertida) {
		PesquisarCadastro.dataVac1Convertida = dataVac1Convertida;
	}

	public static Date getData2Vac() {
		return data2Vac;
	}

	public static void setData2Vac(Date data2Vac) {
		PesquisarCadastro.data2Vac = data2Vac;
	}

	public static String getDataVac2Convertida() {
		return dataVac2Convertida;
	}

	public static void setDataVac2Convertida(String dataVac2Convertida) {
		PesquisarCadastro.dataVac2Convertida = dataVac2Convertida;
	}

	public static String getTexto() {
		return "Nome: " + getNome() + "\nData de Nascimento: " + dataNasConvertida + "\nR.G.: " + getRg()
				+ "\nOrg. Emissor: " + getOrg() + "\nCPF: " + FormatarDados.getCpfFormatado(getCpf()) + "\nNúmero SUS: "
				+ getNumSus() + "\nRua: " + getRua() + "\nN°: " + getNum() + "\nBairro: " + getBairro() + "\nCidade: "
				+ getCidade() + "\nUF: " + getUf().toUpperCase() + "\nComplemento: " + getComp() + "\nCEP: "
				+ FormatarDados.getCepFormatado(getCep()) + "\nFone: " + FormatarDados.getFoneFormatado(fone)
				+ "\nCelular: " + FormatarDados.getCelFormatado(getCel()) + "\nE-mail: " + getEmail()
				+ "\nTipo de Vacina: " + getTpVacina() + "\nData da primeira dose: " + dataVac1Convertida
				+ "\nData da segunda dose: " + dataVac2Convertida;
	}
}
