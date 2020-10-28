package com.example.parcial2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Materias.class},version = 1)
public abstract class MateriasDatabase extends RoomDatabase {

    public abstract MateriasDao getProductDao();
    private static MateriasDatabase INSTANCE;

    public static synchronized MateriasDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabaseInstance(context);
        }
        return INSTANCE;
    }

    public static MateriasDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                MateriasDatabase.class,
                "materias.db").allowMainThreadQueries().build();
    }
}
