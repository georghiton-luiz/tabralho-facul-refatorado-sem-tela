package exception;

@SuppressWarnings("serial")
public class EmailCadastradoOuInvalido extends Exception{
	
	public EmailCadastradoOuInvalido(String email) {
		
		System.out.println("O email "+ email + " � inv�lido ou j� est� cadastrado");
		
	}
}
