package com.example.marciano.aps1.telas.geral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marciano.aps1.R;
import com.example.marciano.aps1.entidade.Pessoa;
import com.example.marciano.aps1.telas.filho.PrincipalActivity;
import com.example.marciano.aps1.telas.responsavel.MenuOpcoesActivity;
import com.example.marciano.aps1.util.Banco;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onBtnCadastrarClick(View view) {
        Intent telaCadastro = new Intent(this, CadastroActivity.class);
        startActivity(telaCadastro);
    }

    public void onBtnLoginClick(View view) {
        EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

        if (edtEmail.getText().toString().isEmpty()) {
            edtEmail.requestFocus();
            Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (edtSenha.getText().toString().isEmpty()) {
            edtSenha.requestFocus();
            Toast.makeText(this, "Senha inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        Pessoa pessoa = Banco.getIntance().getPessoa(edtEmail.getText().toString(), edtSenha.getText().toString());
        if (pessoa == null) {
            edtEmail.requestFocus();
            Toast.makeText(this, "Email e/ou senha inválidos", Toast.LENGTH_SHORT).show();
            return;
        }
        Banco.getIntance().setUsuarioAutenticado(pessoa);
        switch (pessoa.getTipoPessoa()) {
            case FILHO: {
                Intent telaPrincipal = new Intent(this, PrincipalActivity.class);
                startActivity(telaPrincipal);
                break;
            }
            case RESPONSAVEL: {
                Intent menuOpcoes = new Intent(this, MenuOpcoesActivity.class);
                startActivity(menuOpcoes);
                break;
            }
        }
        this.finish();
    }
}
