package com.kai.currencypal.modules.home.models;

import android.os.Parcel;
import android.os.Parcelable;

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
    public Rates rates;

    public ExchangeRateViewModel() {}

    protected ExchangeRateViewModel(Parcel in) {
        base = in.readString();
        date = in.readString();
        rates = in.readParcelable(Rates.class.getClassLoader());
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
        dest.writeParcelable(rates, flags);
    }

    public static class Rates implements Parcelable{
        public double AUD;
        public double BGN;
        public double BRL;
        public double CAD;
        public double CHF;
        public double CNY;
        public double CZK;
        public double DKK;
        public double GBP;
        public double HKD;
        public double HRK;
        public double HUF;
        public double IDR;
        public double ILS;
        public double INR;
        public double JPY;
        public double KRW;
        public double MXN;
        public double MYR;
        public double NOK;
        public double NZD;
        public double PHP;
        public double PLN;
        public double RON;
        public double RUB;
        public double SEK;
        public double SGD;
        public double THB;
        public double TRY;
        public double USD;
        public double ZAR;

        public Rates() {}

        public Rates(double AUD, double BGN, double BRL, double CAD, double CHF, double CNY, double CZK, double DKK, double GBP, double HKD, double HRK, double HUF, double IDR, double ILS, double INR, double JPY, double KRW, double MXN, double MYR, double NOK, double NZD, double PHP, double PLN, double RON, double RUB, double SEK, double SGD, double THB, double TRY, double USD, double ZAR) {
            this.AUD = AUD;
            this.BGN = BGN;
            this.BRL = BRL;
            this.CAD = CAD;
            this.CHF = CHF;
            this.CNY = CNY;
            this.CZK = CZK;
            this.DKK = DKK;
            this.GBP = GBP;
            this.HKD = HKD;
            this.HRK = HRK;
            this.HUF = HUF;
            this.IDR = IDR;
            this.ILS = ILS;
            this.INR = INR;
            this.JPY = JPY;
            this.KRW = KRW;
            this.MXN = MXN;
            this.MYR = MYR;
            this.NOK = NOK;
            this.NZD = NZD;
            this.PHP = PHP;
            this.PLN = PLN;
            this.RON = RON;
            this.RUB = RUB;
            this.SEK = SEK;
            this.SGD = SGD;
            this.THB = THB;
            this.TRY = TRY;
            this.USD = USD;
            this.ZAR = ZAR;
        }

        protected Rates(Parcel in) {
            AUD = in.readDouble();
            BGN = in.readDouble();
            BRL = in.readDouble();
            CAD = in.readDouble();
            CHF = in.readDouble();
            CNY = in.readDouble();
            CZK = in.readDouble();
            DKK = in.readDouble();
            GBP = in.readDouble();
            HKD = in.readDouble();
            HRK = in.readDouble();
            HUF = in.readDouble();
            IDR = in.readDouble();
            ILS = in.readDouble();
            INR = in.readDouble();
            JPY = in.readDouble();
            KRW = in.readDouble();
            MXN = in.readDouble();
            MYR = in.readDouble();
            NOK = in.readDouble();
            NZD = in.readDouble();
            PHP = in.readDouble();
            PLN = in.readDouble();
            RON = in.readDouble();
            RUB = in.readDouble();
            SEK = in.readDouble();
            SGD = in.readDouble();
            THB = in.readDouble();
            TRY = in.readDouble();
            USD = in.readDouble();
            ZAR = in.readDouble();
        }

        public static final Creator<Rates> CREATOR = new Creator<Rates>() {
            @Override
            public Rates createFromParcel(Parcel in) {
                return new Rates(in);
            }

            @Override
            public Rates[] newArray(int size) {
                return new Rates[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(AUD);
            dest.writeDouble(BGN);
            dest.writeDouble(BRL);
            dest.writeDouble(CAD);
            dest.writeDouble(CHF);
            dest.writeDouble(CNY);
            dest.writeDouble(CZK);
            dest.writeDouble(DKK);
            dest.writeDouble(GBP);
            dest.writeDouble(HKD);
            dest.writeDouble(HRK);
            dest.writeDouble(HUF);
            dest.writeDouble(IDR);
            dest.writeDouble(ILS);
            dest.writeDouble(INR);
            dest.writeDouble(JPY);
            dest.writeDouble(KRW);
            dest.writeDouble(MXN);
            dest.writeDouble(MYR);
            dest.writeDouble(NOK);
            dest.writeDouble(NZD);
            dest.writeDouble(PHP);
            dest.writeDouble(PLN);
            dest.writeDouble(RON);
            dest.writeDouble(RUB);
            dest.writeDouble(SEK);
            dest.writeDouble(SGD);
            dest.writeDouble(THB);
            dest.writeDouble(TRY);
            dest.writeDouble(USD);
            dest.writeDouble(ZAR);
        }
    }
}
