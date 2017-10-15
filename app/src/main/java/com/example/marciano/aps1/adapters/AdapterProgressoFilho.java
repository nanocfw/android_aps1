package com.example.marciano.aps1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.marciano.aps1.R;

import java.util.List;


/**
 * Created by Marciano on 15/10/2017.
 */

public class AdapterProgressoFilho extends ArrayAdapter<ProgressoFilho> {
    private List<ProgressoFilho> lstProgressoFilhos;

    public AdapterProgressoFilho(Context context, int resource, List<ProgressoFilho> objects) {
        super(context, resource, objects);
        lstProgressoFilhos = objects;
    }

    private static class ProgressoFilhoHolder {
        TextView lblFilho;
        ProgressBar pbProgresso;
        TextView lblPercErros;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ProgressoFilhoHolder fh;

        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_lista_progresso_filhos, null);
        }

        if (v.getTag() == null) {
            fh = new ProgressoFilhoHolder();
            fh.lblFilho = (TextView) v.findViewById(R.id.lblFilho);
            fh.pbProgresso = (ProgressBar) v.findViewById(R.id.pbProgresso);
            fh.lblPercErros = (TextView) v.findViewById(R.id.lblPercErros);
        } else fh = (ProgressoFilhoHolder) v.getTag();

        ProgressoFilho p = lstProgressoFilhos.get(position);
        if (p != null) {
            fh.lblFilho.setText(p.getFilho().getNome());
            fh.lblPercErros.setText("Erros: " + p.getPercErros() + "%");
            float progresso = (((float) p.getPontos() / (float) p.getMeta().getPontosMeta()) * 100);
            progresso = (progresso > 100) ? 100 : progresso;
            fh.pbProgresso.setProgress(Math.round(progresso));
        }

        return v;
    }
}
