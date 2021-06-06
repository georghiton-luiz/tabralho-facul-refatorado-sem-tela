package exception;

@SuppressWarnings("serial")
public class CPFInvalidoException extends Exception{
	
	public CPFInvalidoException(String cpf) {
		
		System.out.println("CPF "+ cpf + " é invalido");
		
	}

}
