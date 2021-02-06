package com.sharvari.roomdemo.repository;

import android.app.Application;

import com.sharvari.roomdemo.database.MyDatabase;
import com.sharvari.roomdemo.database.dao.MenuDao;
import com.sharvari.roomdemo.database.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    private MyDatabase db;
    private MenuDao menuDao;

    public MenuRepository(Application application){
        db = MyDatabase.getDatabase(application);
        menuDao = db.menuDao();
    }

    public void insertMenu(ArrayList<Menu> items){
        menuDao.insertMenuList(items);
    }

    public List<Menu> getItems(){
        return menuDao.getList();
    }

    public Menu getMenuItem(int id){ return menuDao.getMenuItem(id);};

}
