package com.intern.chefguru.views.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.RecipeModel;
import com.intern.chefguru.views.adapter.dinner.DinnerAllAdapter;

import java.util.ArrayList;

public class DinnerActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView dinnerallrecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        dinnerallrecycler = findViewById(R.id.dinnerall_recycler);

        dinnerallrecycler();
    }

    @SuppressLint("WrongConstant")
    private void dinnerallrecycler() {

        dinnerallrecycler.setHasFixedSize(true);
        dinnerallrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<RecipeModel> DinnerAll = new ArrayList<>();

        DinnerAll.add(new RecipeModel(R.drawable.cherryvanilla, "Cherry Vanilla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.chocochip, "Choco Chips", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.creamypineapple, "Creamy Pineapple", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.roastedapricotalmond, "Roasted apricot-almond", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.tangerinehoney, "Tangerine-Honey", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));

        DinnerAll.add(new RecipeModel(R.drawable.manchurian, "Cabbage Manchurin", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.vegfrankie, "Veg Frankie", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DinnerAll.add(new RecipeModel(R.drawable.mexicanhotdogwithpineapplesalsa, "Mexican HotDog with Pineapple Salsa", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new DinnerAllAdapter(DinnerAll);
        dinnerallrecycler.setAdapter(adapter);
    }
}


