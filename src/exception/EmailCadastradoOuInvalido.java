package exception;

@SuppressWarnings("serial")
public class EmailCadastradoOuInvalido extends Exception{
	
	private String email;
	
	public EmailCadastradoOuInvalido(String email) {
		
		this.email = email;
		System.out.println("O email "+ email + " � inv�lido ou j� est� cadastrado");
		
	}

	@Override
	public String toString() {
		return "O email " + email + " � inv�lido ou j� est� cadastrado";
	}
	
}
