package com.sharvari.roomdemo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sharvari.roomdemo.database.dao.CartDao;
import com.sharvari.roomdemo.database.dao.MenuDao;
import com.sharvari.roomdemo.database.model.Cart;
import com.sharvari.roomdemo.database.model.Menu;

@Database(entities = {Menu.class, Cart.class}, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase db;
    public abstract MenuDao menuDao();
    public abstract CartDao cartDao();

    public static MyDatabase getDatabase(Context context){
        if(db == null){
            db = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "dbRoom")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }

}
