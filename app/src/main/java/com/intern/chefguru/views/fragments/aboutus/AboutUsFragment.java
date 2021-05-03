package com.intern.chefguru.views.fragments.aboutus;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intern.chefguru.R;
import com.intern.chefguru.views.fragments.base.BaseFragment;

public class AboutUsFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us_, container, false);
    }
}
