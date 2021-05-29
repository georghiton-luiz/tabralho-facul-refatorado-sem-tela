package servico;

import javax.swing.JOptionPane;

import entidades.Paciente;

public class CadastroBd {
		
	public static void salvarCadastro(Paciente p) {		
		
		String queryPacientePaciente, queryEndereco, queryContatoPaciente, queryVacinaPaciente;
				
		queryPacientePaciente = "INSERT INTO dados_paciente (id_paciente,nome_paciente,data_nasc_paciente,"
				+ "rg_paciente,org_emissor_paciente,cpf_paciente,num_sus_paciente)values" + "(default,'"
				+ p.getNomeCompleto() + "','" + p.getDataNasc() + "','" + p.getDoc().getRg() + "','" + p.getDoc().getOrgEmissor().toUpperCase()
				+ "','"	+ p.getDoc().getCpfFormatado() + "','" + p.getDoc().getNumSus() + "')";
		Conexao.getInstance().executaSQL(queryPacientePaciente);
		
		queryEndereco = "INSERT INTO endereco_paciente (id_endereco,id_paciente,rua_paciente,num_paciente,"
				+ "bairro_paciente,cidade_paciente,uf_paciente,complemento_paciente,cep_paciente)values" + "(default,default,'"
				+ p.getEndereco().getRua() + "','" + p.getEndereco().getNum() + "','" + p.getEndereco().getBairro() + "','"
				+ p.getEndereco().getCidade() + "','" + p.getEndereco().getUf().toUpperCase() + "','" + p.getEndereco().getComplemento()
				+ "','" + p.getEndereco().getCepFormatado() + "')";
		Conexao.getInstance().executaSQL(queryEndereco);
		
		queryContatoPaciente = "INSERT INTO contato_paciente (id_contato,id_paciente,fone_paciente,celular_paciente,"
				+ "email_paciente)values" + "(default, default,'" + p.getContatos().gerFoneFormatado() + "','" + p.getContatos().getCelFormatado()
				+ "','"	+ p.getContatos().getEmail() + "')";	
		Conexao.getInstance().executaSQL(queryContatoPaciente);
		
		queryVacinaPaciente = "INSERT INTO vacina_paciente (id_vacina,id_paciente,tipo_vac_paciente,data1_vac_paciente,"
				+ "data2_vac_paciente)values" + "(default,default,'" + p.getVacina().getTipoVacina() + "','"
				+ p.getVacina().getDataVacina1() + "','" + p.getVacina().getDataVacina2() + "')";
		Conexao.getInstance().executaSQL(queryVacinaPaciente);		
		Conexao.getInstance().fecharConexao();
        JOptionPane.showMessageDialog(null, "Paciente cadastrado");
	}
		
}
