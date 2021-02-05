package com.sharvari.roomdemo.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sharvari.roomdemo.database.model.Menu;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MenuDao extends BaseDao<Menu>{

    @Query("SELECT * FROM tblMenu ORDER BY ID asc")
    List<Menu> getList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMenuList(ArrayList<Menu> m);

    @Insert
    @Override
    void insert(Menu menu);

    @Update
    @Override
    void update(Menu menu);

    @Delete
    @Override
    void delete(Menu menu);
}
