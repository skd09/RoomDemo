package com.sharvari.roomdemo.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sharvari.roomdemo.database.model.Cart;

import java.util.List;

@Dao
public interface CartDao extends BaseDao<Cart>{

    @Query("SELECT * FROM tblCart")
    LiveData<List<Cart>> getCartItems();

    @Query("SELECT COUNT(*) FROM tblCart")
    int getCartSize();

    @Query("SELECT SUM(TotalPrice) FROM tblCart")
    int getCartTotalPrice();

    @Query("SELECT * FROM tblCart WHERE CartId = :id")
    Cart getCartItem(int id);

    @Insert
    @Override
    void insert(Cart cart);

    @Delete
    @Override
    void delete(Cart cart);

    @Update
    @Override
    void update(Cart cart);
}
