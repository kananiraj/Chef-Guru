package com.intern.chefguru.views.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.horizontalview.HelperClasses.ExtendedClass.DietFoodAllAdapter;
import com.intern.chefguru.R;
import com.intern.chefguru.model.RecipeModel;

import java.util.ArrayList;

public class BreakFastActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView breakfastrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_breakfast);

        breakfastrecycler = findViewById(R.id.breakfastall_recycler);

        breakfastrecycler();
    }

    @SuppressLint("WrongConstant")
    private void breakfastrecycler() {

        breakfastrecycler.setHasFixedSize(true);
        breakfastrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<RecipeModel> DietFoodAll = new ArrayList<>();

        DietFoodAll.add(new RecipeModel(R.drawable.cherryvanilla, "Cherry Vanilla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.chocochip, "Choco Chips", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.creamypineapple, "Creamy Pineapple", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.roastedapricotalmond, "Roasted apricot-almond", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.tangerinehoney, "Tangerine-Honey", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));

        DietFoodAll.add(new RecipeModel(R.drawable.manchurian, "Cabbage Manchurin", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.vegfrankie, "Veg Frankie", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.mexicanhotdogwithpineapplesalsa, "Mexican HotDog with Pineapple Salsa", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.pearberrytarts, "Pear-Berry Tarts", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        DietFoodAll.add(new RecipeModel(R.drawable.skillet_nachos, "Skillet-Nachos", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new DietFoodAllAdapter(DietFoodAll);
        breakfastrecycler.setAdapter(adapter);
    }
}
