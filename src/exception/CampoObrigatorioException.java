package exception;


@SuppressWarnings("serial")
public class CampoObrigatorioException extends Exception{
	
	public CampoObrigatorioException() {
		
		System.out.println("Preenchimento do campo � obrigatorio");
		
	}

	@Override
	public String toString() {
		return "Preenchimento do campo � obrigatorio";
	}
	
	

}
