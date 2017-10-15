package com.example.marciano.aps1.entidade;

import com.example.marciano.aps1.entidade.enumerado.Dificuldade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Meta implements Serializable {
    private long id;
    private Pessoa responsavel;
    private String descricao;
    private Materia materia;
    private List<Pessoa> filhos;
    private int pontosMeta;
    private int percErros;
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

    public int getPontosMeta() {
        return pontosMeta;
    }

    public void setPontosMeta(int pontosMeta) {
        this.pontosMeta = pontosMeta;
    }

    public int getPercErros() {
        return percErros;
    }

    public void setPercErros(int percErros) {
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
        this.filhos = new ArrayList<>();
    }
}
