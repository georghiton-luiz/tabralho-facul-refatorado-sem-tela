package exception;

import javax.swing.JOptionPane;

import repository.PesquisarCpfDAO;
import service.FormatarDados;
import service.ValidarDados;

@SuppressWarnings("serial")
public class StatusCPFException extends Exception {

	private String resp;

	public StatusCPFException(String cpf) {

		if (!ValidarDados.isCPF(FormatarDados.getCpfFormatado(cpf))) {
			resp = "CPF invalido";
			JOptionPane.showMessageDialog(null, resp);
		} else if (!PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))) {
			resp = "CPF não cadastrado";
			JOptionPane.showMessageDialog(null, resp);
		} else if (PesquisarCpfDAO.pesquisarCpf(FormatarDados.getCpfFormatado(cpf))) {
			resp = "CPF já cadastrado";
			JOptionPane.showMessageDialog(null, resp);
		}else {
			resp = "Preencha com um CPF";	
			JOptionPane.showMessageDialog(null, resp);
		}
		
	}

	@Override
	public String toString() {
		return resp;
	}
}
