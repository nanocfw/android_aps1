package com.example.marciano.aps1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.classes.CadastroMateriaFilhos;

import java.util.ArrayList;

/**
 * Created by Marciano on 15/10/2017.
 * https://www.youtube.com/watch?v=sk9fRXu53Qs
 */

public class AdapterCadastroMateriaListaFilho extends ArrayAdapter<CadastroMateriaFilhos> implements android.widget.CompoundButton.OnCheckedChangeListener {

    public AdapterCadastroMateriaListaFilho(Context context, int resource, ArrayList<CadastroMateriaFilhos> objects) {
        super(context, resource, objects);
    }

    private static class FilhosHolder {
        CheckBox chkSelecionado;
        TextView lblNome;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        FilhosHolder fh;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.lv_lista_filhos, null);

            fh = new FilhosHolder();
            fh.chkSelecionado = (CheckBox) v.findViewById(R.id.chkSelecionado);
            fh.chkSelecionado.setOnCheckedChangeListener(this);
            v.setTag(fh);
        } else
            fh = (FilhosHolder) v.getTag();

        CadastroMateriaFilhos f = getItem(position);
        fh.chkSelecionado.setText(f.getFilho().getNome());
        fh.chkSelecionado.setTag(f);
        fh.chkSelecionado.setChecked(f.isSelecionado());

        return v;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        CadastroMateriaFilhos f = (CadastroMateriaFilhos) compoundButton.getTag();
        f.setSelecionado(isChecked);
    }
}
