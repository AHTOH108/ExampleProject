package com.novsu.antonivanov.exampleproject.CustomBehavior;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private SimpleRVAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_custom_behavior;
    }

    @Override
    protected void onCreateView(View view) {
        adapter = new SimpleRVAdapter(getActivity(), GenerateData.getListObject(20));
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected Bundle onSaveInstanceStateData(Bundle outState) {
        return outState;
    }

    @Override
    protected void onLoadInstanceState(Bundle savedInstanceState) {

    }
}
