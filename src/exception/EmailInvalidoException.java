package exception;

@SuppressWarnings("serial")
public class EmailInvalidoException extends Exception{
	
	private String email;
	
	public EmailInvalidoException(String email) {
		
		this.email = email;
		System.out.println("O email "+ email + " é invalido");
		
	}

	@Override
	public String toString() {
		return "O email "+ email + " é invalido";
	}

}
