package com.sharvari.roomdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sharvari.roomdemo.R;
import com.sharvari.roomdemo.database.model.Menu;
import com.sharvari.roomdemo.utils.Utils;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Menu> menuItems;
    private String LOG = "Room";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String menuData = Utils.getAssetJsonData(getApplicationContext());
        Type type = new TypeToken<ArrayList<Menu>>(){}.getType();
        menuItems = new Gson().fromJson(menuData, type);

        Log.i(LOG, menuItems.toString());
    }
}