package com.intern.chefguru.views.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.CategoryModel;
import com.intern.chefguru.model.RecipeModel;
import com.intern.chefguru.viewmodel.CategoryViewModel;
import com.intern.chefguru.views.activities.BreakFastActivity;
import com.intern.chefguru.views.activities.DietFoodActivity;
import com.intern.chefguru.views.activities.DinnerActivity;
import com.intern.chefguru.views.activities.KidsActivity;
import com.intern.chefguru.views.activities.LunchActivity;
import com.intern.chefguru.views.activities.SalaadActivity;
import com.intern.chefguru.views.activities.SmoothyActivity;
import com.intern.chefguru.views.adapter.break_fast.BreakFastAdapter;
import com.intern.chefguru.views.adapter.diet_food.DietFoodAdapter;
import com.intern.chefguru.views.adapter.dinner.DinnerAdapter;
import com.intern.chefguru.views.adapter.featured_chef.FeaturedChefAdapter;
import com.intern.chefguru.views.adapter.kids.KidsAdapter;
import com.intern.chefguru.views.adapter.lunch.LunchAdapter;
import com.intern.chefguru.views.adapter.salaad.SalaadAdapter;
import com.intern.chefguru.views.adapter.smoothy.SmoothyAdapter;
import com.intern.chefguru.views.fragments.base.BaseFragment;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    RecyclerView featuredRecycler, dietfoodRecycler, breakfastRecycler, lunchRecycler, dinnerRecycler, smoothyRecycler, kidsRecycler, salaadRecycler;
    RecyclerView.Adapter adapter;
    TextView view1, view2, view3, view4, view5, view6, view7;
    private CategoryViewModel _vmCategory;
    private View mView;
