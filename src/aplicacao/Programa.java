package aplicacao;

import javax.swing.JOptionPane;

import entidades.Funcionario;
import servico.*;

public class Programa {

	public static void login() {

		try {
			Funcionario fun = new Funcionario();	

			String login = JOptionPane.showInputDialog("Digite seu login (Username/E-mail)");
			String senha = JOptionPane.showInputDialog("Digite sua senha");

			if (login.equals("admin") && senha.equals("root")) {
				MenuPrincipal.menuPrincipalAdmin();
			} else if (fun.pesquisarFuncionario()) {
				MenuPrincipal.menuPrincipalUsuario();
			}else {
				int resp = JOptionPane.showConfirmDialog(null, "Senha não conrresponde!\nRepita sua senha para confirmar",
						"WARNING",JOptionPane.YES_NO_OPTION);
				if(resp == 0) {
					login();				
				}else {
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao cadastro de vacinação contra o COVID-19");

		Programa.login();
	}

}
