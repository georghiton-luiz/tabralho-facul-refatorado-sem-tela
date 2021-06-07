package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import exception.CampoObrigatorioException;
import exception.LoginSenhaException;
import repository.PesquisarDAO;

public class LoginController {

	public static void login() {

		try {
			
			String login = JOptionPane.showInputDialog("Digite seu login (Username/E-mail) ou \n(0 / sair) para finalizar o CadVacina");
			
			if(login.equals("")) {
				if(login.equals("")) {
					throw new CampoObrigatorioException();					
				}
				JOptionPane.showMessageDialog(null, "Preenchimento do login é obrigatorio");
				login();
			}
			
			if (login.equals("0") || login.equals("sair")) {
				JOptionPane.showMessageDialog(null, "Saindo do CadVacina");
				System.exit(0);
				}
			
			

			JPasswordField password = new JPasswordField(10);
			password.setEchoChar('*'); 

			JLabel rotuloSenha = new JLabel("Entre com a senha:");

			JPanel entSenha = new JPanel();
			entSenha.add(rotuloSenha);
			entSenha.add(password);

			JOptionPane.showMessageDialog(null, entSenha, "Acesso restrito", JOptionPane.PLAIN_MESSAGE);


			String senha = new String(password.getPassword());

				if (login.equals("admin") && senha.equals("root")) {
					MenuPrincipalController.menuPrincipalAdmin();
				} else if (PesquisarDAO.pesquisarLoginFuncionario(login, senha)) {
					MenuPrincipalController.menuPrincipalUsuario();
				} else {
					if(!PesquisarDAO.pesquisarLoginFuncionario(login, senha)) {
						throw new LoginSenhaException();
					}
					login();
					int resp = JOptionPane.showConfirmDialog(null,
							"Login e/ou Senha incorretas", "WARNING",
							JOptionPane.YES_NO_OPTION);
					if (resp == 0) {
						login();
					} else {
						System.exit(0);
					}
				}
			}catch (CampoObrigatorioException | LoginSenhaException e) {
				e.getMessage();
				login();
			// TODO: handle exception
		}

	}

}
