package com.bignerdranch.android.nerdlauncher2;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eliballislife11 on 6/7/17.
 */

//public abstract class SingleFragmentActivity extends FragmentActivity {
public abstract class SingleFragmentActivity extends AppCompatActivity {    // For the use of a toolbar
    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId() {        // Making SingleFragmentActivity flexible
        return R.layout.activity_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
