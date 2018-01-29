package com.kai.currencypal.modules.home.views;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.kai.currencypal.R;
import com.kai.currencypal.common.base.BaseActivity;
import com.kai.currencypal.modules.home.HomePresenter;
import com.kai.currencypal.modules.home.adapters.CurrencyRecyclerAdapter;
import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.currencypal.modules.home.models.Rate;
import com.kai.service.base.Callback;
import com.kai.service.utilities.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HomeActivity
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class HomeActivity extends BaseActivity<HomePresenter> implements AdapterView.OnItemSelectedListener {

    private EditText mHomeNumber;   // TODO: 1/29/2018 Optimize soft keyboard, udpate event

    private Spinner mHomeSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;

    private RecyclerView mHomeRecyclerView;
    private CurrencyRecyclerAdapter mHomeRecyclerAdapter;
    private CurrencyRecyclerAdapter.DataModel mCurrencyRecyclerAdapterDataModel = new CurrencyRecyclerAdapter.DataModel();

    private List<String> mCurrencyList = new ArrayList<>(Arrays.asList(Constants.mSupportedCurrency));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(HomePresenter.class);
        setContentView(R.layout.activity_home);

        initView();
        initListeners();
//        loadExchangeRate();
    }

    private void initView() {
        mHomeNumber = (EditText) findViewById(R.id.homeNumber);
        mHomeSpinner = (Spinner) findViewById(R.id.homeSpinner);
        setupSpinner();

        mHomeRecyclerView = (RecyclerView) findViewById(R.id.homeRecyclerView);
        mHomeRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private List<Rate> getCurrencylist(ExchangeRateViewModel object) {
        List<Rate> list = new ArrayList<>();
        list.addAll(object.rateList);
        return list;
    }

    // Setup spinner
    private void setupSpinner() {
        mSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCurrencyList);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHomeSpinner.setAdapter(mSpinnerAdapter);
        mHomeSpinner.setOnItemSelectedListener(this);

        mHomeSpinner.post(new Runnable() {
            @Override
            public void run() {
                mHomeSpinner.setSelection(mCurrencyList.indexOf(Constants.DEFAULT_BASE));
            }
        });
    }

    private void initListeners() {

    }

    private void loadExchangeRate(String currency) {
        mPresenter.getExchangeRate(currency, mExchangeRateCallback);
    }

    private Callback<ExchangeRateViewModel> mExchangeRateCallback = new Callback<ExchangeRateViewModel>() {
        @Override
        public void onSuccess(ExchangeRateViewModel object) {
            mCurrencyRecyclerAdapterDataModel.list.clear();
            mCurrencyRecyclerAdapterDataModel.list.addAll(getCurrencylist(object));

            double value;
            try {
                value = Double.parseDouble(mHomeNumber.getText().toString());
            } catch (NumberFormatException e) {
                value = 1d;
            }
            mCurrencyRecyclerAdapterDataModel.number = value;

            if (mHomeRecyclerAdapter == null) {

                mHomeRecyclerAdapter = new CurrencyRecyclerAdapter(mHomeRecyclerView.getContext(), mCurrencyRecyclerAdapterDataModel);
                mHomeRecyclerView.setAdapter(mHomeRecyclerAdapter);
            } else {
                mHomeRecyclerAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailure(int errorCode, String errorMsg) {

        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        loadExchangeRate(Constants.mSupportedCurrency[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
