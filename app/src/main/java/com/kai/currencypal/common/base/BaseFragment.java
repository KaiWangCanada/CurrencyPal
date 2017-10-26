package com.kai.currencypal.common.base;

import android.support.v4.app.Fragment;

/**
 * BaseFragment
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;

    protected void initialize(Class<P> presenterClass) {
        try {
            mPresenter = presenterClass.newInstance();
        } catch (ReflectiveOperationException exp) {
        }
    }
}
