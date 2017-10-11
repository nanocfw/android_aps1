package com.example.marciano.aps1.entity.enums;

/**
 * Created by Marciano on 10/10/2017.
 */

public enum TipoDesafio {
    MULTIPLA_ESCOLHA, RESPOSTA_EXATA;

    @Override
    public String toString() {
        return asString(this);
    }

    public static String asString(TipoDesafio tipoDesafio) {
        switch (tipoDesafio) {
            case MULTIPLA_ESCOLHA:
                return "Múltipla Escolha";
            case RESPOSTA_EXATA:
                return "Resposta Exata";
            default:
                return "Tipo inválido";
        }
    }

    public static String[] getAll() {
        TipoDesafio[] t = values();
        String[] aux = new String[t.length];

        for (int i = 0; i < t.length; i++)
            aux[i] = asString(t[i]);

        return aux;
    }
}
