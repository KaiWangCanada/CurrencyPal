package com.kai.currencypal.common.base;

import com.kai.currencypal.modules.home.models.ExchangeRateViewModel;
import com.kai.currencypal.modules.home.models.Rate;
import com.kai.service.api.models.ExchangeRateDataModel;
import com.kai.service.base.Callback;
import com.kai.service.managers.ExchangeRateManager;
import com.kai.service.utilities.Constants;

/**
 * BasePresenter
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class BasePresenter {
    // Shared code to include here

    // Get exchange rate
    public void getExchangeRate(String base, final Callback<ExchangeRateViewModel> callback) {
        ExchangeRateManager.ourInstance.getExchangeRate(base, new Callback<ExchangeRateDataModel>() {
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

        for (String currency : Constants.mSupportedCurrency) {
            if (!currency.equalsIgnoreCase(object.base)) {
                switch (currency) {
                    case "AUD":
                        viewModel.rateList.add(new Rate("AUD", object.rates.AUD));
                        break;
                    case "BGN":
                        viewModel.rateList.add(new Rate("BGN", object.rates.BGN));
                        break;
                    case "BRL":
                        viewModel.rateList.add(new Rate("BRL", object.rates.BRL));
                        break;
                    case "CAD":
                        viewModel.rateList.add(new Rate("CAD", object.rates.CAD));
                        break;
                    case "CHF":
                        viewModel.rateList.add(new Rate("CHF", object.rates.CHF));
                        break;
                    case "CNY":
                        viewModel.rateList.add(new Rate("CNY", object.rates.CNY));
                        break;
                    case "CZK":
                        viewModel.rateList.add(new Rate("CZK", object.rates.CZK));
                        break;
                    case "DKK":
                        viewModel.rateList.add(new Rate("DKK", object.rates.DKK));
                        break;
                    case "EUR":
                        viewModel.rateList.add(new Rate("EUR", object.rates.EUR));
                        break;
                    case "GBP":
                        viewModel.rateList.add(new Rate("GBP", object.rates.GBP));
                        break;
                    case "HKD":
                        viewModel.rateList.add(new Rate("HKD", object.rates.HKD));
                        break;
                    case "HRK":
                        viewModel.rateList.add(new Rate("HRK", object.rates.HRK));
                        break;
                    case "HUF":
                        viewModel.rateList.add(new Rate("HUF", object.rates.HUF));
                        break;
                    case "IDR":
                        viewModel.rateList.add(new Rate("IDR", object.rates.IDR));
                        break;
                    case "ILS":
                        viewModel.rateList.add(new Rate("ILS", object.rates.ILS));
                        break;
                    case "INR":
                        viewModel.rateList.add(new Rate("INR", object.rates.INR));
                        break;
                    case "JPY":
                        viewModel.rateList.add(new Rate("JPY", object.rates.JPY));
                        break;
                    case "KRW":
                        viewModel.rateList.add(new Rate("KRW", object.rates.KRW));
                        break;
                    case "MXN":
                        viewModel.rateList.add(new Rate("MXN", object.rates.MXN));
                        break;
                    case "MYR":
                        viewModel.rateList.add(new Rate("MYR", object.rates.MYR));
                        break;
                    case "NOK":
                        viewModel.rateList.add(new Rate("NOK", object.rates.NOK));
                        break;
                    case "NZD":
                        viewModel.rateList.add(new Rate("NZD", object.rates.NZD));
                        break;
                    case "PHP":
                        viewModel.rateList.add(new Rate("PHP", object.rates.PHP));
                        break;
                    case "PLN":
                        viewModel.rateList.add(new Rate("PLN", object.rates.PLN));
                        break;
                    case "RON":
                        viewModel.rateList.add(new Rate("RON", object.rates.RON));
                        break;
                    case "RUB":
                        viewModel.rateList.add(new Rate("RUB", object.rates.RUB));
                        break;
                    case "SEK":
                        viewModel.rateList.add(new Rate("SEK", object.rates.SEK));
                        break;
                    case "SGD":
                        viewModel.rateList.add(new Rate("SGD", object.rates.SGD));
                        break;
                    case "THB":
                        viewModel.rateList.add(new Rate("THB", object.rates.THB));
                        break;
                    case "TRY":
                        viewModel.rateList.add(new Rate("TRY", object.rates.TRY));
                        break;
                    case "USD":
                        viewModel.rateList.add(new Rate("USD", object.rates.USD));
                        break;
                    case "ZAR":
                        viewModel.rateList.add(new Rate("ZAR", object.rates.ZAR));
                        break;
                }
            }
        }

        return viewModel;
    }
}
