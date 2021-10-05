package com.example.pizzamais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DadosBebida extends AppCompatActivity {

    TextView descricao, tamanho, preco;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_bebida);

        descricao = findViewById(R.id.txtDescricaoBebida);
        tamanho = findViewById(R.id.txtTamanhoBebida);
        preco = findViewById(R.id.txtPrecoBebida);
        cadastrar = findViewById(R.id.btnCadastrarBebida);

        Intent exibirDados = getIntent();

        descricao.setText(exibirDados.getStringExtra("Descricao"));
        tamanho.setText(exibirDados.getStringExtra("Tamanho"));
        preco.setText(exibirDados.getStringExtra("Preco"));

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadastrarBebida();
            }
        });
    }

    public void cadastrarBebida()
    {
        Bebida b = new Bebida();

        b.setDescricao(descricao.getText().toString().trim());
        b.setTamanho(tamanho.getText().toString().trim());
        b.setPreco(Float.parseFloat(preco.getText().toString().trim()));

        BancoDadosBebida.getBancoDadosBebida(this).getDAO().insereBebida(b);

        Toast.makeText(getApplicationContext(), "Bebida cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
    }
}