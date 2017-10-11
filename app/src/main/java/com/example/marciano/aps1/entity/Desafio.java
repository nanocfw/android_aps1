package com.example.marciano.aps1.entity;

import com.example.marciano.aps1.entity.enums.Dificuldade;
import com.example.marciano.aps1.entity.enums.TipoDesafio;

import java.util.ArrayList;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Desafio {
    private long id;
    private Dificuldade dificuldade;
    private Materia materia;
    private TipoDesafio tipoDesafio;
    private String descricao;
    private ArrayList<Object> opcoesUsuario;
    private int respostaCorreta;
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

    public ArrayList<Object> getOpcoesUsuario() {
        return opcoesUsuario;
    }

    public void setOpcoesUsuario(ArrayList<Object> opcoesUsuario) {
        this.opcoesUsuario = opcoesUsuario;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
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
