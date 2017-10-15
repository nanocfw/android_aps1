package com.example.marciano.aps1.adapters;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.telas.responsavel.CadastroMetasActivity;
import com.example.marciano.aps1.util.Util;


import java.util.List;

/**
 * Created by Marciano on 15/10/2017.
 */

public class AdapterProgressoMetas extends ArrayAdapter<ProgressoMeta> implements View.OnClickListener {

    List<ProgressoMeta> lstMetas;

    public AdapterProgressoMetas(Context context, int resource, List<ProgressoMeta> objects) {
        super(context, resource, objects);
        lstMetas = objects;
    }

    @Override
    public void onClick(View view) {
        ProgressoMeta m = (ProgressoMeta) view.getTag();
        if (m != null) {
            Intent telaCadastroMetas = new Intent(getContext(), CadastroMetasActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("meta", m.getMeta());
            telaCadastroMetas.putExtras(b);
            getContext().startActivity(telaCadastroMetas);
        }
    }

    private static class MetasHolder {
        ImageButton btnEditar;
        TextView lblDescricao;
        TextView lblRecompensa;
        ListView lvFilhosMeta;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        MetasHolder mh;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_lista_metas, null);
            mh = new MetasHolder();
            mh.btnEditar = (ImageButton) v.findViewById(R.id.btnEditarMeta);
            mh.btnEditar.setOnClickListener(this);
            mh.lblDescricao = (TextView) v.findViewById(R.id.lblDescricaoMeta);
            mh.lblRecompensa = (TextView) v.findViewById(R.id.lblRecompensa);
            mh.lvFilhosMeta = (ListView) v.findViewById(R.id.lvFilhosMeta);

            v.setTag(mh);
        } else
            mh = (MetasHolder) v.getTag();


        ProgressoMeta m = lstMetas.get(position);
        if (m != null) {
            mh.btnEditar.setTag(m);
            mh.lblDescricao.setText(m.getMeta().getDescricao());
            mh.lblRecompensa.setText(m.getMeta().getRecompensa());

            if (mh.lvFilhosMeta.getTag() == null) {
                AdapterProgressoFilho adapterProgressoFilho = new AdapterProgressoFilho(getContext(), R.layout.lv_lista_progresso_filhos, m.getProgressoFilhos());
                mh.lvFilhosMeta.setAdapter(adapterProgressoFilho);
                mh.lvFilhosMeta.setTag(adapterProgressoFilho);
                Util.setListViewHeightBasedOnChildren(mh.lvFilhosMeta);
            }
        }
        return v;
    }
}
