package com.example.marciano.aps1.entidade;

import java.io.Serializable;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Materia implements Serializable{
    private int id;
    private String nome;

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

    public Materia() {
        super();
    }
}
