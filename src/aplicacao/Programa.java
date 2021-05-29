package aplicacao;

import javax.swing.JOptionPane;

import servico.*;

public class Programa {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bem-vindo ao cadastro de vacina��o contra o COVID-19");

        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, """
            		Escola a fun��o desejada
                    [1] Cadastrar
                    [2] Pesquisar
                    [3] Alterar
                    [4] Fazer Relat�rio
                    [5] Deletar
                    [0] Sair"""));
            switch (op) {
                case 1:
                        Cadastro.cadastroPaciente();
                    break;
                case 2:
                	if(PesquisaBD.pesquisarCadastro() != null) {
                		JOptionPane.showMessageDialog(null, PesquisaBD.resultadoPesquisa());
                	}
                    break;
                case 3:
                    AlterarRegistroBD.alterarCadastro();
            		Conexao.getInstance().fecharConexao();
                    break;

                case 4:
                    RelatorioBD.relatorio();                    
                    break;
                case 5:
                    try {
                        if (DeleteRegistroBD.deletarCadastro()) {
                            JOptionPane.showMessageDialog(null, "Cadastro do paciente deletado");
                        }

                    } catch (Exception ignored) {

                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do aplicativo");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Op��o invalida!\nEscolha uma op��o v�lida:");
            }
        } while (op != 0);
    }
}
