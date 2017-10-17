package com.example.marciano.aps1.telas.filho;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.AdapterCheckListView;
import com.example.marciano.aps1.entidade.Desafio;
import com.example.marciano.aps1.entidade.HistoricoUsuario;
import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.util.Banco;
import com.example.marciano.aps1.util.Util;

import java.util.ArrayList;

public class DesafioActivity extends DefaultActivity {
    Meta metaSelecionada;
    String[] metas;
    AdapterCheckListView adapterCheckListView;
    Desafio currentDesafio;
    int tentativas;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio);
        initControls();
    }

    private void initControls() {
        metas = Banco.getIntance().getListMetasUsuario();
        Spinner cbbMeta = (Spinner) findViewById(R.id.cbbMeta);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, metas);
        cbbMeta.setAdapter(adapter);
        cbbMeta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                metaSelecionada = Banco.getIntance().getMeta(metas[i]);
                proximoDesafio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        adapterCheckListView = new AdapterCheckListView(this, R.layout.item_lista_desafio, new ArrayList<String>());
        lv = (ListView) findViewById(R.id.lvOpcoes);
        lv.setAdapter(adapterCheckListView);
    }

    private void proximoDesafio() {
        tentativas = 1;
        adapterCheckListView.setSelectedItem(-1);
        TextView lblMateria = (TextView) findViewById(R.id.lblMateria);
        TextView lblDescricao = (TextView) findViewById(R.id.lblDescricaoMeta);
        TextView lblDificuldade = (TextView) findViewById(R.id.lblDificuldade);
        currentDesafio = Banco.getIntance().getRandomDesafio(metaSelecionada, currentDesafio);
        if (currentDesafio == null) {
            alert("Nenhum desafio compatível com a meta selecionada foi encontrado, selecione outra meta.");
            lblMateria.setText(getString(R.string.desafio_lbl_materia));
            lblDescricao.setText("");
            lblDificuldade.setText(getString(R.string.desafio_lbl_dificuldade));
            adapterCheckListView.clear();
            adapterCheckListView.notifyDataSetChanged();
            Util.setListViewHeightBasedOnChildren(lv);
            return;
        }
        lblMateria.setText(getString(R.string.desafio_lbl_materia) + " " + currentDesafio.getMateria().getNome());
        lblDescricao.setText(currentDesafio.getDescricao());
        lblDificuldade.setText(getString(R.string.desafio_lbl_dificuldade) + " " + currentDesafio.getDificuldade().toString());
        adapterCheckListView.clear();
        adapterCheckListView.addAll(currentDesafio.getAlternativas());
        adapterCheckListView.notifyDataSetChanged();
        Util.setListViewHeightBasedOnChildren(lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_painel_filho, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemMenuMinhasMetas: {
                Intent telaMetas = new Intent(this, PainelFilhoActivity.class);
                startActivity(telaMetas);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBtnEnviarClick(View view) {
        if (currentDesafio == null) {
            alert("Nenhum desafio foi selecionado");
            return;
        }

        if (adapterCheckListView.getSelectedItem() == -1) {
            alert("Selecione uma alternativa");
            return;
        }

        if (adapterCheckListView.getSelectedItem() == currentDesafio.getAlternativaCorreta()
                || tentativas == (currentDesafio.getAlternativas().size() - 1)) {
            HistoricoUsuario hu = new HistoricoUsuario();
            hu.setDesafio(currentDesafio);
            hu.setPessoa(Banco.getIntance().getUsuarioAutenticado());
            hu.setPontosAdquiridos(currentDesafio.getPontos() - (5 * (tentativas - 1)));// a cada tentativa errada, perde 5 pontos
            hu.setTentativas(tentativas);
            Banco.getIntance().cadastrarHistorico(hu);
            if (adapterCheckListView.getSelectedItem() == currentDesafio.getAlternativaCorreta())
                alert("Parabéns, resposta correta.");
            else alert("Não foi dessa vez, limite de tentativas atingido.");
            proximoDesafio();
        } else {
            tentativas++;
            alert("Resposta errada, tente novamente.");
        }
    }
}
