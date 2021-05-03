package com.intern.chefguru.views.fragments.category;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.intern.chefguru.R;
import com.intern.chefguru.utils.Constants;
import com.intern.chefguru.viewmodel.CategoryViewModel;
import com.intern.chefguru.views.fragments.base.BaseFragment;

public class CategoryFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final CategoryViewModel _vmCategory = new ViewModelProvider(mMainActivity).get(CategoryViewModel.class);

        view.findViewById(R.id.cvGujarati).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_GUJARATI);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });

        view.findViewById(R.id.cvPanjabi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_PUNJABI);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
        view.findViewById(R.id.cvChinese).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_CHINESE);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
        view.findViewById(R.id.cvSouthindia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_SOUTH_INDIAN);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
        view.findViewById(R.id.cvAmerican).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_AMERICAN);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
        view.findViewById(R.id.cvFastfood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_FAST_FOOD);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
        view.findViewById(R.id.cvMexican).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _vmCategory.setCurrentCategory(Constants.CATEGORY_MEXICAN);
                Navigation.findNavController(view).navigate(R.id.action_category_to_childCategory);
            }
        });
    }
}
