package com.intern.chefguru.views.fragments.category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intern.chefguru.R;
import com.intern.chefguru.listeners.RecyclerViewItemClickListener;
import com.intern.chefguru.model.CategoryModel;
import com.intern.chefguru.utils.Constants;
import com.intern.chefguru.viewmodel.CategoryViewModel;
import com.intern.chefguru.views.adapter.category.CategoryItemRecyclerViewAdapter;
import com.intern.chefguru.views.fragments.base.BaseFragment;

import java.util.ArrayList;

public class CategoryItemFragment extends BaseFragment {

    private ArrayList<CategoryModel> categoryModels;

    public CategoryItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryModels = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final CategoryViewModel _vmCategory = new ViewModelProvider(mMainActivity).get(CategoryViewModel.class);
        final View view = inflater.inflate(R.layout.fragment_category_item_list, container, false);

        if (_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_GUJARATI)) {
            categoryModels = _vmCategory.getGujaratiLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_GUJARATI);
        } else if (_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_PUNJABI)) {
            categoryModels = _vmCategory.getPunjabiLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_PUNJABI);
        } else if (_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_CHINESE)) {
            categoryModels = _vmCategory.getChineseLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_CHINESE);
        } else if(_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_SOUTH_INDIAN)) {
            categoryModels = _vmCategory.getSouthIndianLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_SOUTH_INDIAN);
        }else if(_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_AMERICAN)) {
            categoryModels = _vmCategory.getAmericanLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_AMERICAN);
        }
        else if(_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_MEXICAN)) {
            categoryModels = _vmCategory.getMexicanLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_MEXICAN);
        }
        else if(_vmCategory.getCurrentCategory().equalsIgnoreCase(Constants.CATEGORY_FAST_FOOD)) {
            categoryModels = _vmCategory.getfastfoodLists();
            mMainActivity.setToolbarTitle(Constants.CATEGORY_FAST_FOOD);
        }


            // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            int mColumnCount = 2;
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            recyclerView.setAdapter(new CategoryItemRecyclerViewAdapter(categoryModels, new RecyclerViewItemClickListener() {
                @Override
                public void onItemClick(Object item) {
                    CategoryModel categoryModel = (CategoryModel) item;
                    _vmCategory.setCategoryModel(categoryModel);
                    Navigation.findNavController(view).navigate(R.id.action_childCategory_to_recipeDetail);
                }
            }));
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
