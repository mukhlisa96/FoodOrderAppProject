package com.example.andstudio102.myapplication.ViewHolder;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andstudio102.myapplication.Interface.ItemClickListener;
import com.example.andstudio102.myapplication.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView menuName;
    public ImageView imgView;

    public ItemClickListener itemClickListener;



    public MenuViewHolder(View itemView) {
        super(itemView);

        menuName=(TextView)itemView.findViewById(R.id.name_menu);
        imgView=(ImageView)itemView.findViewById(R.id.img_menu);

        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition(),false);


    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }




}
