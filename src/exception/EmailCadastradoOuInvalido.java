package exception;

@SuppressWarnings("serial")
public class EmailCadastradoOuInvalido extends Exception{
	
	public EmailCadastradoOuInvalido(String email) {
		
		System.out.println("O email "+ email + " é inválido ou já está cadastrado");
		
	}
}
