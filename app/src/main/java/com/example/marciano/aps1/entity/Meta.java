package com.example.marciano.aps1.entity;

import com.example.marciano.aps1.entity.enums.Dificuldade;

import java.util.List;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Meta {
    private long id;
    private Pessoa responsavel;
    private String descricao;
    private Materia materia;
    private List<Pessoa> filhos;
    private long pontos;
    private float percErros;
    private String recompensa;
    private Dificuldade dificuldade;
    private boolean paga;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Pessoa> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Pessoa> filhos) {
        this.filhos = filhos;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public float getPercErros() {
        return percErros;
    }

    public void setPercErros(float percErros) {
        this.percErros = percErros;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public Meta() {
        super();
    }
}
