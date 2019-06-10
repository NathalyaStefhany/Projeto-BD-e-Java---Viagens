package br.inatel.viagens.util;

/**
 * @author Nathalya
 * 
 */
public class ConverterTipos {
    public static String converterDataBD(String data){
        String novaData;
        
        novaData = data.substring(6, 10) + '-' + data.substring(3, 5) + '-' + data.substring(0, 2);
        
        return novaData;
    }
    
    public static String converterDataTela(String data){
        String novaData;
        
        novaData = data.substring(8, 10) + '/' + data.substring(5, 7) + '/' + data.substring(0, 4);
        
        return novaData;
    }
    
    public static String converterCaminhoImagem(String caminho){
        String novoCaminho = "";
        
        for(int i = 0; i < caminho.length(); i++){
            if(caminho.charAt(i) == '\\')
                novoCaminho += "\\\\";
            else
                novoCaminho += caminho.charAt(i);
        }
        
        return novoCaminho;
    }
}
