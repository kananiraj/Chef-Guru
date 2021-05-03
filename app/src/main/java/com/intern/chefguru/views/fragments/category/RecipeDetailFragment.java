package com.intern.chefguru.views.fragments.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.intern.chefguru.R;
import com.intern.chefguru.viewmodel.CategoryViewModel;
import com.intern.chefguru.views.fragments.base.BaseFragment;
import com.like.LikeButton;
import com.like.OnAnimationEndListener;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetailFragment extends BaseFragment {

    private Button b_like, b_comment, b_share;
    private LikeButton heart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CategoryViewModel _vmCategory = new ViewModelProvider(mMainActivity).get(CategoryViewModel.class);

        mMainActivity.setToolbarTitle(_vmCategory.getCategoryModel().getCategoryTitle());

        b_like = view.findViewById(R.id.like);
        b_comment = view.findViewById(R.id.comment);
        b_share = view.findViewById(R.id.share);
        heart = view.findViewById(R.id.heart_button);

        ImageSlider imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://blog.dineout-cdn.co.in/blog/wp-content/uploads/2017/10/Shadab.jpg"));
        slideModels.add(new SlideModel("https://5.imimg.com/data5/OM/JG/MY-9601251/img_0374-500x500.jpg"));
        slideModels.add(new SlideModel("https://www.outlookindia.com/outlooktraveller//public/uploads/articles/explore/Keema_Biryani.jpg"));
        slideModels.add(new SlideModel("https://www.hindustantimes.com/rf/image_size_640x362/HT/p2/2016/10/06/Pictures/_e49736dc-8bc5-11e6-b25a-dc2df696e7dd.jpg"));

        imageSlider.setImageList(slideModels, true);

        heart.setOnAnimationEndListener(new OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(LikeButton likeButton) {
            }
        });

        heart.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(mMainActivity, "Liked", Toast.LENGTH_LONG).show();

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Toast.makeText(mMainActivity, "Unlike", Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.btnIngredient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new IngredientFragment();
                androidx.fragment.app.FragmentManager fm = getChildFragmentManager();
                androidx.fragment.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }
        });

        view.findViewById(R.id.btnRecipes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new RecipeFragment();
                androidx.fragment.app.FragmentManager fm = getChildFragmentManager();
                androidx.fragment.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }
        });
    }
}
