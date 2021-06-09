package exception;

@SuppressWarnings("serial")
public class UsuarioCadastradoException extends Exception{
	
	private String usuario;
	
	public UsuarioCadastradoException(String usuario) {
		
		this.usuario = usuario;
		System.out.println("O usuario "+ usuario + " j� est� cadastrado");
		
	}

	@Override
	public String toString() {
		return "O usuario "+ usuario + " j� est� cadastrado";
	}

}
