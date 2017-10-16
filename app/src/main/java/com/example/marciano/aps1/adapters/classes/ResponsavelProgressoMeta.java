package com.example.marciano.aps1.adapters.classes;

import com.example.marciano.aps1.entidade.Meta;

import java.util.List;

/**
 * Created by Marciano on 15/10/2017.
 */

public class ResponsavelProgressoMeta {
    private Meta meta;
    private List<ResponsavelProgressoFilho> responsavelProgressoFilhos;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<ResponsavelProgressoFilho> getResponsavelProgressoFilhos() {
        return responsavelProgressoFilhos;
    }

    public void setResponsavelProgressoFilhos(List<ResponsavelProgressoFilho> responsavelProgressoFilhos) {
        this.responsavelProgressoFilhos = responsavelProgressoFilhos;
    }

    public ResponsavelProgressoMeta(Meta meta, List<ResponsavelProgressoFilho> responsavelProgressoFilhos) {
        this.meta = meta;
        this.responsavelProgressoFilhos = responsavelProgressoFilhos;
    }
}
