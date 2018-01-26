package com.kai.currencypal.modules.home.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * LaunchPresenter
 *
 * @author Kai
 *         Created on 1/25/2018
 *         Copyright © 2017 CurrencyPal. All rights reserved.
 */
public class Rate implements Parcelable {
    public String currency;
    public double rate;

    public Rate(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    protected Rate(Parcel in) {
        currency = in.readString();
        rate = in.readDouble();
    }

    public static final Creator<Rate> CREATOR = new Creator<Rate>() {
        @Override
        public Rate createFromParcel(Parcel in) {
            return new Rate(in);
        }

        @Override
        public Rate[] newArray(int size) {
            return new Rate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(currency);
        dest.writeDouble(rate);
    }
}