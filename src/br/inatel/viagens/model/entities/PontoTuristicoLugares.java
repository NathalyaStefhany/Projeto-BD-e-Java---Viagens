package br.inatel.viagens.model.entities;

/**
 * @author Nathalya
 *
 */

public class PontoTuristicoLugares {
    private int id;
    private String nome;
    private String endereco;
    private double preco;
    
    public static double latitude;
    public static double longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}