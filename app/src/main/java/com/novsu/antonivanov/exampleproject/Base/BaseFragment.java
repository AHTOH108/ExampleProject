package com.novsu.antonivanov.exampleproject.Base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Date creation: 31.03.2016.
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Здесь в дочернем классе передаётся Id Layout
     */
    protected abstract int getLayoutId();
    /**
     * Здесь проходит вся инициализация в дочерних классах
     */
    protected abstract void onCreateView(View view);
    /**
     * Здесь проходит сохранение данных (при повороте окна данные сохранить!!!)
     */
    protected abstract Bundle onSaveInstanceStateData(Bundle outState);
    /**
     * Здесь проходит первая загрузка данных для окна после его создания (при повороте окна данные загружать из savedInstanceState!!!)
     */
    protected abstract void onLoadInstanceState(Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (getLayoutId() > 0) {
            view = inflater.inflate(getLayoutId(), container, false);
        } else {
            view = super.onCreateView(inflater, container, savedInstanceState);
        }
        onCreateView(view);
        onLoadInstanceState(savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(onSaveInstanceStateData(outState));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    protected void showSnackBarMessage(String textMessage) {
        if (getActivity() == null) return;
        if (getView() == null)return;
        Snackbar snackbar = Snackbar
                .make(getView(), textMessage, Snackbar.LENGTH_LONG)
                .setAction("OK", null);
        ((TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.WHITE);
        snackbar.show();
    }

    protected void showSnackBarMessage(String textMessage, View.OnClickListener onClickListener, String textButtonOk) {
        if (getActivity() == null) return;
        if (getView() == null)return;
        Snackbar snackbar = Snackbar
                .make(getView(), textMessage, Snackbar.LENGTH_LONG)
                .setAction(textButtonOk, onClickListener);
        ((TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.WHITE);
        snackbar.show();
    }
}
