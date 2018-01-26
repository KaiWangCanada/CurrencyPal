package com.kai.currencypal.modules.launch.views;

import android.os.Bundle;
import android.view.View;

import com.kai.currencypal.R;
import com.kai.currencypal.common.base.BaseActivity;
import com.kai.currencypal.common.navigation.Router;
import com.kai.currencypal.common.navigation.TransitionAnimations;
import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.currencypal.modules.home.views.HomeActivity;
import com.kai.currencypal.modules.launch.LaunchPresenter;
import com.kai.service.base.Callback;
import com.kai.service.utilities.Constants;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/25/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class LaunchActivity extends BaseActivity<LaunchPresenter> {

    private static final String TAG = LaunchActivity.class.getSimpleName();

    private View mLauchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(LaunchPresenter.class);

        setContentView(R.layout.activity_launch);

        initView();
        initListeners();
    }

    private void initListeners() {
        mLauchLayout.post(new Runnable() {
            @Override
            public void run() {
                loadExchangeRate();
            }
        });
    }

    private void initView() {
        mLauchLayout = findViewById(R.id.launchLayout);
    }

    private void loadExchangeRate() {
        mPresenter.getExchangeRate(Constants.DEFAULT_BASE, mExchangeRateCallback);
    }

    private Callback<ExchangeRateViewModel> mExchangeRateCallback = new Callback<ExchangeRateViewModel>() {
        @Override
        public void onSuccess(ExchangeRateViewModel object) {
            continueLaunch();
        }

        @Override
        public void onFailure(int errorCode, String errorMsg) {
            // TODO: 1/25/2018 on failure, show network error dialog
        }
    };

    private void continueLaunch() {
        Router.launchActivity(LaunchActivity.this,
                HomeActivity.class,
                false,
                TransitionAnimations.ANIMATION_TYPE.FADE_IN);

        finish();
    }
}
