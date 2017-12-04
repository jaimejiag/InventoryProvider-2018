package com.example.jaime.inventoryfragment;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import com.example.jaime.inventoryfragment.data.prefs.AppPreferencesHelper;

/**
 * Created by usuario on 4/12/17.
 */

public class InventoryApplication extends Application {
    private AppPreferencesHelper mAppPreferencesHelper;
    private static InventoryApplication mContext;


    public InventoryApplication() {
        mContext = this;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mAppPreferencesHelper = AppPreferencesHelper.getInstance();
    }


    public AppPreferencesHelper getAppPreferencesHelper() {
        return mAppPreferencesHelper;
    }

    public static Context getContext() {
        return mContext;
    }
}
