package com.sharvari.roomdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sharvari.roomdemo.R;
import com.sharvari.roomdemo.adapter.MenuAdapter;
import com.sharvari.roomdemo.database.model.Menu;
import com.sharvari.roomdemo.repository.MenuRepository;
import com.sharvari.roomdemo.utils.Utils;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Menu> menuItems;
    private String LOG = "Room";
    private RecyclerView recyclerview;
    private MenuAdapter adapter;
    private MenuRepository myRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        menuItems = new ArrayList<>();
        myRepo = new MenuRepository(getApplication());

        if(myRepo.getItems().size() == 0){
            String menuData = Utils.getAssetJsonData(getApplicationContext());
            Type type = new TypeToken<ArrayList<Menu>>(){}.getType();
            menuItems = new Gson().fromJson(menuData, type);
            myRepo.insertMenu(menuItems);
            Log.i(LOG, "Inserted the items.");
        }else{
            menuItems.addAll(myRepo.getItems());
            Log.i(LOG, "Loaded the items.");
        }

        Log.i(LOG, menuItems.toString());

        adapter = new MenuAdapter(menuItems, this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}