package com.sharvari.roomdemo.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblMenu")
public class Menu {
    @PrimaryKey
    public int Id;
    public String Title;
    public String Description;
    public String Image;
    public Float Ratings;
    public int Price;
}
