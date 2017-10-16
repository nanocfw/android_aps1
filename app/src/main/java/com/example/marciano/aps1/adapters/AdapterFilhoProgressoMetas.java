package com.example.marciano.aps1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.classes.FilhoProgressoMeta;

import java.util.List;

/**
 * Created by Marciano on 16/10/2017.
 */

public class AdapterFilhoProgressoMetas extends ArrayAdapter<FilhoProgressoMeta> {

    public AdapterFilhoProgressoMetas(Context context, int resource, List<FilhoProgressoMeta> objects) {
        super(context, resource, objects);
    }

    private static class ProgressoHolder {
        TextView lblDescricao;
        TextView lblRecompensa;
        TextView lblDificuldade;
        TextView lblPontosNecessarios;
        TextView lblMaxErros;
        TextView lblDesafios;
        TextView lblPercErros;
        ProgressBar pbProgresso;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ProgressoHolder ph;

        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_filho_lista_metas, null);
            ph = new ProgressoHolder();
            ph.lblDescricao = (TextView) v.findViewById(R.id.lblDescricaoMeta);
            ph.lblRecompensa = (TextView) v.findViewById(R.id.lblRecompensa);
            ph.lblDificuldade = (TextView) v.findViewById(R.id.lblDificuldade);
            ph.lblPontosNecessarios = (TextView) v.findViewById(R.id.lblMinPontos);
            ph.lblMaxErros = (TextView) v.findViewById(R.id.lblMaxErros);
            ph.lblDesafios = (TextView) v.findViewById(R.id.lblDesafiosRealizados);
            ph.lblPercErros = (TextView) v.findViewById(R.id.lblPercErros);
            ph.pbProgresso = (ProgressBar) v.findViewById(R.id.pbProgresso);
            v.setTag(ph);
        } else
            ph = (ProgressoHolder) v.getTag();

        FilhoProgressoMeta f = getItem(position);
        if (f != null) {
            ph.lblDescricao.setText(f.getMeta().getDescricao());
            ph.lblRecompensa.setText(f.getMeta().getRecompensa());
            ph.lblDificuldade.setText(getContext().getString(R.string.adpt_progresso_metas_dificuldade) + " " + f.getMeta().getDificuldade().toString());
            ph.lblPontosNecessarios.setText(String.valueOf(f.getMeta().getPontosMeta()));
            ph.lblMaxErros.setText(String.valueOf(f.getMeta().getPercErros()) + "%");
            ph.lblDesafios.setText(String.valueOf(f.getDesafiosRealizados()));
            ph.lblPercErros.setText(String.valueOf(f.getPercErros()) + "%");
            float progresso = (((float) f.getPontos() / (float) f.getMeta().getPontosMeta()) * 100);
            progresso = (progresso > 100) ? 100 : progresso;
            ph.pbProgresso.setProgress(Math.round(progresso));
            ph.pbProgresso.setTag(f);

            ph.pbProgresso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FilhoProgressoMeta p = (FilhoProgressoMeta) view.getTag();
                    if (p != null) {
                        String msg = "Pontos: " + p.getPontos() + "/" + p.getMeta().getPontosMeta();
                        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return v;
    }
}
