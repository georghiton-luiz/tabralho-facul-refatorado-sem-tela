package exception;

@SuppressWarnings("serial")
public class SenhaNaoCorrespondeException extends Exception{
	
	public SenhaNaoCorrespondeException() {
		
		System.out.println("Senha n�o conrresponde");
		
	}

	@Override
	public String toString() {
		return "Senha n�o conrresponde";
	}

}
