package exception;

@SuppressWarnings("serial")
public class EmailCadastradoException extends Exception {
	
	public EmailCadastradoException(String email) {
		
		System.out.println("O email "+ email + " já está cadastrado");
		
	}

}
