package com.example.pizzamais;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bebida {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "descricao")
    private String descricao;
    @ColumnInfo(name = "tamanho")
    private String tamanho;
    @ColumnInfo(name = "preco")
    private float preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
