package com.example.marciano.aps1.util;

import android.widget.ListView;

import com.example.marciano.aps1.adapters.classes.FilhoProgressoMeta;
import com.example.marciano.aps1.adapters.classes.ResponsavelProgressoFilho;
import com.example.marciano.aps1.adapters.classes.ResponsavelProgressoMeta;
import com.example.marciano.aps1.entidade.Desafio;
import com.example.marciano.aps1.entidade.Materia;
import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.entidade.enumerado.Dificuldade;
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
        responsavel.setNome("Responsável 123");
        responsavel.setPontuacao(0.0);
        responsavel.setTipoPessoa(TipoPessoa.RESPONSAVEL);

        listaPessoas.add(responsavel);

        Pessoa filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho1@asd.com");
        filho.setSenha("123");
        filho.setNome("CadastroMateriaFilhos 1");
        filho.setPontuacao(0.0);
        filho.setTipoPessoa(TipoPessoa.FILHO);
        responsavel.getFilhos().add(filho);
        listaPessoas.add(filho);

        filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho2@asd.com");
        filho.setSenha("123");
        filho.setNome("CadastroMateriaFilhos 2");
        filho.setPontuacao(0.0);
        filho.setTipoPessoa(TipoPessoa.FILHO);
        responsavel.getFilhos().add(filho);
        listaPessoas.add(filho);

        filho = new Pessoa();
        filho.setId(sequenciaPessoa++);
        filho.setEmail("filho3@asd.com");
        filho.setSenha("123");
        filho.setNome("CadastroMateriaFilhos 3");
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
        listaMaterias.add(materia);

        Meta meta = new Meta();
        meta.setId(sequenciaMeta++);
        meta.setDescricao("100 pts Matemática, 50% erros");
        meta.setRecompensa("recompensa 1");
        meta.setDificuldade(Dificuldade.MEDIO);
        meta.setPontosMeta(100);
        meta.setPercErros(50);
        meta.getFilhos().add(getPessoa(2));
        meta.getFilhos().add(getPessoa(3));
        meta.getFilhos().add(getPessoa(4));
        meta.setResponsavel(getPessoa(1));
        meta.setMateria(getMateria("Matemática"));
        listaMetas.add(meta);

        meta = new Meta();
        meta.setId(sequenciaMeta++);
        meta.setDescricao("100 pts Português, 10% erros");
        meta.setRecompensa("recompensa 2");
        meta.setDificuldade(Dificuldade.FACIL);
        meta.setPontosMeta(100);
        meta.setPercErros(50);
        meta.getFilhos().add(getPessoa(2));
        meta.getFilhos().add(getPessoa(3));
        meta.getFilhos().add(getPessoa(4));
        meta.setResponsavel(getPessoa(1));
        meta.setMateria(getMateria("Português"));
        listaMetas.add(meta);

        meta = new Meta();
        meta.setId(sequenciaMeta++);
        meta.setDescricao("100 pts História, 60% erros");
        meta.setRecompensa("recompensa 3");
        meta.setDificuldade(Dificuldade.EXPERT);
        meta.setPontosMeta(100);
        meta.setPercErros(50);
        meta.getFilhos().add(getPessoa(2));
        meta.getFilhos().add(getPessoa(3));
        meta.getFilhos().add(getPessoa(4));
        meta.setResponsavel(getPessoa(1));
        meta.setMateria(getMateria("História"));
        listaMetas.add(meta);


//        Desafio desafio = new Desafio();
//        desafio.setId(sequenciaDesafio++);
//        desafio.setDescricao("lkasmnkasdmk");
//        desafio.setMateria(getMateria("Matemática"));
//        listaDesafios.add(desafio);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        if (pessoa.getId() > 0)
            listaPessoas.set(listaPessoas.indexOf(getPessoa(pessoa.getId())), pessoa);
        else {
            pessoa.setId(sequenciaPessoa++);
            this.listaPessoas.add(pessoa);
        }
    }

    public void cadastrarMateria(Materia materia) {
        if (materia.getId() > 0)
            listaMaterias.set(listaMaterias.indexOf(getMateria(materia.getId())), materia);
        else
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

    public boolean isEmailInUse(String email, long id) {
        for (Pessoa p : listaPessoas)
            if (p.getEmail().equals(email) && p.getId() != id)
                return true;
        return false;
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

    public String[] getListMaterias() {
        String[] aux = new String[listaMaterias.size()];

        for (int i = 0; i < listaMaterias.size(); i++)
            aux[i] = listaMaterias.get(i).getNome();

        return aux;
    }

    public Meta getMeta(long id) {
        for (Meta m : listaMetas)
            if (m.getId() == id)
                return m;
        return null;
    }

    public void cadastrarMeta(Meta meta) {
        if (meta.getId() > 0)
            listaMetas.set(listaMetas.indexOf(getMeta(meta.getId())), meta);
        else {
            meta.setId(sequenciaMeta++);
            listaMetas.add(meta);
        }
    }

    public static Banco getIntance() {
        if (instance == null)
            instance = new Banco();

        return instance;
    }

    public List<ResponsavelProgressoFilho> getProgressoFilhos(Meta meta) {
        List<ResponsavelProgressoFilho> aux = new ArrayList<>();
        for (Pessoa p : meta.getFilhos())
            aux.add(new ResponsavelProgressoFilho(p, meta, Util.randomInt(0, meta.getPontosMeta()), Util.randomInt(1, 99), Util.randomInt(1, 99)));

        return aux;
    }

    public List<ResponsavelProgressoMeta> getProgressoMetas() {
        List<ResponsavelProgressoMeta> aux = new ArrayList<>();
        for (Meta m : listaMetas)
            aux.add(new ResponsavelProgressoMeta(m, getProgressoFilhos(m)));

        return aux;
    }

    public List<ResponsavelProgressoMeta> getProgressoMetas(String busca) {
        List<ResponsavelProgressoMeta> aux = new ArrayList<>();
        for (Meta m : listaMetas)
            if (m.getDescricao().toLowerCase().contains(busca.toLowerCase()))
                aux.add(new ResponsavelProgressoMeta(m, getProgressoFilhos(m)));

        return aux;
    }

    public List<FilhoProgressoMeta> getProgressoMetasFilho(Pessoa filho) {
        List<FilhoProgressoMeta> aux = new ArrayList<>();
        for (Meta m : listaMetas)
            for (Pessoa p : m.getFilhos())
                if (p.getId() == filho.getId())
                    aux.add(new FilhoProgressoMeta(m, Util.randomInt(0, m.getPontosMeta()), Util.randomInt(1, 99), Util.randomInt(1, 99)));
        return aux;
    }
}
