package com.example.pizzamais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioPizza extends AppCompatActivity {

    EditText nome, ingredientes, tamanho, preco;
    Button gravarDados, recuperarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pizza);

        nome = findViewById(R.id.edtNome);
        ingredientes = findViewById(R.id.edtIngredientesPizza);
        tamanho = findViewById(R.id.edtTamanhoPizza);
        preco = findViewById(R.id.edtPrecoPizza);

        gravarDados = findViewById(R.id.btnGravarDadosPizza);
        recuperarDados = findViewById(R.id.btnRecuperarDadosPizza);

        gravarDados();
        recuperarDados();

    }

    public void gravarDados() {

        gravarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().equals("") ||
                        ingredientes.getText().equals("") ||
                        tamanho.getText().toString().equals("") ||
                        preco.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Digite todos os dados da pizza!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent pizzaForm = new Intent(getApplicationContext(), DadosPizza.class);

                    pizzaForm.putExtra("Nome", nome.getText().toString().trim());
                    pizzaForm.putExtra("Ingredientes", ingredientes.getText().toString().trim());
                    pizzaForm.putExtra("Tamanho", tamanho.getText().toString().trim());
                    pizzaForm.putExtra("Preco", preco.getText().toString().trim());

                    startActivity(pizzaForm);

                    SharedPreferences objetoShared = getSharedPreferences("TabelaDadosPizza", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editaDados = objetoShared.edit();
                    editaDados.putString("Nome", nome.getText().toString().trim());
                    editaDados.putString("Ingredientes", ingredientes.getText().toString().trim());
                    editaDados.putString("Tamanho", tamanho.getText().toString().trim());
                    editaDados.putString("Preco", preco.getText().toString().trim());

                    editaDados.apply();

                    nome.setText("");
                    ingredientes.setText("");
                    tamanho.setText("");
                    preco.setText("");
                }
            }
        });

    }

    public void recuperarDados ()
    {
        recuperarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences recuperarDados = getSharedPreferences("TabelaDadosPizza", Context.MODE_PRIVATE);

                nome.setText(recuperarDados.getString("Nome", "Nulo"));
                ingredientes.setText(recuperarDados.getString("Ingredientes", "Nulo"));
                tamanho.setText(recuperarDados.getString("Tamanho", "Nulo"));
                preco.setText(recuperarDados.getString("Preco", "Nulo"));

                Toast.makeText(getApplicationContext(), "Dados da pizza recuperados com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
}