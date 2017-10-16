package com.example.marciano.aps1.entidade.enumerado;

/**
 * Created by Marciano on 10/10/2017.
 */

public enum TipoPessoa {
    RESPONSAVEL, FILHO;

    public String toString() {
        return asString(this);
    }

    public static String asString(TipoPessoa tipoPessoa) {
        switch (tipoPessoa) {
            case RESPONSAVEL:
                return "Responsável";
            case FILHO:
                return "CadastroMateriaFilhos";
            default:
                return "Tipo inválido";
        }
    }

    public static String[] getAll() {
        TipoPessoa[] t = values();
        String[] aux = new String[t.length];

        for (int i = 0; i < t.length; i++)
            aux[i] = asString(t[i]);

        return aux;
    }
}


