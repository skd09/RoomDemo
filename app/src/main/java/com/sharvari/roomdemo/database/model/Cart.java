package com.sharvari.roomdemo.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tblCart")
public class Cart {

    @PrimaryKey(autoGenerate = true)
    public int CartId;
    @ForeignKey(entity = Menu.class, parentColumns = "Id", childColumns = "ItemId", onDelete = ForeignKey.CASCADE)
    public int ItemId;
    @Embedded
    public Menu Item;
    public int Quantity;
    public int TotalPrice;

}
