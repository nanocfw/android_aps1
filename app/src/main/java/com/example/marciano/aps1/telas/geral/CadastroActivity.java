package com.example.marciano.aps1.telas.geral;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.entidade.enumerado.TipoPessoa;
import com.example.marciano.aps1.telas.DefaultActivity;
import com.example.marciano.aps1.util.Banco;
import com.example.marciano.aps1.util.Util;

public class CadastroActivity extends DefaultActivity {
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            pessoa = (Pessoa) bundle.getSerializable("pessoa");

        if (pessoa != null) {
            EditText edtNome = (EditText) findViewById(R.id.edtNome);
            EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
            EditText edtConfirmacaoSenha = (EditText) findViewById(R.id.edtConfirmacaoSenha);
            RadioGroup rgTipo = (RadioGroup) findViewById(R.id.rgTipoPessoa);

            edtNome.setText(pessoa.getNome());
            edtEmail.setText(pessoa.getEmail());
            edtSenha.setText(pessoa.getSenha());
            edtConfirmacaoSenha.setText(pessoa.getSenha());
            switch (pessoa.getTipoPessoa()) {
                case RESPONSAVEL: {
                    rgTipo.check(R.id.rbResponsavel);
                    break;
                }
                case FILHO: {
                    rgTipo.check(R.id.rbFilho);
                    break;
                }
            }
        }
    }

    public void onBtnCadastrarClick(View view) {
        EditText edtNome = (EditText) findViewById(R.id.edtNome);
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        EditText edtConfirmacaoSenha = (EditText) findViewById(R.id.edtConfirmacaoSenha);
        RadioGroup rgTipo = (RadioGroup) findViewById(R.id.rgTipoPessoa);

        if (edtNome.getText().toString().isEmpty()) {
            edtNome.requestFocus();
            alert("Nome inválido");
            return;
        }

        if (edtEmail.getText().toString().isEmpty() || !Util.isValidEmail(edtEmail.getText().toString())) {
            edtEmail.requestFocus();
            alert("Email inválido");
            return;
        }

        if (edtSenha.getText().toString().isEmpty()) {
            edtSenha.requestFocus();
            alert("Senha inválida");
            return;
        }

        if (edtConfirmacaoSenha.getText().toString().isEmpty()) {
            edtConfirmacaoSenha.requestFocus();
            alert("Informe a confirmação da senha");
            return;
        }

        if (!edtSenha.getText().toString().equals(edtConfirmacaoSenha.getText().toString())) {
            edtSenha.requestFocus();
            alert("As senhas não são iguais");
            return;
        }

        if (rgTipo.getCheckedRadioButtonId() == -1) {
            rgTipo.requestFocus();
            alert("Selecione o tipo");
            return;
        }

        if (Banco.getIntance().isEmailInUse(edtEmail.getText().toString(), (this.pessoa == null) ? 0 : pessoa.getId())) {
            edtEmail.requestFocus();
            alert("Email já cadastrado.");
            return;
        }

        if (pessoa == null)
            pessoa = new Pessoa();
        pessoa.setNome(edtNome.getText().toString());
        pessoa.setEmail(edtEmail.getText().toString());
        pessoa.setSenha(edtSenha.getText().toString());

        switch (rgTipo.getCheckedRadioButtonId()) {
            case R.id.rbResponsavel: {
                pessoa.setTipoPessoa(TipoPessoa.RESPONSAVEL);
                break;
            }
            case R.id.rbFilho: {
                pessoa.setTipoPessoa(TipoPessoa.FILHO);
                break;
            }
        }
        Banco.getIntance().cadastrarPessoa(pessoa);
        this.finish();
    }
}
