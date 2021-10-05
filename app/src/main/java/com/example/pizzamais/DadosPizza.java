package com.example.pizzamais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DadosPizza extends AppCompatActivity {

    TextView nome, ingredientes, tamanho, preco;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pizza);

        nome = findViewById(R.id.txtNome);
        ingredientes = findViewById(R.id.txtIngredientes);
        tamanho = findViewById(R.id.txtTamanho);
        preco = findViewById(R.id.txtPreco);
        cadastrar = findViewById(R.id.btnCadastrarPizza);

        Intent exibirDados = getIntent();

        nome.setText(exibirDados.getStringExtra("Nome"));
        ingredientes.setText(exibirDados.getStringExtra("Ingredientes"));
        tamanho.setText(exibirDados.getStringExtra("Tamanho"));
        preco.setText(exibirDados.getStringExtra("Preco"));

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cadastrarPizza();
            }
        });
    }

    public void cadastrarPizza()
    {
        Pizza p = new Pizza();

        p.setNome(nome.getText().toString().trim());
        p.setIngredientes(ingredientes.getText().toString().trim());
        p.setTamanho(tamanho.getText().toString().trim());
        p.setPreco(Float.parseFloat(preco.getText().toString().trim()));

        BancoDados.getBancoDadosPizza(this).getDAO().inserePizza(p);

        Toast.makeText(getApplicationContext(), "Pizza cadastrada com Sucesso!", Toast.LENGTH_LONG).show();
    }
}