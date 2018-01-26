package com.kai.currencypal.modules.home.views;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.kai.currencypal.R;
import com.kai.currencypal.common.base.BaseActivity;
import com.kai.currencypal.modules.home.HomePresenter;
import com.kai.currencypal.modules.home.adapters.CurrencyRecyclerAdapter;
import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.service.base.Callback;
import com.kai.service.utilities.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends BaseActivity<HomePresenter> {

    private EditText mHomeNumber;

    private Spinner mHomeSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;

    private RecyclerView mHomeRecyclerView;
    private CurrencyRecyclerAdapter mHomeRecyclerAdapter;

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
        mHomeSpinner = (Spinner) findViewById(R.id.homeSpinner);
        setupSpinner();


    }

    // Setup spinner
    private void setupSpinner() {
        mSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCurrencyList);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHomeSpinner.setAdapter(mSpinnerAdapter);

        mHomeSpinner.setSelection(mCurrencyList.indexOf(Constants.DEFAULT_BASE));
    }

    private void initListeners() {

    }

    private void loadExchangeRate() {
        mPresenter.getExchangeRate("USD", mExchangeRateCallback);
    }

    private Callback<ExchangeRateViewModel> mExchangeRateCallback = new Callback<ExchangeRateViewModel>() {
        @Override
        public void onSuccess(ExchangeRateViewModel object) {

        }

        @Override
        public void onFailure(int errorCode, String errorMsg) {

        }
    };
}
