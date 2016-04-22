package com.novsu.antonivanov.exampleproject.CustomBehavior;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novsu.antonivanov.exampleproject.Adapters.SimpleRVAdapter;
import com.novsu.antonivanov.exampleproject.Base.BaseFragment;
import com.novsu.antonivanov.exampleproject.R;
import com.novsu.antonivanov.exampleproject.utils.GenerateData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomBehaviorFragment extends BaseFragment {

    private static final String ARG_TAG = "arg_tag";

    public static CustomBehaviorFragment newInstance(String tag) {
        Bundle args = new Bundle();

        CustomBehaviorFragment fragment = new CustomBehaviorFragment();
        args.putString(ARG_TAG, tag);
        fragment.setArguments(args);

        return fragment;
    }

    public String getArgTag() {
        return getArguments().getParcelable(ARG_TAG);
    }

    private RecyclerView mRecyclerView;
    private TextView mShopName;
    private TextView mShopNameBeh;
    private Toolbar mToolbar;

    private SimpleRVAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_custom_behavior;
    }

    @Override
    protected void onCreateView(View view) {
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        adapter = new SimpleRVAdapter(getActivity(), GenerateData.getListObject(20));
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
        mShopName = (TextView) view.findViewById(R.id.shop_name);
        mShopName.setVisibility(View.INVISIBLE);
        mShopNameBeh = (TextView) view.findViewById(R.id.point_name_behavior);
        setTextBehavior();
        view.findViewById(R.id.button_create_report).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextBehavior();
            }
        });
    }

    @Override
    protected Bundle onSaveInstanceStateData(Bundle outState) {
        return outState;
    }

    @Override
    protected void onLoadInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (CustomBehaviorActivity.class.isInstance(getActivity())) {
            ((CustomBehaviorActivity) getActivity()).setupToolbar(mToolbar);
        }
    }

    private void setTextBehavior() {
        String str = GenerateData.getRandomStringInSpace(40);
        if (mShopName != null) {
            mShopName.setText(str);
        }
        if (mShopNameBeh != null) {
            mShopNameBeh.setText(str);
        }
    }
}
