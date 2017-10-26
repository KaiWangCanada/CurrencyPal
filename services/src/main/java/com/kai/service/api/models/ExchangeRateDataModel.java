package com.kai.service.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * ExchangeRateDataModel
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class ExchangeRateDataModel extends BaseDataModel {

    @SerializedName("base")
    public String base;
    @SerializedName("date")
    public String date;
    @SerializedName("rates")
    public Rates rates;

    public static class Rates {
        @SerializedName("AUD")
        public double AUD;
        @SerializedName("BGN")
        public double BGN;
        @SerializedName("BRL")
        public double BRL;
        @SerializedName("CAD")
        public double CAD;
        @SerializedName("CHF")
        public double CHF;
        @SerializedName("CNY")
        public double CNY;
        @SerializedName("CZK")
        public double CZK;
        @SerializedName("DKK")
        public double DKK;
        @SerializedName("GBP")
        public double GBP;
        @SerializedName("HKD")
        public double HKD;
        @SerializedName("HRK")
        public double HRK;
        @SerializedName("HUF")
        public double HUF;
        @SerializedName("IDR")
        public double IDR;
        @SerializedName("ILS")
        public double ILS;
        @SerializedName("INR")
        public double INR;
        @SerializedName("JPY")
        public double JPY;
        @SerializedName("KRW")
        public double KRW;
        @SerializedName("MXN")
        public double MXN;
        @SerializedName("MYR")
        public double MYR;
        @SerializedName("NOK")
        public double NOK;
        @SerializedName("NZD")
        public double NZD;
        @SerializedName("PHP")
        public double PHP;
        @SerializedName("PLN")
        public double PLN;
        @SerializedName("RON")
        public double RON;
        @SerializedName("RUB")
        public double RUB;
        @SerializedName("SEK")
        public double SEK;
        @SerializedName("SGD")
        public double SGD;
        @SerializedName("THB")
        public double THB;
        @SerializedName("TRY")
        public double TRY;
        @SerializedName("USD")
        public double USD;
        @SerializedName("ZAR")
        public double ZAR;
    }
}


