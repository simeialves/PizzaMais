package com.example.pizzamais;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Bebida.class}, version = 1)
public abstract class BancoDadosBebida extends RoomDatabase {
    public abstract BebidaDAO getDAO();

    private static BancoDadosBebida INSTANCIA_P;

    public static BancoDadosBebida getBancoDadosBebida(Context context) {
        if (INSTANCIA_P == null) {
            synchronized (BancoDadosBebida.class) {
                if (INSTANCIA_P == null) {
                    INSTANCIA_P = Room.databaseBuilder(context.getApplicationContext(),
                            BancoDadosBebida.class, "DBPizzaMaisBebida").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCIA_P;
    }
}
