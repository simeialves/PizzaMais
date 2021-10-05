package com.example.pizzamais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Button cadastroPizza, cadastroBebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cadastroPizza = findViewById(R.id.btnCadastroPizzas);
        cadastroBebida = findViewById(R.id.btnCadastroBebidas);

        formularioPizza();
        formularioBebida();
    }

    public void formularioPizza()
    {
        cadastroPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pizzaForm = new Intent(getApplicationContext(), FormularioPizza.class);

                startActivity(pizzaForm);
            }
        });
    }

    public void formularioBebida()
    {
        cadastroBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent bebidaForm = new Intent(getApplicationContext(), FormularioBebida.class);

                startActivity(bebidaForm);
            }
        });
    }
}