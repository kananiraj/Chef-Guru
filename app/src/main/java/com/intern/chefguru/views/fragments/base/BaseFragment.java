package com.intern.chefguru.views.fragments.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import com.intern.chefguru.utils.SharedPreference;
import com.intern.chefguru.views.activities.MainActivity;


public class BaseFragment extends Fragment {
    public MainActivity mMainActivity;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity) this.getActivity();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public boolean onBackPressed() {
        return false;
    }

    /*public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }*/

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}

