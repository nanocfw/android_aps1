package com.example.marciano.aps1.adapters;

import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.entidade.Pessoa;

/**
 * Created by Marciano on 15/10/2017.
 */

public class ProgressoFilho {
    private Pessoa filho;
    private Meta meta;
    private long pontos;
    private int percErros;

    public Pessoa getFilho() {
        return filho;
    }

    public void setFilho(Pessoa filho) {
        this.filho = filho;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public int getPercErros() {
        return percErros;
    }

    public void setPercErros(int percErros) {
        this.percErros = percErros;
    }

    public ProgressoFilho(Pessoa filho, Meta meta, long pontos, int percErros) {
        this.filho = filho;
        this.meta = meta;
        this.pontos = pontos;
        this.percErros = percErros;
    }
}
