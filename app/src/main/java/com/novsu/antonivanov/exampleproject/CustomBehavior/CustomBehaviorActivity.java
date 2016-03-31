package com.novsu.antonivanov.exampleproject.CustomBehavior;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.novsu.antonivanov.exampleproject.R;

public class CustomBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior);
        replaceContentFragment();
    }

    protected void replaceContentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragmentCurrent = fragmentManager.findFragmentById(R.id.content_frame);

        CustomBehaviorFragment newFragment = CustomBehaviorFragment.newInstance("CustomBehaviorFragment");

        if ((fragmentCurrent == null) || (!fragmentCurrent.getClass().equals(newFragment.getClass()))) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, newFragment, newFragment.getClass().getCanonicalName()).commit();
        }

    }
}
