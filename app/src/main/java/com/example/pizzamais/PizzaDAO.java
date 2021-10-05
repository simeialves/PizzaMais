package com.example.pizzamais;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public abstract class PizzaDAO {
    @Insert
    public abstract long inserePizza(Pizza p);
}
