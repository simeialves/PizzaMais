package com.example.pizzamais;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public abstract class BebidaDAO {
    @Insert
    public abstract long insereBebida(Bebida b);
}
