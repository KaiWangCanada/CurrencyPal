package com.kai.currencypal.modules.home.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * ExchangeRateViewModel
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class ExchangeRateViewModel implements Parcelable {
    public String base;
    public String date;

    public List<Rate> rateList = new ArrayList<>();

    public ExchangeRateViewModel() {
    }

    protected ExchangeRateViewModel(Parcel in) {
        base = in.readString();
        date = in.readString();
        rateList = in.createTypedArrayList(Rate.CREATOR);
    }

    public static final Creator<ExchangeRateViewModel> CREATOR = new Creator<ExchangeRateViewModel>() {
        @Override
        public ExchangeRateViewModel createFromParcel(Parcel in) {
            return new ExchangeRateViewModel(in);
        }

        @Override
        public ExchangeRateViewModel[] newArray(int size) {
            return new ExchangeRateViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(base);
        dest.writeString(date);
        dest.writeTypedList(rateList);
    }
}
