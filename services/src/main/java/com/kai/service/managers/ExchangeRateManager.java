package com.kai.service.managers;

import com.kai.service.api.ApiController;
import com.kai.service.api.models.ExchangeRateDataModel;
import com.kai.service.base.Callback;
import com.kai.service.utilities.TimeUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ExchangeRateManager
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public enum ExchangeRateManager {

    ourInstance;

    private List<ExchangeRateDataModel> mRatelist = new ArrayList<>();

    public void getExchangeRate(final String base, final Callback<ExchangeRateDataModel> callback) {
        if (!containsRate(base)) {
            ApiController.ourInstance.getExchangeRate(base, new Callback<ExchangeRateDataModel>() {
                @Override
                public void onSuccess(ExchangeRateDataModel object) {
                    object.updatedTimeMinutes = TimeUtils.getCurrentMinutes();
                    mRatelist.add(object);
                    if (callback != null) callback.onSuccess(object);
                }

                @Override
                public void onFailure(int errorCode, String errorMsg) {
                    if (callback != null) callback.onFailure(errorCode, errorMsg);
                }
            });
        } else {
            if (callback != null) callback.onSuccess(getRate(base));
        }
    }

    private boolean containsRate(String base) {
        Iterator<ExchangeRateDataModel> it = mRatelist.iterator();
        while (it.hasNext()) {
            ExchangeRateDataModel exchangeRateDataModel = it.next();
            if (exchangeRateDataModel.base.equalsIgnoreCase(base)) {
                if (TimeUtils.lessThan30Minutes(exchangeRateDataModel.updatedTimeMinutes))
                    return true;
                else {
                    it.remove();
                    return false;
                }
            }
        }
        return false;
    }

    private ExchangeRateDataModel getRate(String base) {
        for (ExchangeRateDataModel exchangeRateDataModel : mRatelist) {
            if (exchangeRateDataModel.base.equalsIgnoreCase(base))
                return exchangeRateDataModel;
        }
        return null;
    }
}
