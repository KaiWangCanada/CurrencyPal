package com.kai.currencypal.modules.home;

import com.kai.currencypal.common.base.BasePresenter;
import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.service.api.models.ExchangeRateDataModel;
import com.kai.service.base.Callback;
import com.kai.service.managers.ExchangeRateManager;

/**
 * HomePresenter
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class HomePresenter extends BasePresenter {

    public void getExchangeRate(final Callback<ExchangeRateViewModel> callback) {
        ExchangeRateManager.ourInstance.getExchangeRate(new Callback<ExchangeRateDataModel>() {
            @Override
            public void onSuccess(ExchangeRateDataModel object) {
                callback.onSuccess(convertToViewModel(object));
            }

            @Override
            public void onFailure(int errorCode, String errorMsg) {
                callback.onFailure(errorCode, errorMsg);
            }
        });
    }

    private ExchangeRateViewModel convertToViewModel(ExchangeRateDataModel object) {
        ExchangeRateViewModel viewModel = new ExchangeRateViewModel();

        viewModel.base = object.base;
        viewModel.date = object.date;

        viewModel.rates = new ExchangeRateViewModel.Rates(object.rates.AUD,
                object.rates.BGN,
                object.rates.BRL,
                object.rates.CAD,
                object.rates.CHF,
                object.rates.CNY,
                object.rates.CZK,
                object.rates.DKK,
                object.rates.GBP,
                object.rates.HKD,
                object.rates.HRK,
                object.rates.HUF,
                object.rates.IDR,
                object.rates.ILS,
                object.rates.INR,
                object.rates.JPY,
                object.rates.KRW,
                object.rates.MXN,
                object.rates.MYR,
                object.rates.NOK,
                object.rates.NZD,
                object.rates.PHP,
                object.rates.PLN,
                object.rates.RON,
                object.rates.RUB,
                object.rates.SEK,
                object.rates.SGD,
                object.rates.THB,
                object.rates.TRY,
                object.rates.USD,
                object.rates.ZAR
                );

        return viewModel;
    }
}
