package com.example.marciano.aps1.telas.filho;

import android.os.Bundle;
import android.widget.ListView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.AdapterFilhoProgressoMetas;
import com.example.marciano.aps1.adapters.classes.FilhoProgressoMeta;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.util.Banco;

import java.util.List;

public class PainelFilhoActivity extends DefaultActivity {
    AdapterFilhoProgressoMetas adapterFilhoProgressoMetas;
    List<FilhoProgressoMeta> lstMetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_filho);
        lstMetas = Banco.getIntance().getProgressoMetasFilho(Banco.getIntance().getUsuarioAutenticado());
        adapterFilhoProgressoMetas = new AdapterFilhoProgressoMetas(this, R.layout.lv_filho_lista_metas, lstMetas);
        ListView lv = (ListView) findViewById(R.id.lvMetas);
        lv.setAdapter(adapterFilhoProgressoMetas);
    }
}
