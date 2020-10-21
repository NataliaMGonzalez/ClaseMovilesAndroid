package com.example.roomexample.productdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)

public abstract class ProductsDatabase extends RoomDatabase {

    public abstract ProductDao getProductDao();

    // Single singleton
    private static ProductsDatabase INSTANCE;

    public static synchronized ProductsDatabase getInstance(Context context){
        if (null == INSTANCE){
            INSTANCE = buildDatabaseInstance(context);
        }
        return INSTANCE;
    }

    public static ProductsDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context,
                ProductsDatabase.class,
                Constants.DB_NAME).build();
    }
}
