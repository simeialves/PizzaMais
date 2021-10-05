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

public class FormularioBebida extends AppCompatActivity {

    EditText descricao, tamanho, preco;
    Button gravarDados, recuperarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_bebida);

        descricao = findViewById(R.id.edtDescricaoBebida);
        tamanho = findViewById(R.id.edtTamanhoBebida);
        preco = findViewById(R.id.edtPrecoBebida);

        gravarDados = findViewById(R.id.btnGravarDadosBebida);
        recuperarDados = findViewById(R.id.btnRecuperarDadosBebida);

        gravarDados();
        recuperarDados();
    }

    public void gravarDados()
    {
        gravarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (descricao.getText().toString().equals("") ||
                        tamanho.getText().toString().equals("")||
                        preco.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Digite todos os dados da bebida!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent bebidaForm = new Intent(getApplicationContext(), DadosBebida.class);

                    bebidaForm.putExtra("Descricao", descricao.getText().toString().trim());
                    bebidaForm.putExtra("Tamanho", tamanho.getText().toString().trim());
                    bebidaForm.putExtra("Preco", preco.getText().toString().trim());

                    startActivity(bebidaForm);

                    SharedPreferences objetoShared = getSharedPreferences("TabelaDadosBebida", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editaDados = objetoShared.edit();
                    editaDados.putString("Descricao", descricao.getText().toString().trim());
                    editaDados.putString("Tamanho", tamanho.getText().toString().trim());
                    editaDados.putString("Preco", preco.getText().toString().trim());

                    editaDados.apply();

                    descricao.setText("");
                    tamanho.setText("");
                    preco.setText("");
                }
            }
        });
    }

    public void recuperarDados()
    {
        recuperarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences recuperarDados = getSharedPreferences("TabelaDadosBebida", Context.MODE_PRIVATE);

                descricao.setText(recuperarDados.getString("Descricao", "Nulo"));
                tamanho.setText(recuperarDados.getString("Tamanho", "Nulo"));
                preco.setText(recuperarDados.getString("Preco", "Nulo"));

                Toast.makeText(getApplicationContext(), "Dados da bebida recuperados com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
}