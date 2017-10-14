package com.example.marciano.aps1.util;

import com.example.marciano.aps1.entidade.Desafio;
import com.example.marciano.aps1.entidade.Materia;
import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.entidade.enumerado.TipoPessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marciano on 14/10/2017.
 */

public class Banco {
    private static Banco instance;

    private List<Pessoa> listaPessoas;
    private List<Desafio> listaDesafios;
    private List<Materia> listaMaterias;
    private List<Meta> listaMetas;

    private long sequenciaPessoa;
    private int sequenciaMateria;
    private long sequenciaDesafio;
    private long sequenciaHistorico;
    private long sequenciaMeta;

    private Pessoa usuarioAutenticado;

    public Pessoa getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Pessoa usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public Banco(Pessoa usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public Banco() {
        super();
        listaPessoas = new ArrayList<>();
        listaDesafios = new ArrayList<>();
        listaMaterias = new ArrayList<>();
        listaMetas = new ArrayList<>();
        usuarioAutenticado = null;
        sequenciaPessoa = 1;
        sequenciaMateria = 1;
        sequenciaDesafio = 1;
        sequenciaHistorico = 1;
        sequenciaMeta = 1;

        Pessoa responsavel = new Pessoa();
        responsavel.setId(sequenciaPessoa++);
        responsavel.setEmail("resp@asd.com");
        responsavel.setSenha("123");
        responsavel.setNome("Responsável");
        responsavel.setPontuacao(0.0);
        responsavel.setTipoPessoa(TipoPessoa.RESPONSAVEL);

        listaPessoas.add(responsavel);

        Pessoa filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho1@asd.com");
        filho.setSenha("123");
        filho.setNome("Filho 1");
        filho.setPontuacao(0.0);
        filho.setTipoPessoa(TipoPessoa.FILHO);
        responsavel.getFilhos().add(filho);
        listaPessoas.add(filho);

        filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho2@asd.com");
        filho.setSenha("123");
        filho.setNome("Filho 2");
        filho.setPontuacao(0.0);
        filho.setTipoPessoa(TipoPessoa.FILHO);
        responsavel.getFilhos().add(filho);
        listaPessoas.add(filho);

        filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho3@asd.com");
        filho.setSenha("123");
        filho.setNome("Filho 3");
        filho.setPontuacao(0.0);
        filho.setTipoPessoa(TipoPessoa.FILHO);
        responsavel.getFilhos().add(filho);
        listaPessoas.add(filho);

        Materia materia = new Materia();
        materia.setId(sequenciaMateria++);
        materia.setNome("Matemática");
        listaMaterias.add(materia);

        materia = new Materia();
        materia.setId(sequenciaMateria++);
        materia.setNome("Português");
        listaMaterias.add(materia);

        materia = new Materia();
        materia.setId(sequenciaMateria++);
        materia.setNome("História");

//        Desafio desafio = new Desafio();
//        desafio.setId(sequenciaDesafio++);
//        desafio.setDescricao("lkasmnkasdmk");
//        desafio.setMateria(getMateria("Matemática"));
//        listaDesafios.add(desafio);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoa.setId(sequenciaPessoa++);
        this.listaPessoas.add(pessoa);
    }

    public void cadastrarMateria(Materia materia) {
        materia.setId(sequenciaMateria++);
        this.listaMaterias.add(materia);
    }

    public Materia getMateria(String nomeMateria) {
        for (Materia m : listaMaterias)
            if (m.getNome().equals(nomeMateria))
                return m;
        return null;
    }

    public Materia getMateria(int idMateria) {
        for (Materia m : listaMaterias)
            if (m.getId() == idMateria)
                return m;
        return null;
    }

    public Pessoa getPessoa(String email) {
        for (Pessoa p : listaPessoas)
            if (p.getEmail().equals(email))
                return p;
        return null;
    }

    public Pessoa getPessoa(String email, String senha) {
        for (Pessoa p : listaPessoas)
            if (p.getEmail().equals(email) && p.getSenha().equals(senha))
                return p;
        return null;
    }

    public Pessoa getPessoa(long id) {
        for (Pessoa p : listaPessoas)
            if (p.getId() == id)
                return p;
        return null;
    }


    public static Banco getIntance() {
        if (instance == null)
            instance = new Banco();

        return instance;
    }
}
