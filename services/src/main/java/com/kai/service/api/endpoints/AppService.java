package com.kai.service.api.endpoints;

import com.kai.service.api.models.ExchangeRateDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * AppService
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public interface AppService {
    @GET("/latest")
    Call<ExchangeRateDataModel> getExchangeRate(@Query("base") String base);
}
