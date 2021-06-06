package exception;

@SuppressWarnings("serial")
public class CPFInvalidoOuCadastradoException extends Exception{
	
	public CPFInvalidoOuCadastradoException(String cpf) {
		
		System.out.println("CPF "+ cpf + " é invalido ou já está cadastrado");
		
	}

}
