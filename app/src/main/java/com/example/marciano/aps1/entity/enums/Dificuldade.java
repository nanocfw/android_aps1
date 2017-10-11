package com.example.marciano.aps1.entity.enums;

/**
 * Created by Marciano on 10/10/2017.
 */

public enum Dificuldade {
    FACIL, MEDIO, DIFICIL, EXPERT;

    @Override
    public String toString() {
        return asString(this);
    }

    public static String asString(Dificuldade d) {
        switch (d) {
            case FACIL:
                return "Fácil";
            case MEDIO:
                return "Médio";
            case DIFICIL:
                return "Difícil";
            case EXPERT:
                return "Expert";
            default:
                return "Inválido";
        }
    }

    public static String[] getAll() {
        Dificuldade[] d = values();
        String[] aux = new String[d.length];

        for (int i = 0; i < d.length; i++)
            aux[i] = asString(d[i]);

        return aux;
    }
}
