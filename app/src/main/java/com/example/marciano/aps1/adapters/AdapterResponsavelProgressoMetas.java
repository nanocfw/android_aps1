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
import com.example.marciano.aps1.adapters.classes.ResponsavelProgressoMeta;
import com.example.marciano.aps1.telas.responsavel.CadastroMetasActivity;
import com.example.marciano.aps1.telas.responsavel.PainelResponsavelActivity;
import com.example.marciano.aps1.util.Util;


import java.util.List;

/**
 * Created by Marciano on 15/10/2017.
 */

public class AdapterResponsavelProgressoMetas extends ArrayAdapter<ResponsavelProgressoMeta> implements View.OnClickListener {
    public AdapterResponsavelProgressoMetas(Context context, int resource, List<ResponsavelProgressoMeta> objects) {
        super(context, resource, objects);
    }

    @Override
    public void onClick(View view) {
        ResponsavelProgressoMeta m = (ResponsavelProgressoMeta) view.getTag();
        if (m != null) {
            Intent telaCadastroMetas = new Intent(getContext(), CadastroMetasActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("meta", m.getMeta());
            telaCadastroMetas.putExtras(b);
            ((PainelResponsavelActivity) getContext()).startActivityForResult(telaCadastroMetas, 1);
        }
    }

    private static class MetasHolder {
        ImageButton btnEditar;
        TextView lblDescricao;
        TextView lblDificuldade;
        TextView lblRecompensa;
        ListView lvFilhosMeta;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        MetasHolder mh;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_responsavel_lista_progresso_metas, null);
            mh = new MetasHolder();
            mh.btnEditar = (ImageButton) v.findViewById(R.id.btnEditarMeta);
            mh.btnEditar.setOnClickListener(this);
            mh.lblDescricao = (TextView) v.findViewById(R.id.lblDescricaoMeta);
            mh.lblDificuldade = (TextView) v.findViewById(R.id.lblDificuldade);
            mh.lblRecompensa = (TextView) v.findViewById(R.id.lblRecompensa);
            mh.lvFilhosMeta = (ListView) v.findViewById(R.id.lvFilhosMeta);

            v.setTag(mh);
        } else
            mh = (MetasHolder) v.getTag();


        ResponsavelProgressoMeta m = getItem(position);
        if (m != null) {
            mh.btnEditar.setTag(m);
            mh.lblDescricao.setText(m.getMeta().getDescricao());
            mh.lblDificuldade.setText(getContext().getString(R.string.adpt_progresso_metas_dificuldade) + " " + m.getMeta().getDificuldade().toString());
            mh.lblRecompensa.setText(m.getMeta().getRecompensa());

            AdapterResponsavelProgressoFilho adapterResponsavelProgressoFilho = new AdapterResponsavelProgressoFilho(getContext(), R.layout.lv_responsavel_lista_progresso_filhos, m.getResponsavelProgressoFilhos());
            mh.lvFilhosMeta.setAdapter(adapterResponsavelProgressoFilho);
            Util.setListViewHeightBasedOnChildren(mh.lvFilhosMeta);
        }
        return v;
    }
}
