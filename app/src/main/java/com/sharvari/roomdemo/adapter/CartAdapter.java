package com.sharvari.roomdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sharvari.roomdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{
    private Context context;

    public CartAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,  price, qty;
        private ImageView img;
        private RelativeLayout layout;
        private ImageButton add, remove;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            price = itemView.findViewById(R.id.tvPrice);
            img = itemView.findViewById(R.id.ivMenuItem);
            qty = itemView.findViewById(R.id.tvQty);
            layout = itemView.findViewById(R.id.layout);
            add = itemView.findViewById(R.id.btnAdd);
            remove = itemView.findViewById(R.id.btnRemove);
        }
    }
}