//    private RecyclerViewItemClickListener mListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mView = view;
        _vmCategory = new ViewModelProvider(mMainActivity).get(CategoryViewModel.class);

        view1 = view.findViewById(R.id.viewall);
        view2 = view.findViewById(R.id.viewall2);
        view3 = view.findViewById(R.id.viewall3);
        view4 = view.findViewById(R.id.viewall4);
        view5 = view.findViewById(R.id.viewall5);
        view6 = view.findViewById(R.id.viewall6);
        view7 = view.findViewById(R.id.viewall7);


        view1.setOnClickListener(this);
        view2.setOnClickListener(this);
        view3.setOnClickListener(this);
        view4.setOnClickListener(this);
        view5.setOnClickListener(this);
        view6.setOnClickListener(this);
        view7.setOnClickListener(this);

        featuredRecycler = view.findViewById(R.id.fetured_recylerview);
        dietfoodRecycler = view.findViewById(R.id.dietfood_recycler);
        breakfastRecycler = view.findViewById(R.id.breakfast_recycler);
        lunchRecycler = view.findViewById(R.id.lunch_recycler);
        dinnerRecycler = view.findViewById(R.id.dinner_recycler);
        smoothyRecycler = view.findViewById(R.id.smoothy_recycler);
        kidsRecycler = view.findViewById(R.id.kids_recycler);
        salaadRecycler = view.findViewById(R.id.salaad_recycler);

        featuredRecycler();

        featuredDietFood();

        breakfastRecycler();

        lunchRecycler();

        dinnerRecycler();

        smoothyRecycler();

        kidsRecycler();

        salaadRecycler();
    }

    private void smoothyRecycler() {

        smoothyRecycler.setHasFixedSize(true);
        smoothyRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            smoothy adapter

        ArrayList<RecipeModel> Smoothy = new ArrayList<>();

        Smoothy.add(new RecipeModel(R.drawable.cherryvanilla, "Cherry Vanilla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Smoothy.add(new RecipeModel(R.drawable.chocochip, "Choco Chips", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Smoothy.add(new RecipeModel(R.drawable.creamypineapple, "Creamy Pineapple", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Smoothy.add(new RecipeModel(R.drawable.roastedapricotalmond, "Roasted apricot-almond", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Smoothy.add(new RecipeModel(R.drawable.tangerinehoney, "Tangerine-Honey", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new SmoothyAdapter(Smoothy, new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        smoothyRecycler.setAdapter(adapter);
    }

    private void kidsRecycler() {

        kidsRecycler.setHasFixedSize(true);
        kidsRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            kids adapter

        ArrayList<RecipeModel> Kidsfood = new ArrayList<>();

        Kidsfood.add(new RecipeModel(R.drawable.manchurian, "Cabbage Manchurin", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Kidsfood.add(new RecipeModel(R.drawable.vegfrankie, "Veg Frankie", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Kidsfood.add(new RecipeModel(R.drawable.mexicanhotdogwithpineapplesalsa, "Mexican HotDog with Pineapple Salsa", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Kidsfood.add(new RecipeModel(R.drawable.pearberrytarts, "Pear-Berry Tarts", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Kidsfood.add(new RecipeModel(R.drawable.skillet_nachos, "Skillet-Nachos", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new KidsAdapter(Kidsfood,new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        kidsRecycler.setAdapter(adapter);

    }

    private void salaadRecycler() {

        salaadRecycler.setHasFixedSize(true);
        salaadRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            salaad adapter

        ArrayList<RecipeModel> Salaad = new ArrayList<>();

        Salaad.add(new RecipeModel(R.drawable.greeksaladwithlemondressing, "Geek with Lemon Dressing", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Salaad.add(new RecipeModel(R.drawable.grilledcornandtomato, "Grilled Corn-tomato", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Salaad.add(new RecipeModel(R.drawable.isrealisalad, "Isreali Salad", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Salaad.add(new RecipeModel(R.drawable.mixedsproutscornchaat, "Mixed Sprout Corn Chaat", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new SalaadAdapter(Salaad, new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        salaadRecycler.setAdapter(adapter);

    }

    private void dinnerRecycler() {

        dinnerRecycler.setHasFixedSize(true);
        dinnerRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            dinner adapter

        ArrayList<RecipeModel> Dinner = new ArrayList<>();

        Dinner.add(new RecipeModel(R.drawable.paneerbuttermasala, "Paneer Butter Masala", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Dinner.add(new RecipeModel(R.drawable.fullgujaratithali, "Full Gujarati", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Dinner.add(new RecipeModel(R.drawable.pavbhaji, "Pav-Bhaji", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Dinner.add(new RecipeModel(R.drawable.rotlo, "kathiyavadi Rotlo", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Dinner.add(new RecipeModel(R.drawable.mixbhajiya, "Mix Bhajiyaas", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new DinnerAdapter(Dinner, new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        dinnerRecycler.setAdapter(adapter);

    }

    private void lunchRecycler() {

        lunchRecycler.setHasFixedSize(true);
        lunchRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            lunch adapter

        ArrayList<RecipeModel> Lunch = new ArrayList<>();

        Lunch.add(new RecipeModel(R.drawable.aloopuri, "Aloo Puri", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Lunch.add(new RecipeModel(R.drawable.vegbiryani, "Veg Biryani", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Lunch.add(new RecipeModel(R.drawable.vegkathiroll, "Veg Kathiroll", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Lunch.add(new RecipeModel(R.drawable.aloopalak, "Aloo Palak", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        Lunch.add(new RecipeModel(R.drawable.vegtehri, "Veg Tehri", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new LunchAdapter(Lunch,new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        lunchRecycler.setAdapter(adapter);
    }

    private void breakfastRecycler() {

        breakfastRecycler.setHasFixedSize(true);
        breakfastRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        //            BreakFast adapter

        ArrayList<RecipeModel> BreakFast = new ArrayList<>();

        BreakFast.add(new RecipeModel(R.drawable.ravachilla, "Rava Chilla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        BreakFast.add(new RecipeModel(R.drawable.meduvada, "Medu Vada", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        BreakFast.add(new RecipeModel(R.drawable.methithepla, "Methi Thepla", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        BreakFast.add(new RecipeModel(R.drawable.oats_upma, "Oats Upma", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        BreakFast.add(new RecipeModel(R.drawable.pancakes, "Eagless Pancakes", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));


        adapter = new BreakFastAdapter(BreakFast,new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });

        breakfastRecycler.setAdapter(adapter);
    }

    private void featuredDietFood() {

        dietfoodRecycler.setHasFixedSize(true);
        dietfoodRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<RecipeModel> recipeModels = new ArrayList<>();

        recipeModels.add(new RecipeModel(R.drawable.chickpeacurry, "Chickpea & Tomato Curry", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        recipeModels.add(new RecipeModel(R.drawable.creamy_asparagus, "Creamy Asparagus", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        recipeModels.add(new RecipeModel(R.drawable.tex_mex, "Tex-Mex", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        recipeModels.add(new RecipeModel(R.drawable.soyabean, "Thai Soyabean", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));
        recipeModels.add(new RecipeModel(R.drawable.spaghetti, "Spaghetti Squash Lasagna with Broccolini", 3.5f, "When he was young, he was inspired by the local kebab vendors in Lucknow."));

        adapter = new DietFoodAdapter(recipeModels, new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(Object item) {
                RecipeModel recipeModel = (RecipeModel) item;
                _vmCategory.setCategoryModel(new CategoryModel(recipeModel.getTitle(), recipeModel.getImage()));
                Navigation.findNavController(mView).navigate(R.id.action_home_to_recipeDetail);
            }
        });
        dietfoodRecycler.setAdapter(adapter);
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(mMainActivity, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<RecipeModel> FeaturedChef = new ArrayList<>();

        FeaturedChef.add(new RecipeModel(R.drawable.vk2, "Vikash Khanna", 5.0f, "Vikas Khanna is an Indian Michelin star Chef, restaurateur, cookbook writer. He is one of the judges of Star Plus series MasterChef India."));
        FeaturedChef.add(new RecipeModel(R.drawable.sk, "Sanjeev Kapoor", 4.5f, "He is an Indian celebrity chef, entrepreneur and television personality. Kapoor stars in the TV show Khana Khazana, which is the longest running show of its kind in Asia"));
        FeaturedChef.add(new RecipeModel(R.drawable.skfemale, "Shipra Khanna", 3.5f, "She won MasterChef India in 2012, has written several cookbooks, hosts numerous cookery programmes."));
        FeaturedChef.add(new RecipeModel(R.drawable.ranveer_barar, "Ranveer Brar", 5.0f, "When he was young, he was inspired by the local kebab vendors in Lucknow. Later, he went to pursue his dream of acquiring Michelin Stars."));
        FeaturedChef.add(new RecipeModel(R.drawable.nita_mehta, "Nita Mehta", 4.0f, "She is an Indian celebrity chef, author, restaurateur and media personality, known for her cookbooks, cooking classes and judge."));


        adapter = new FeaturedChefAdapter(FeaturedChef);
        featuredRecycler.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.viewall:
                intent = new Intent(mMainActivity, DietFoodActivity.class);
                startActivity(intent);
                /*_vmCategory.setCategoryModel(new CategoryModel("Featured Diet Food", ""));
                Navigation.findNavController(view).navigate(R.id.action_home_to_recipeDetail);*/
                break;

            case R.id.viewall2:
                intent = new Intent(mMainActivity, BreakFastActivity.class);
                startActivity(intent);
                break;

            case R.id.viewall3:
                intent = new Intent(mMainActivity, LunchActivity.class);
                startActivity(intent);
                break;

            case R.id.viewall4:
                intent = new Intent(mMainActivity, DinnerActivity.class);
                startActivity(intent);
                break;

            case R.id.viewall5:
                intent = new Intent(mMainActivity, SmoothyActivity.class);
                startActivity(intent);
                break;

            case R.id.viewall6:
                intent = new Intent(mMainActivity, KidsActivity.class);
                startActivity(intent);
                break;

            case R.id.viewall7:
                intent = new Intent(mMainActivity, SalaadActivity.class);
                startActivity(intent);
                break;
        }
    }
}