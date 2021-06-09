package exception;

@SuppressWarnings("serial")
public class EmailCadastradoException extends Exception {
	
	private String email;
	
	public EmailCadastradoException(String email) {
		
		this.email = email;		
		System.out.println("O email "+ email + " já está cadastrado");
		
	}

	@Override
	public String toString() {
		return "O email "+ email + " já está cadastrado";
	}

}
