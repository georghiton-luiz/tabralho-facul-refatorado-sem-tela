package exception;

@SuppressWarnings("serial")
public class UsuarioCadastradoException extends Exception{
	
	public UsuarioCadastradoException(String usuario) {
		
		System.out.println("O usuario "+ usuario + " já está cadastrado");
		
	}

}
