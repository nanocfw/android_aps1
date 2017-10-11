package com.example.marciano.aps1.entity;

import com.example.marciano.aps1.entity.enums.TipoPessoa;

import java.util.List;

/**
 * Created by Marciano on 10/10/2017.
 */

public class Pessoa {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private TipoPessoa tipoPessoa;
    private Double pontuacao;
    private List<HistoricoUsuario> historicoUsuario;
    private List<Pessoa> filhos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<HistoricoUsuario> getHistoricoUsuario() {
        return historicoUsuario;
    }

    public List<Pessoa> getFilhos() {
        return filhos;
    }

    public Pessoa() {
        super();
    }

}
