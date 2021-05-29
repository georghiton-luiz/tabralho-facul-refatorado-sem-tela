package servico;

import javax.swing.*;

public class RelatorioBD {

    public static void relatorio() {

        String query = "SELECT nome_paciente AS NOME, data_nasc_paciente AS DATA_NASC, rg_paciente AS RG,"
                + "org_emissor_paciente AS ORGAO_EMISSOR, cpf_paciente AS CPF, num_sus_paciente AS NUM_SUS, rua_paciente AS LOGRADOURO, num_paciente AS NUMERO, "
                + "bairro_paciente AS BAIRRO, cidade_paciente AS CIDADE, uf_paciente AS UF, complemento_paciente AS COMPLEMENTO, cep_paciente AS CEP, "
                + "fone_paciente AS FONE, celular_paciente AS CELULAR, email_paciente AS EMAIL,	tipo_vac_paciente AS VACINA, data1_vac_paciente AS PRIMEIRA_DOSE,"
                + "data2_vac_paciente AS SEGUNDA_DOSE FROM dados_paciente AS DADOS INNER JOIN endereco_paciente AS ENDERECO "
                + "ON DADOS.id_paciente = ENDERECO.id_paciente INNER JOIN contato_paciente AS CONTATO "
                + "ON DADOS.id_paciente = CONTATO.id_paciente INNER JOIN vacina_paciente AS VACINA "
                + "ON DADOS.id_paciente = VACINA.id_paciente";
        Conexao.getInstance().executaSQL("copy ("+ query + ") to 'e:/TrabalhoBD/relatorio.xls' with delimiter '\t' csv header;");
        JOptionPane.showMessageDialog(null, "Relatório criado em 'e:/TrabalhoBD/relatorio.xls'");
        Conexao.getInstance().fecharConexao();
    }
}
