package exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CampoObrigatorioException extends Exception{
	
	public CampoObrigatorioException() {
		
		JOptionPane.showMessageDialog(null, "Preenchimento do campo � obrigatorio");
		
	}

	@Override
	public String toString() {
		return "Preenchimento do campo � obrigatorio";
	}
	
	

}
