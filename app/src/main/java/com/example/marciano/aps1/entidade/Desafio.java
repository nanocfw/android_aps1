package com.example.marciano.aps1.entidade;

import com.example.marciano.aps1.entidade.enumerado.Dificuldade;
import com.example.marciano.aps1.entidade.enumerado.TipoDesafio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Desafio implements Serializable {
    private long id;
    private Dificuldade dificuldade;
    private Materia materia;
    private TipoDesafio tipoDesafio;
    private String descricao;
    private ArrayList<String> alternativas;
    private int alternativaCorreta;
    private long pontos;

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

    public TipoDesafio getTipoDesafio() {
        return tipoDesafio;
    }

    public void setTipoDesafio(TipoDesafio tipoDesafio) {
        this.tipoDesafio = tipoDesafio;
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

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public Desafio() {
        super();
    }
}
