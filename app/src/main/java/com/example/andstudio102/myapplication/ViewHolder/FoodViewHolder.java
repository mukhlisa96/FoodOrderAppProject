package com.example.andstudio102.myapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andstudio102.myapplication.Interface.ItemClickListener;
import com.example.andstudio102.myapplication.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name_food;
    public ImageView img_food;

    public ItemClickListener itmClickList;
    /*public ItemClickListener local;*/

    public FoodViewHolder(View itemView, ItemClickListener itmClickList) {
        super(itemView);
        this.itmClickList = itmClickList;
    }

    public FoodViewHolder(View itemView) {
        super(itemView);

        name_food=(TextView)itemView.findViewById(R.id.name_food);
        img_food=(ImageView)itemView.findViewById(R.id.img_food);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        itmClickList.onClick(v, getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
    }
}
