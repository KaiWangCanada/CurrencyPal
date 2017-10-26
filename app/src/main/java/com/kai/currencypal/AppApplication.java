package com.kai.currencypal;


import com.facebook.stetho.Stetho;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.kai.currencypal.common.base.BaseApplication;
import com.kai.service.api.ApiController;
import com.squareup.picasso.Picasso;

/**
 * AppApplication
 *
 * @author Kai
 *         Created on 2017-10-18
 *         Copyright © 2017. All rights reserved.
 */
public class AppApplication extends BaseApplication {

    private final static String TAG = AppApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

        ApiController.ourInstance.init(this, BuildConfig.BASE_URL);

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        Picasso.setSingletonInstance(built);
    }
}
