package com.example.marciano.aps1.adapters.classes;

import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.entidade.Pessoa;

/**
 * Created by Marciano on 15/10/2017.
 */

public class ResponsavelProgressoFilho {
    private Pessoa filho;
    private Meta meta;
    private long pontos;
    private int percErros;
    private int desafiosRealizados;

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

    public int getDesafiosRealizados() {
        return desafiosRealizados;
    }

    public void setDesafiosRealizados(int desafiosRealizados) {
        this.desafiosRealizados = desafiosRealizados;
    }

    public ResponsavelProgressoFilho(Pessoa filho, Meta meta, long pontos, int percErros, int desafiosRealizados) {
        this.filho = filho;
        this.meta = meta;
        this.pontos = pontos;
        this.percErros = percErros;
        this.desafiosRealizados = desafiosRealizados;
    }
}
