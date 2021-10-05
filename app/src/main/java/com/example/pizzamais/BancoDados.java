package com.example.pizzamais;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pizza.class}, version = 1)
public abstract class BancoDados extends RoomDatabase {
    public abstract PizzaDAO getDAO();

    private static BancoDados INSTANCIA_P;

    public static BancoDados getBancoDadosPizza(Context context) {
        if (INSTANCIA_P == null) {
            synchronized (BancoDados.class) {
                if (INSTANCIA_P == null) {
                    INSTANCIA_P = Room.databaseBuilder(context.getApplicationContext(),
                            BancoDados.class, "DBPizzaMaisPizza").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCIA_P;
    }
}
