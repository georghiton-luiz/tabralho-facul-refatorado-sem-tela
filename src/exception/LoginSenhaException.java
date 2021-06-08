package exception;

@SuppressWarnings("serial")
public class LoginSenhaException extends Exception{
	
	public LoginSenhaException() {
		
		System.out.println("Login e/ou Senha incorretos");
		
	}

	@Override
	public String toString() {
		return "Login e/ou Senha incorretos";
	}
}
