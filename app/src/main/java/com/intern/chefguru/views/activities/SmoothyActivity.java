package com.intern.chefguru.views.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.model.RecipeModel;
import com.intern.chefguru.views.adapter.smoothy.SmoothyAllAdapter;

import java.util.ArrayList;

public class SmoothyActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView smoothyallrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoothy);

        smoothyallrecycler = findViewById(R.id.smoothyall_recycler);

        smoothyallrecycler();
    }

    @SuppressLint("WrongConstant")
    private void smoothyallrecycler() {

        smoothyallrecycler.setHasFixedSize(true);
        smoothyallrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<RecipeModel> SmoothyAll = new ArrayList<>();

        SmoothyAll.add(new RecipeModel(R.drawable.cherryvanilla, "Cherry Vanilla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        SmoothyAll.add(new RecipeModel(R.drawable.chocochip, "Choco Chips", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        SmoothyAll.add(new RecipeModel(R.drawable.creamypineapple, "Creamy Pineapple", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        SmoothyAll.add(new RecipeModel(R.drawable.roastedapricotalmond, "Roasted apricot-almond", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        SmoothyAll.add(new RecipeModel(R.drawable.tangerinehoney, "Tangerine-Honey", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new SmoothyAllAdapter(SmoothyAll);
        smoothyallrecycler.setAdapter(adapter);
    }

}
