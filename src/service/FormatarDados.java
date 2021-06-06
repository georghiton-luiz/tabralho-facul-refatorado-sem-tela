package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class FormatarDados {
	
    public static LocalDate formatarData(String dataNasc){

        try {
            DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatBR.parse(dataNasc);
            DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
            String dataConvertida = formatUS.format(date);
            return LocalDate.parse(dataConvertida);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getFoneFormatado(String fone) {
        fone = fone.replaceAll("[^0-9]", "");
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("(##) ####.####");
            mask.setValueContainsLiteralCharacters(false);
            if(!fone.equals("")) {
                return mask.valueToString(fone);
            }
            return null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fone;
    }

    public static String getCelFormatado(String celular) {
        celular = celular.replaceAll("[^0-9]", "");
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("(##) #####.####");
            mask.setValueContainsLiteralCharacters(false);
            if(!celular.equals("")) {
                return mask.valueToString(celular);
            }
            return celular = null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return celular;
    }

    public static String getCpfFormatado(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            if(ValidarDados.isCPF(cpf)) {
                return mask.valueToString(cpf);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cpf;
    }

    public static String getCepFormatado(String CEP) {
        CEP = CEP.replaceAll("[^0-9]", "");
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("##.###-##");
            mask.setValueContainsLiteralCharacters(false);
            if(CEP != null && !CEP.equals("")) {
                return mask.valueToString(CEP);
            }
            return null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CEP;
    }
    
    public static String getDataFormatado(String data) {
        data = data.replaceAll("[^0-9]", "");
        MaskFormatter mask;
        try {
            mask = new MaskFormatter("##/##/####");
            mask.setValueContainsLiteralCharacters(false);
            if(!data.equals("")) {
                return mask.valueToString(data);
            }
            return null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}
