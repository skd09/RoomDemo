package com.sharvari.roomdemo.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sharvari.roomdemo.R;

public class MenuItemActivity  extends AppCompatActivity {
    private String LOG = "Room";
    private MenuItem item;
    private TextView name, desc, price, qty;
    private ImageView img;
    private RatingBar ratingBar;
    private Button btnAdd;
    private ImageButton btnRemoveCart, btnAddCart;
    private LinearLayout qtyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        int id = getIntent().getIntExtra("Item", 0);
        Log.i(LOG, "Id is "+id);

        name = findViewById(R.id.tvName);
        qty = findViewById(R.id.tvQty);
        desc = findViewById(R.id.tvDescription);
        price = findViewById(R.id.tvPrice);
        img = findViewById(R.id.img);
        ratingBar = findViewById(R.id.ratingBar);
        qtyLayout = findViewById(R.id.qtyLayout);
        btnAddCart = findViewById(R.id.btnAddCart);
        btnRemoveCart = findViewById(R.id.btnRemoveCart);
        btnAdd = findViewById(R.id.btnAdd);
    }

    private void setData(Boolean isAdded) {

    }
}
