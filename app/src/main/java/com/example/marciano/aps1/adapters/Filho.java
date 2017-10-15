package com.example.marciano.aps1.adapters;

import com.example.marciano.aps1.entidade.Pessoa;

/**
 * Created by Marciano on 15/10/2017.
 */

public class Filho {
    private Pessoa filho;
    private boolean selecionado = false;

    public Pessoa getFilho() {
        return filho;
    }

    public void setFilho(Pessoa filho) {
        this.filho = filho;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Filho(Pessoa filho) {
        this.filho = filho;
    }
}
