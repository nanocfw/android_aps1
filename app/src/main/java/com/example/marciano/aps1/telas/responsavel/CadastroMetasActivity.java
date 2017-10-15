package com.example.marciano.aps1.telas.responsavel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.adapters.AdapterListaFilho;
import com.example.marciano.aps1.adapters.Filho;
import com.example.marciano.aps1.entidade.Meta;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.entidade.enumerado.Dificuldade;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.util.Banco;
import com.example.marciano.aps1.util.Util;

import java.util.ArrayList;

public class CadastroMetasActivity extends DefaultActivity {

    private Meta meta;
    private String[] materias;
    private ArrayList<Filho> lstFilhos;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_metas);
        materias = Banco.getIntance().getListMaterias();
        initControls();
    }

    public void initControls() {
        AutoCompleteTextView cbbMateria = (AutoCompleteTextView) findViewById(R.id.cbbMateria);
        ArrayAdapter<String> adapterMateria = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, materias);
        cbbMateria.setThreshold(1);
        cbbMateria.setAdapter(adapterMateria);

        Spinner cbbDificuldade = (Spinner) findViewById(R.id.cbbDificuldade);
        ArrayAdapter<String> adapterDificuldade = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Dificuldade.getAll());
        cbbDificuldade.setAdapter(adapterDificuldade);

        SeekBar sbMaxErros = (SeekBar) findViewById(R.id.sbPercentualErros);
        sbMaxErros.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView lbPercErros = (TextView) findViewById(R.id.lblPercErros);
                lbPercErros.setText(getString(R.string.cadastro_metas_lb_perc_erros) + seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        lstFilhos = new ArrayList<>();
        for (Pessoa p : Banco.getIntance().getUsuarioAutenticado().getFilhos())
            lstFilhos.add(new Filho(p));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            meta = (Meta) bundle.getSerializable("meta");

        if (meta != null) {
            EditText edtDescricaoMeta = (EditText) findViewById(R.id.edtDescricaoMeta);
            EditText edtPontosMeta = (EditText) findViewById(R.id.edtPontosMeta);
            SeekBar sbPercentualErros = (SeekBar) findViewById(R.id.sbPercentualErros);
            EditText edtDescricaoRecompensa = (EditText) findViewById(R.id.edtDescricaoRecompensa);

            edtDescricaoMeta.setText(meta.getDescricao());
            cbbMateria.setText(meta.getMateria().getNome());
            edtPontosMeta.setText(String.valueOf(meta.getPontosMeta()));
            cbbDificuldade.setSelection(meta.getDificuldade().ordinal());
            sbPercentualErros.setProgress(meta.getPercErros());
            edtDescricaoRecompensa.setText(meta.getRecompensa());

            for (Pessoa p : meta.getFilhos()) {
                for (Filho f : lstFilhos)
                    if (f.getFilho().getId() == p.getId())
                        f.setSelecionado(true);
            }
        }

        lv = (ListView) findViewById(R.id.lstFilhos);
        AdapterListaFilho adapterListaFilho = new AdapterListaFilho(this, R.layout.lv_lista_filhos, lstFilhos);
        lv.setAdapter(adapterListaFilho);
        Util.setListViewHeightBasedOnChildren(lv);
    }

    public void onBtnCadastrarClick(View view) {
        EditText edtDescricaoMeta = (EditText) findViewById(R.id.edtDescricaoMeta);
        AutoCompleteTextView cbbMateria = (AutoCompleteTextView) findViewById(R.id.cbbMateria);
        EditText edtPontosMeta = (EditText) findViewById(R.id.edtPontosMeta);
        Spinner cbbDificuldade = (Spinner) findViewById(R.id.cbbDificuldade);
        SeekBar sbPercentualErros = (SeekBar) findViewById(R.id.sbPercentualErros);
        EditText edtDescricaoRecompensa = (EditText) findViewById(R.id.edtDescricaoRecompensa);

        if (edtDescricaoMeta.getText().toString().isEmpty()) {
            edtDescricaoMeta.requestFocus();
            alert("Descrição inválida");
            return;
        }

        if (Util.indexOf(cbbMateria.getText().toString(), materias) == -1) {
            cbbMateria.requestFocus();
            alert("Matéria inválida");
            return;
        }

        if (edtPontosMeta.getText().toString().isEmpty() || Long.parseLong(edtPontosMeta.getText().toString()) <= 0) {
            edtPontosMeta.requestFocus();
            alert("Pontuação deve ser preenchida");
            return;
        }

        if (cbbDificuldade.getSelectedItemPosition() == -1) {
            cbbDificuldade.requestFocus();
            alert("Dificuldade deve ser selecionada");
            return;
        }

        if (edtDescricaoRecompensa.getText().toString().isEmpty()) {
            edtDescricaoRecompensa.requestFocus();
            alert("Digite a descrição da recompensa");
            return;
        }
        boolean selecionouFilhos = false;
        for (Filho f : lstFilhos)
            selecionouFilhos = selecionouFilhos || f.isSelecionado();

        if (!selecionouFilhos) {
            lv.requestFocus();
            alert("Selecione os filhos que participarão da meta");
            return;
        }

        if (meta == null) {
            meta = new Meta();
            meta.setResponsavel(Banco.getIntance().getUsuarioAutenticado());
        }

        meta.setDescricao(edtDescricaoMeta.getText().toString());
        meta.setMateria(Banco.getIntance().getMateria(cbbMateria.getText().toString()));
        meta.setPontosMeta(Integer.parseInt(edtPontosMeta.getText().toString()));
        meta.setDificuldade(Dificuldade.values()[cbbDificuldade.getSelectedItemPosition()]);
        meta.setPercErros(sbPercentualErros.getProgress());
        meta.setRecompensa(edtDescricaoRecompensa.getText().toString());
        meta.getFilhos().clear();

        for (Filho f : lstFilhos)
            if (f.isSelecionado())
                meta.getFilhos().add(f.getFilho());

        Banco.getIntance().cadastrarMeta(meta);
        this.finish();
    }
}
