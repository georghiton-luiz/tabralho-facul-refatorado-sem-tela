package application;

import javax.swing.JOptionPane;

import controller.LoginController;

public class Programa {

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bem-vindo ao cadastro de vacinação contra o COVID-19");

		LoginController.login();
	}

}
