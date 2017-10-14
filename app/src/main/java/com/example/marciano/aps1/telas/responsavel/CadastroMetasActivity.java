package com.example.marciano.aps1.telas.responsavel;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.entidade.enumerado.Dificuldade;
import com.example.marciano.aps1.telas.DefaultActivity;

public class CadastroMetasActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_metas);

        Spinner cbbDificuldade = (Spinner) findViewById(R.id.cbbDificuldade);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Dificuldade.getAll());
        cbbDificuldade.setAdapter(adapter);
    }
}
