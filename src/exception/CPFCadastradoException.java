package exception;

@SuppressWarnings("serial")
public class CPFCadastradoException extends Exception{
	
	public CPFCadastradoException(String cpf) {
		
		System.out.println("CPF "+ cpf + " já está cadastrado");
		
	}

}
