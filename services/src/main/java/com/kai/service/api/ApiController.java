package com.kai.service.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kai.service.api.endpoints.AppService;
import com.kai.service.api.models.BaseDataModel;
import com.kai.service.api.models.ExchangeRateDataModel;
import com.kai.service.base.Callback;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiController
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public enum ApiController {

    ourInstance;

    private final String TAG = ApiController.class.getSimpleName();

    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_UNSUCCESS = 2;

    private AppService mAppService;

    private Context mContext;
    private String mBaseUrl;

    public void init(final Context context, String baseUrl) {

        mContext = context;
        mBaseUrl = baseUrl;

        // Logging Interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mAppService = retrofit.create(AppService.class);
    }

    public void getExchangeRate(String base, final Callback<ExchangeRateDataModel> callback) {

        Call<ExchangeRateDataModel> call = mAppService.getExchangeRate(base);

        Request<ExchangeRateDataModel> request = new Request<ExchangeRateDataModel>(callback, call);
        request.run();
    }

    private class Request<T extends BaseDataModel> {
        private Callback<T> mCallback;
        private Call<T> mCall;

        public Request(Callback<T> callback, Call<T> call) {
            mCallback = callback;
            mCall = call;
        }

        public void run() {
            mCall.enqueue(new retrofit2.Callback<T>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {

                    T resp = response.body();
                    if (resp != null) {
                        mCallback.onSuccess(resp);
                    } else {
                        mCallback.onFailure(ERROR_NETWORK, "wrong response");
                    }
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    mCallback.onFailure(ERROR_NETWORK, "no network");
                }
            });
        }
    }
}
