package exception;

@SuppressWarnings("serial")
public class LoginSenhaException extends Exception{
	
	public LoginSenhaException() {
		
	}

	@Override
	public String toString() {
		return "Login e/ou Senha incorretos";
	}
}
