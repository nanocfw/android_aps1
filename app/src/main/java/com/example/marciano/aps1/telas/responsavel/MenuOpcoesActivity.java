package com.example.marciano.aps1.telas.responsavel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.ProgressoMeta;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.telas.geral.CadastroActivity;
import com.example.marciano.aps1.adapters.AdapterProgressoMetas;
import com.example.marciano.aps1.util.Banco;

import java.util.List;


public class MenuOpcoesActivity extends DefaultActivity {
    ListView lvMetas;
    List<ProgressoMeta> lstProgressoMetas;
    AdapterProgressoMetas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);
        ((TextView) findViewById(R.id.lblUsuarioAutenticado)).setText(getString(R.string.bem_vindo) + Banco.getIntance().getUsuarioAutenticado().getNome());
        lvMetas = (ListView) findViewById(R.id.lstMetas);
        lstProgressoMetas = Banco.getIntance().getProgressoMetas();
        adapter = new AdapterProgressoMetas(this, R.layout.lv_lista_progresso_filhos, lstProgressoMetas);
        lvMetas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMenuMeusDados: {
                Intent telaCadastro = new Intent(this, CadastroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pessoa", Banco.getIntance().getUsuarioAutenticado());
                telaCadastro.putExtras(bundle);
                startActivity(telaCadastro);
                return true;
            }
            case R.id.itemMenuFilhos: {
                Intent telaFilhos = new Intent(this, GerenciarFilhosActivity.class);
                startActivity(telaFilhos);
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBtnNovaMetaClick(View view) {
        Intent telaCadastroMetas = new Intent(this, CadastroMetasActivity.class);
        startActivityForResult(telaCadastroMetas, 1);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            lstProgressoMetas = Banco.getIntance().getProgressoMetas();
            adapter.clear();
            adapter.addAll(lstProgressoMetas);
            adapter.notifyDataSetChanged();
        }
    }
}
