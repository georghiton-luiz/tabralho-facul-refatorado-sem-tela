package repository;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Paciente;

public class CadastroDAO {
		
	public static void cadastroPaciente(Paciente p) {
		
		String queryPacientePaciente, queryEndereco, queryContatoPaciente, queryVacinaPaciente;
				
		queryPacientePaciente = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values" + "(default,'"
				+ p.getNomeCompleto() + "','" + p.getDataNasc() + "','" + p.getDoc().getRg() + "','" + p.getDoc().getOrgEmissor().toUpperCase()
				+ "','"	+ p.getDoc().getCpf() + "','" + p.getDoc().getNumSus() + "')";
		ConexaoDAO.getInstance().executaSQL(queryPacientePaciente);
		
		queryEndereco = "INSERT INTO endereco_paciente (id_endereco,id_paciente,rua_paciente,num_paciente,"
				+ "bairro_paciente,cidade_paciente,uf_paciente,complemento_paciente,cep_paciente)values" + "(default,default,'"
				+ p.getEndereco().getRua() + "','" + p.getEndereco().getNum() + "','" + p.getEndereco().getBairro() + "','"
				+ p.getEndereco().getCidade() + "','" + p.getEndereco().getUf().toUpperCase() + "','" + p.getEndereco().getComplemento()
				+ "','" + p.getEndereco().getCep() + "')";
		ConexaoDAO.getInstance().executaSQL(queryEndereco);
		
		queryContatoPaciente = "INSERT INTO contato_paciente (id_contato,id_paciente,fone_paciente,celular_paciente,"
				+ "email_paciente)values" + "(default, default,'" + p.getContatos().getFone() + "','" + p.getContatos().getCelular()
				+ "','"	+ p.getContatos().getEmail() + "')";	
		ConexaoDAO.getInstance().executaSQL(queryContatoPaciente);
		
		queryVacinaPaciente = "INSERT INTO vacina_paciente (id_vacina,id_paciente,tipo_vac_paciente,data1_vac_paciente,"
				+ "data2_vac_paciente)values" + "(default,default,'" + p.getVacina().getTpVacina() + "','"
				+ p.getVacina().getDataVacina1() + "','" + p.getVacina().getDataVacina2() + "')";
		ConexaoDAO.getInstance().executaSQL(queryVacinaPaciente);		
        JOptionPane.showMessageDialog(null, "Paciente cadastrado");
	}
	
	public static void cadastroFuncionario(Funcionario fun) {

		String queryFuncionario = "INSERT INTO cad_funcionario (id_fun, nome_fun, doc_fun, user_name_fun, senha_fun, email_fun)"
				+ "values" + "(default,'" + fun.getNome() + "','" + fun.getDoc() + "','"
				+ fun.getUserName() + "','" + fun.getSenha() + "','" + fun.getEmail() + "')";
		ConexaoDAO.getInstance().executaSQL(queryFuncionario);
		JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");

	}
		
}
