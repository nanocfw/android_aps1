package com.example.marciano.aps1.entidade;

import java.io.Serializable;

/**
 * Created by Marciano on 10/10/2017.
 */

public class HistoricoUsuario implements Serializable{
    private long id;
    private Pessoa pessoa;
    private Desafio desafio;
    private int tentativas;
    private long pontosAdquiridos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Desafio getDesafio() {
        return desafio;
    }

    public void setDesafio(Desafio desafio) {
        this.desafio = desafio;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public long getPontosAdquiridos() {
        return pontosAdquiridos;
    }

    public void setPontosAdquiridos(long pontosAdquiridos) {
        this.pontosAdquiridos = pontosAdquiridos;
    }

    public HistoricoUsuario() {
        super();
    }
}
