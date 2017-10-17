package com.example.marciano.aps1.entidade;

import com.example.marciano.aps1.entidade.enumerado.Dificuldade;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Desafio implements Serializable {
    private long id;
    private Dificuldade dificuldade;
    private Materia materia;
    private String descricao;
    private ArrayList<String> alternativas;
    private int alternativaCorreta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public int getPontos() {
        switch (dificuldade) {
            case FACIL:
                return 10;
            case MEDIO:
                return 20;
            case DIFICIL:
                return 30;
            case EXPERT:
                return 40;
            default:
                return 0;
        }
    }


    public Desafio() {
        super();
        this.alternativas = new ArrayList<>();
    }
}
