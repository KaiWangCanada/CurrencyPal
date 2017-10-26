package com.kai.currencypal.common.base;

import android.support.v7.app.AppCompatActivity;

import com.kai.service.api.ApiController;

/**
 * BaseActivity
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public static final String EXTRA_ANIMATION = "extra_animation";

    protected P mPresenter;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void initialize(Class<P> presenterClass) {
        try {
            mPresenter = presenterClass.newInstance();
        } catch (ReflectiveOperationException exp) {
        }
    }
}
