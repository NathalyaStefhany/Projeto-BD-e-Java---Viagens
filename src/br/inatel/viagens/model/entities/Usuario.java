package br.inatel.viagens.model.entities;

/**
 * @author Nathalya
 * 
 */

public class Usuario {
    private String nome;
    public static String usuarioLogado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
