package br.inatel.viagens.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nathalya
 * 
 */


public class Validador {
    public static boolean validarEmail(String email){   //Usa static para não ter que criar um objeto para usar apenas um método talvez
        //.trim() -> retorna o texto sem os espaços em branco no ínicio e fim do texto
        if ((email == null) || (email.trim().length() == 0))
            return false;
        
        //Regex para conferir se o email é valido ou não
        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    public static boolean validarSenha(String senha){
        if(senha.length() < 6 || senha.length() > 15)
            return false;
        else 
            return true;
    }
    
    public static boolean validarData(String data){
        String dateFormat = "dd/MM/uuuu";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
        
        try {
            LocalDate date = LocalDate.parse(data, dateTimeFormatter);
        } catch (DateTimeParseException e) {
           return false;
        } 
        
        Calendar calendario = Calendar.getInstance();
        
        int ano = Integer.parseInt(data.substring(6, 10));
        int mes = Integer.parseInt(data.substring(3, 5));
        int dia = Integer.parseInt(data.substring(0, 2));
        
        if(ano < calendario.get(Calendar.YEAR))
            return false;
        
        if(ano == calendario.get(Calendar.YEAR) && mes < calendario.get(Calendar.MONTH) + 1)
            return false;
        
        if(ano == calendario.get(Calendar.YEAR) && mes == calendario.get(Calendar.MONTH) + 1){
            if(dia < calendario.get(Calendar.DAY_OF_MONTH))
                return false;
        }
        
        return true;
    }
    
    public static boolean ValidarDataIdaVolta(String dataIda, String dataVolta){
        int diaIda = Integer.parseInt(dataIda.substring(0, 2));
        int diaVolta = Integer.parseInt(dataVolta.substring(0, 2));
        
        int mesIda = Integer.parseInt(dataIda.substring(3, 5));
        int mesVolta = Integer.parseInt(dataVolta.substring(3, 5));
        
        int anoIda = Integer.parseInt(dataIda.substring(6, 10));
        int anoVolta = Integer.parseInt(dataVolta.substring(6, 10));
        
        if(anoIda > anoVolta)
            return false;
        
        if(anoIda == anoVolta && mesIda > mesVolta)
            return false;
        
        if(anoIda == anoVolta && mesIda == mesVolta){
            if(diaIda > diaVolta)
                return false;
        }
        
        return true;
    }
    
    public static boolean validarHora(String tempo){
        int hora = Integer.parseInt(tempo.substring(0, 2));
        int min = Integer.parseInt(tempo.substring(3, 5));
        
        if(hora < 0 || hora > 23)
            return false;
        
        if(min < 0 || min > 59)
            return false;
        
        return true;
    }
    
    public static boolean validarHoraIdaVoltaMesmoDia(String tempo1, String tempo2){
        int hora1 = Integer.parseInt(tempo1.substring(0, 2));
        int hora2 = Integer.parseInt(tempo2.substring(0, 2));
        
        int min1 = Integer.parseInt(tempo1.substring(3, 5));
        int min2 = Integer.parseInt(tempo2.substring(3, 5));
        
        if(hora1 > hora2)
            return false;
        
        if(hora1 == hora2){
            if(min1 > min2)
                return false;
        }
        
        return true;
    }
}
