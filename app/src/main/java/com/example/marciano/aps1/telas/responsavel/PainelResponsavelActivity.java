package com.example.marciano.aps1.telas.responsavel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.classes.ResponsavelProgressoMeta;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.telas.geral.CadastroActivity;
import com.example.marciano.aps1.adapters.AdapterResponsavelProgressoMetas;
import com.example.marciano.aps1.util.Banco;

import java.util.List;


public class PainelResponsavelActivity extends DefaultActivity {
    ListView lvMetas;
    List<ResponsavelProgressoMeta> lstResponsavelProgressoMetas;
    AdapterResponsavelProgressoMetas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_responsavel);
        ((TextView) findViewById(R.id.lblUsuarioAutenticado)).setText(getString(R.string.bem_vindo) + " " + Banco.getIntance().getUsuarioAutenticado().getNome());
        lvMetas = (ListView) findViewById(R.id.lvMetas);
        lstResponsavelProgressoMetas = Banco.getIntance().getProgressoMetas();
        adapter = new AdapterResponsavelProgressoMetas(this, R.layout.lv_responsavel_lista_progresso_filhos, lstResponsavelProgressoMetas);
        lvMetas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_painel_responsavel, menu);
        MenuItem item = menu.findItem(R.id.itemMenuPesquisar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(onSearch());
        return super.onCreateOptionsMenu(menu);
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
            lstResponsavelProgressoMetas = Banco.getIntance().getProgressoMetas();
            adapter.clear();
            adapter.addAll(lstResponsavelProgressoMetas);
            adapter.notifyDataSetChanged();
        }
    }

    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                lstResponsavelProgressoMetas = Banco.getIntance().getProgressoMetas(s);
                adapter.clear();
                adapter.addAll(lstResponsavelProgressoMetas);
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()) {
                    lstResponsavelProgressoMetas = Banco.getIntance().getProgressoMetas();
                    adapter.clear();
                    adapter.addAll(lstResponsavelProgressoMetas);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        };
    }
}
