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
import com.sharvari.roomdemo.database.model.Cart;
import com.sharvari.roomdemo.database.model.Menu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<Cart> cartArrayList;


    public CartAdapter(Context context, ArrayList<Cart> cartArrayList) {
        this.context = context;
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Menu item = cartArrayList.get(position).Item;
        Cart cartItem = cartArrayList.get(position);
        holder.name.setText(item.Title);
        holder.price.setText("$"+cartItem.TotalPrice);
        holder.qty.setText(cartItem.Quantity+"");
        Picasso.get().load(item.Image)
                .resize(90, 90)
                .placeholder(R.drawable.placeholder)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return cartArrayList.size();
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
