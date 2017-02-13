package com.thekadesikhaana.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thekadesikhaana.R;

import java.util.List;
import java.util.StringTokenizer;

import model.MenuItems;

/**
 * Created by ashishchoudhary on 05/02/17.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {


    private static final String TAG = MenuAdapter.class.getSimpleName();
    private List<MenuItems> dataSet;
    private Context mContext;


    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView menuContent;
        ImageView menuType;
        ImageView menuImage;
        TextView menuPrice;
        Button addItemButton;
        Button removeItemButton;
        int counter = 1;
        int totalPrice = 1;

        MyViewHolder(View itemView) {
            super(itemView);
            menuContent = (TextView) itemView.findViewById(R.id.menu_content);
            menuType = (ImageView) itemView.findViewById(R.id.menu_type);
            menuImage = (ImageView) itemView.findViewById(R.id.main_image);
            menuPrice = (TextView) itemView.findViewById(R.id.tv_price);
            addItemButton = (Button) itemView.findViewById(R.id.btn_add);
            removeItemButton = (Button) itemView.findViewById(R.id.btn_remove);
        }
    }

    public MenuAdapter(Context context, List<MenuItems> data) {
        this.dataSet = data;
        mContext = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView menuContent = holder.menuContent;
        ImageView menuType = holder.menuType;
        ImageView menuImage = holder.menuImage;
        final TextView priceTextView = holder.menuPrice;
        Button addItemButton = holder.addItemButton;
        Button removeItemButton = holder.removeItemButton;

        final MenuItems menuItems = dataSet.get(listPosition);
        Picasso.with(mContext).
                load(menuItems.getUrlMobile())
                .placeholder(R.drawable.app_icon)
                .into(menuImage);

        menuContent.setText(menuItems.getItems());
        String price = getPrice(Integer.parseInt(menuItems.getPrice()), holder, true);
        priceTextView.setText(price);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = getPrice(Integer.parseInt(menuItems.getPrice()), holder, true);
                priceTextView.setText(price);
            }
        });

        removeItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = getPrice(Integer.parseInt(menuItems.getPrice()), holder, false);
                priceTextView.setText(price);
            }
        });
    }

    private String getPrice(int price, MyViewHolder holder, boolean isAdd) {

        if (isAdd) {
            holder.totalPrice = (price * (holder.counter++));
        } else {
            int counter = (--holder.counter);
            holder.totalPrice = (price * (--counter));
        }

        return holder.totalPrice + " Rs.";
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
