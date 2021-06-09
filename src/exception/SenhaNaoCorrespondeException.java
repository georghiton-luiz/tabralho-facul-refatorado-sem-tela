package exception;

@SuppressWarnings("serial")
public class SenhaNaoCorrespondeException extends Exception{
	
	public SenhaNaoCorrespondeException() {
		
		System.out.println("Senha não conrresponde");
		
	}

	@Override
	public String toString() {
		return "Senha não conrresponde";
	}

}
