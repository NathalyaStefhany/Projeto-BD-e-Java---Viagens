package br.inatel.viagens.model.entities;

/**
 * @author Nathalya
 * 
 */
public class Lugares{
    private String destino;
    private String caminho;
    
    public static int continente;
    public static int campoSelecionado = -1;
    
    public Lugares(String destino, String caminho){
        super();
        
        this.destino = destino;
        this.caminho = caminho;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
