package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDados {
    
    public ValidarDados() {
    	
    }
	
    //Validador de CPF
    public static boolean isCPF(String cpf) {
    	
    	cpf = cpf.replaceAll("[^0-9]", "");

        String[] invalidoCpf = {"00000000000","11111111111","22222222222","33333333333","44444444444","55555555555","66666666666",
                "77777777777","88888888888","99999999999"};

        for (String s : invalidoCpf) {
            if (cpf.contains(s) || cpf.length() != 11)
                return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Valida o primeiro Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            // Valida o primeiro Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (Exception e) {
            return (false);
        }
    }

    public static boolean isEmailValido(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
    
	public static String getTipoVacina(int resp) {
		switch (resp) {
			case 1 -> {
				return "CoronaVac";
			}
			case 2 -> {
				return "Oxford/Astrazeneca";
			}
			default -> System.out.println("Opção invalida");
		}

		return null;
	}

}
