package exception;


@SuppressWarnings("serial")
public class CampoObrigatorioException extends Exception{
	
	public CampoObrigatorioException() {
		
		System.out.println("Preenchimento do campo é obrigatorio");
		
	}

	@Override
	public String toString() {
		return "Preenchimento do campo é obrigatorio";
	}
	
	

}
