package com.kai.currencypal.modules.home.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kai.currencypal.R;
import com.kai.currencypal.modules.home.models.Rate;

import java.util.List;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/25/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class CurrencyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Rate> mList;
    private double mNumber;

    public CurrencyRecyclerAdapter(Context context, List<Rate> currencyList, double number) {
        mContext = context;
        mList = currencyList;
        mNumber = number;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency_recycler, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder viewHolder = (ItemViewHolder) holder;

        viewHolder.tvTitle.setText(mList.get(position).currency);
        viewHolder.tvValue.setText(Double.toString(mList.get(position).rate * mNumber));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvValue;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.item_currency_title);
            this.tvValue = (TextView) itemView.findViewById(R.id.item_currency_value);
        }
    }
}
