package br.inatel.viagens.model.entities;

/**
 * @author Nathalya
 * 
 */

public class Transporte {
    private String tipo;
    private String horarioIda;
    private String horarioVolta;
    private String preco;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorarioIda() {
        return horarioIda;
    }

    public void setHorarioIda(String horarioIda) {
        this.horarioIda = horarioIda;
    }

    public String getHorarioVolta() {
        return horarioVolta;
    }

    public void setHorarioVolta(String horarioVolta) {
        this.horarioVolta = horarioVolta;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
