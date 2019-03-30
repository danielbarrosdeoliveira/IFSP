//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Daniel Barros de Oliveira
//******************************************************

package com.daniel.cadastrodecpf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Inicio extends AppCompatActivity {

    ImageButton btCadastrese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btCadastrese = (ImageButton) findViewById(R.id.btCadastrese);
        btCadastrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarCadastro();
            }
        });
    }

    // Método para chamar a tela do Cadastro
    void chamarCadastro(){
        Intent intent = new Intent();
        intent.setClass(Inicio.this, Cadastro.class);
        startActivity(intent);
        finish();
    }
}
