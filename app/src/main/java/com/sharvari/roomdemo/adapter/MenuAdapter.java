package com.sharvari.roomdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sharvari.roomdemo.R;
import com.sharvari.roomdemo.database.model.Menu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private ArrayList<Menu> menuItem;
    private Context context;

    public MenuAdapter(ArrayList<Menu> menuItem, Context context){
        this.menuItem = menuItem;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.menu_item_row, parent);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, int position) {
        Menu item = menuItem.get(position);
        holder.title.setText(item.Title);
        holder.desc.setText(item.Description);
        holder.price.setText(item.Price);
        Picasso.get().load(item.Image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, desc, price;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            desc = itemView.findViewById(R.id.tvDescription);
            price = itemView.findViewById(R.id.tvPrice);
            img = itemView.findViewById(R.id.img);
        }
    }
}
