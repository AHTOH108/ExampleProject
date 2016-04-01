package com.novsu.antonivanov.exampleproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novsu.antonivanov.exampleproject.R;
import com.novsu.antonivanov.exampleproject.MyObjects.BaseObject;

import java.util.ArrayList;

/**
 * Date creation: 31.03.2016.
 */
public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.ViewHolder> {

    //private static final int TYPE_ADD_CAR = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_PROGRESS_BAR = 2;

    LayoutInflater lInflater;
    private ArrayList<BaseObject> listItems = new ArrayList<>();


    public SimpleRVAdapter(Context context, ArrayList<BaseObject> listItems) {
        lInflater = LayoutInflater.from(context);
        this.listItems.addAll(listItems);
    }

    public void updateListCar(ArrayList<BaseObject> listItems) {
        this.listItems.clear();
        this.listItems.addAll(listItems);
        notifyDataSetChanged();

    }

    public void removeItemList(int position) {
        if (listItems.size() > position) {
            this.listItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                return new ViewHolder(lInflater.inflate(R.layout.item_list_simple, viewGroup, false));
            case TYPE_PROGRESS_BAR:
            default:
                return new ViewHolder(lInflater.inflate(R.layout.item_progess_bar, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int type = getItemViewType(position);

        switch (type) {

            case TYPE_ITEM:
                BaseObject item = getItem(position);
                viewHolder.textViewId.setText(String.valueOf(item.getId()));
                viewHolder.textViewName.setText(item.getName());
                break;

            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return this.listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listItems.size() > position)
            return TYPE_ITEM;
        else
            return TYPE_PROGRESS_BAR;
    }

    public BaseObject getItem(int position) {
        if (this.listItems.size() > position)
            return this.listItems.get(position);
        else
            return new BaseObject();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textViewId;
        public TextView textViewName;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textViewId = (TextView) view.findViewById(R.id.textViewId);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
        }
    }
}