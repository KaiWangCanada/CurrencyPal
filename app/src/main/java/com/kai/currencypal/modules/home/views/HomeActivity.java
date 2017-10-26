package com.kai.currencypal.modules.home.views;

import android.os.Bundle;

import com.kai.currencypal.R;
import com.kai.currencypal.common.base.BaseActivity;
import com.kai.currencypal.modules.home.HomePresenter;
import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.service.base.Callback;

public class HomeActivity extends BaseActivity<HomePresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(HomePresenter.class);
        setContentView(R.layout.activity_home);

        initView();
        initListeners();
        loadExchangeRate();
    }

    private void initView() {

    }

    private void initListeners() {

    }

    private void loadExchangeRate() {
        mPresenter.getExchangeRate(mExchangeRateCallback);
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
