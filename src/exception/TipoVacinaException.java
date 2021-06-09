package exception;

@SuppressWarnings("serial")
public class TipoVacinaException extends Exception{
	
	public TipoVacinaException() {
		
		System.out.println("Tipo de vacina invalido");
		
	}
	
	@Override
	public String toString() {
		return "Tipo de vacina invalido";
	}

}
