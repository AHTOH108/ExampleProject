package com.novsu.antonivanov.exampleproject.CustomBehavior;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.novsu.antonivanov.exampleproject.R;

public class CustomBehaviorActivity extends AppCompatActivity {

    private Toolbar mToolbar;

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

    public void setupToolbar(Toolbar toolbar) {
        mToolbar = toolbar;

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           // final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
           // upArrow.setColorFilter(ContextCompat.getColor(this, R.color.color_black), PorterDuff.Mode.SRC_ATOP);
           // getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
    }
}
