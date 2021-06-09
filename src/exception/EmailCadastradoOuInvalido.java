package exception;

@SuppressWarnings("serial")
public class EmailCadastradoOuInvalido extends Exception{
	
	private String email;
	
	public EmailCadastradoOuInvalido(String email) {
		
		this.email = email;
		System.out.println("O email "+ email + " é inválido ou já está cadastrado");
		
	}

	@Override
	public String toString() {
		return "O email " + email + " é inválido ou já está cadastrado";
	}
	
}
