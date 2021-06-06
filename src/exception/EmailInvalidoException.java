package exception;

@SuppressWarnings("serial")
public class EmailInvalidoException extends Exception{
	
	public EmailInvalidoException(String email) {
		
		System.out.println("O email "+ email + " é invalido");
		
	}

}
