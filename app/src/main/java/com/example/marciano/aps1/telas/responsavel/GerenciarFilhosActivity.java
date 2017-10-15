package com.example.marciano.aps1.telas.responsavel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.AdapterListaPessoa;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.util.Banco;

import java.util.ArrayList;
import java.util.List;

public class GerenciarFilhosActivity extends DefaultActivity {

    private List<Pessoa> filhos;
    private AdapterListaPessoa adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar_filho);

        ListView lv = (ListView) findViewById(R.id.lvFilhos);
        filhos = Banco.getIntance().getUsuarioAutenticado().getFilhos();
        adapterView = new AdapterListaPessoa(this, R.layout.lv_lista_pessoas, filhos);
        lv.setAdapter(adapterView);

        FloatingActionButton btnNovoFilho = (FloatingActionButton) findViewById(R.id.btnNovoFilho);
        btnNovoFilho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBtnNovoFilhoClick(v);
            }
        });
    }

    public void onBtnNovoFilhoClick(View view) {//https://stackoverflow.com/questions/10903754/input-text-dialog-android
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Informe o email do filho");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email = input.getText().toString();
                Pessoa p = Banco.getIntance().getPessoa(email);
                if (p == null) {
                    alert("Email não foi encontrado");
                    return;
                }

                if (!Banco.getIntance().getUsuarioAutenticado().adicionarFilho(p))
                    alert("Email já cadastrado");
                else {
                    filhos = Banco.getIntance().getUsuarioAutenticado().getFilhos();
                    // o objeto "filhos" é o mesmo que está no adapter, ao atualizá-lo, dentro do adapter também atualiza, nesse caso é necessário apenas enviar a notificação
                    //adapterView.clear();
                    //adapterView.addAll(filhos);
                    adapterView.notifyDataSetChanged();
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
