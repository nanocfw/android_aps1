package com.example.marciano.aps1.adapters.classes;

import com.example.marciano.aps1.entidade.Meta;

/**
 * Created by Marciano on 16/10/2017.
 */

public class FilhoProgressoMeta {
    private Meta meta;
    private long pontos;
    private int percErros;
    private int desafiosRealizados;

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

    public int getDesafiosRealizados() {
        return desafiosRealizados;
    }

    public void setDesafiosRealizados(int desafiosRealizados) {
        this.desafiosRealizados = desafiosRealizados;
    }

    public FilhoProgressoMeta(Meta meta, long pontos, int percErros, int desafiosRealizados) {
        this.meta = meta;
        this.pontos = pontos;
        this.percErros = percErros;
        this.desafiosRealizados = desafiosRealizados;
    }
}
