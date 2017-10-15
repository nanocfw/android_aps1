package com.example.marciano.aps1.adapters;

import com.example.marciano.aps1.entidade.Meta;

import java.util.List;

/**
 * Created by Marciano on 15/10/2017.
 */

public class ProgressoMeta {
    private Meta meta;
    private List<ProgressoFilho> progressoFilhos;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<ProgressoFilho> getProgressoFilhos() {
        return progressoFilhos;
    }

    public void setProgressoFilhos(List<ProgressoFilho> progressoFilhos) {
        this.progressoFilhos = progressoFilhos;
    }

    public ProgressoMeta(Meta meta, List<ProgressoFilho> progressoFilhos) {
        this.meta = meta;
        this.progressoFilhos = progressoFilhos;
    }
}
