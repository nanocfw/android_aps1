package com.example.marciano.aps1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.entidade.Pessoa;

import java.util.List;

/**
 * Created by Marciano on 15/10/2017.
 */

public class AdapterListaPessoa extends ArrayAdapter<Pessoa> {
    public AdapterListaPessoa(Context context, int resource, List<Pessoa> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_lista_pessoas, null);
        }

        TextView lblNome = (TextView) v.findViewById(R.id.lblNome);
        TextView lblEmail = (TextView) v.findViewById(R.id.lblEmail);
        Pessoa p = getItem(position);
        if (p != null) {
            lblNome.setText(p.getNome());
            lblEmail.setText(p.getEmail());
        }
        return v;
    }
}
