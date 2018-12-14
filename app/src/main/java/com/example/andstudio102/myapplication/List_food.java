package com.example.andstudio102.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.andstudio102.myapplication.Interface.ItemClickListener;
import com.example.andstudio102.myapplication.Model.Category;
import com.example.andstudio102.myapplication.Model.Food;
import com.example.andstudio102.myapplication.ViewHolder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class List_food extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodlist;

    String categoryID="";
    FirebaseRecyclerAdapter<Food,FoodViewHolder> food_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);

        //Firebase
        database=FirebaseDatabase.getInstance();
        foodlist=database.getReference("Foods/");

        recyclerView=(RecyclerView)findViewById(R.id.food_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //get Intent here
        if (getIntent()!=null)
            categoryID=getIntent().getStringExtra("CategoryID");
        if (!categoryID.isEmpty()&& categoryID!=null){

            loadListFood(categoryID);
        }
    }

    private void loadListFood(String categoryID) {
        food_adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,
                R.layout.item_food,
                FoodViewHolder.class,
                foodlist.orderByChild("MenuId").equalTo(categoryID) //like: Select* from Foods where MenuId=



        ) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {

                viewHolder.name_food.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.img_food);

                final Food local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        /*Toast.makeText(List_food.this, ""+local.getName(), Toast.LENGTH_SHORT).show();*/

                        //starting new activity selected food information

                        Intent foodDescription = new Intent(List_food.this, Food_details.class);
                        foodDescription.putExtra("FoodId",food_adapter.getRef(position).getKey());
                        startActivity(foodDescription);

                    }
                });

            }
        };

                recyclerView.setAdapter(food_adapter);
    }
}
