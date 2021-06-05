package controller;

import javax.swing.JOptionPane;

import dao.PesquisarDAO;

public class LoginController {
	
	public static void login() {

		try {

			String login = JOptionPane.showInputDialog("Digite seu login (Username/E-mail)");
			String senha = JOptionPane.showInputDialog("Digite sua senha");

			if (login.equals("admin") && senha.equals("root")) {
				MenuPrincipalController.menuPrincipalAdmin();
			} else if (PesquisarDAO.pesquisarLoginFuncionario(login, senha)) {
				MenuPrincipalController.menuPrincipalUsuario();
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

}
