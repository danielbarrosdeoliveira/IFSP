//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Daniel Barros de Oliveira
//******************************************************

package com.daniel.cadastrodecpf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

public class Cadastro extends AppCompatActivity {

    private DBHelper dh;

    // Declaração de Variaveis
    EditText etNome, etCPF, etIdade, etTelefone, etEmail;
    ImageButton btAdicionar, btVoltar;
    Button btListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Atribuindo as variaveis aos respectivos objetos.
        this.dh = new DBHelper(this);
        etNome = (EditText) findViewById(R.id.etNome);
        etCPF = (EditText) findViewById(R.id.etCPF);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btAdicionar = (ImageButton) findViewById(R.id.btAdicionar);
        btVoltar = (ImageButton) findViewById(R.id.btVoltar);
        btListar = (Button) findViewById(R.id.btListar);

        // Ação para o botão adicionar
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNome.getText().length() > 0 && etCPF.getText().length() > 0 && etIdade.getText().length() > 0 && etTelefone.getText().length() > 0 && etEmail.getText().length() > 0) {
                    dh.insert(etNome.getText().toString(), etCPF.getText().toString(), etIdade.getText().toString(), etTelefone.getText().toString(), etEmail.getText().toString());

                    // Exibe mensagem para o usuário, confirmando a inserção dos dados
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(Cadastro.this);
                    mensagem.setTitle("Sucesso!");
                    mensagem.setMessage("Cadastro Realizado!");
                    mensagem.show();

                    //Limpando os campos digitados
                    etNome.setText("");
                    etCPF.setText("");
                    etIdade.setText("");
                    etTelefone.setText("");
                    etEmail.setText("");
                } else {
                    // Exibe mensagem para o usuário, informando que todos os campos devem ser preenchidos
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(Cadastro.this);
                    mensagem.setTitle("ERRO!");
                    mensagem.setMessage("Todos os campos devem ser preenchidos!");
                    mensagem.show();
                }

            }
        });

        // Ações do botão listar
        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<DadosCPF> dados = dh.queryGetAll();

                if (dados == null) {
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(Cadastro.this);
                    mensagem.setTitle("ATENÇÃO!");
                    mensagem.setMessage("Não há registros cadastrados!");
                    mensagem.show();
                    return;
                }
                for (int i = 0; i < dados.size(); i++) {
                    DadosCPF dadoCPF = (DadosCPF) dados.get(i);
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(Cadastro.this);
                    mensagem.setTitle("Resgistro " + i);
                    mensagem.setMessage("Nome: " + dadoCPF.getNome() + "\nCPF: " + dadoCPF.getCpf() + "\nIdade: " + dadoCPF.getIdade() + "\nTelefone: " + dadoCPF.getTelefone() + "E-mail: " + dadoCPF.getEmail());
                    mensagem.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    mensagem.show();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Cadastro.this, Inicio.class);
                startActivity(intent);
                finish();
            }
        });
    }
}