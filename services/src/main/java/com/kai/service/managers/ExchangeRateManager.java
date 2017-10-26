package com.kai.service.managers;

import com.kai.service.api.ApiController;
import com.kai.service.api.models.ExchangeRateDataModel;
import com.kai.service.base.Callback;

/**
 * ExchangeRateManager
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public enum ExchangeRateManager {

    ourInstance;

    private ExchangeRateDataModel mExchangeRateDataModel;

    public void getExchangeRate(final Callback<ExchangeRateDataModel> callback) {
        if (mExchangeRateDataModel == null) {
            ApiController.ourInstance.getExchangeRate(new Callback<ExchangeRateDataModel>() {
                @Override
                public void onSuccess(ExchangeRateDataModel object) {
                    mExchangeRateDataModel = object;
                    if (callback != null) callback.onSuccess(mExchangeRateDataModel);
                }

                @Override
                public void onFailure(int errorCode, String errorMsg) {
                    if (callback != null) callback.onFailure(errorCode, errorMsg);
                }
            });
        } else {
            if (callback != null) callback.onSuccess(mExchangeRateDataModel);
        }
    }
}
