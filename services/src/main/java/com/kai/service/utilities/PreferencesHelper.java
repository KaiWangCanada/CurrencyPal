package com.kai.service.utilities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * PreferencesHelper
 *
 * @author Kai
 *         Created on 2017-05-02
 *         Copyright © 2017 LCBO. All rights reserved.
 */
public class PreferencesHelper {

    private static final String PREFERENCES_FILE_NAME = "LCBOPreferences";

    public static final String PREFERENCES_INTRO_SCREEN = "intro_screen";

    public static final String TERMS_AND_CONDITIONS_LAST_UPDATED = "terms_and_conditions_last_updated";

    private static PreferencesHelper mInstance;
    private final SharedPreferences mReader;
    private final SharedPreferences.Editor mWriter;

    public static PreferencesHelper getInstance(Context context) {
        if (mInstance == null)
            mInstance = new PreferencesHelper(context);

        return mInstance;
    }

    @SuppressLint("CommitPrefEdits")
    private PreferencesHelper(Context context) {
        mReader = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        mWriter = mReader.edit();
    }

    public void setBoolean(String key, boolean b) {
        mWriter.putBoolean(key, b).apply();
    }

    public boolean getBoolean(String key) {
        return mReader.getBoolean(key, false);
    }

    public void setString(String key, String s) {
        mWriter.putString(key, s).apply();
    }

    public String getString(String key) {
        return mReader.getString(key, "");
    }

    public void setLong(String key, long s) {
        mWriter.putLong(key, s).apply();
    }

    public long getLong(String key) {
        return mReader.getLong(key, 0);
    }

    public void clearPreference(String key) {
        mWriter.remove(key).apply();
    }

}
