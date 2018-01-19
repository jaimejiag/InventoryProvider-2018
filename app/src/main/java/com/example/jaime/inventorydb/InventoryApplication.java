package com.example.jaime.inventorydb;

import android.app.Application;
import android.content.Context;

import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.jaime.inventorydb.data.prefs.AppPreferencesHelper;

/**
 * Created by usuario on 4/12/17.
 */

public class InventoryApplication extends Application {
    private AppPreferencesHelper mAppPreferencesHelper;
    private InventoryOpenHelper mInventoryOpenHelper;
    private static InventoryApplication mContext;


    public InventoryApplication() {
        mContext = this;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mAppPreferencesHelper = AppPreferencesHelper.getInstance();
        mInventoryOpenHelper = InventoryOpenHelper.getInstance();
        mInventoryOpenHelper.openDatabase();
    }


    public AppPreferencesHelper getAppPreferencesHelper() {
        return mAppPreferencesHelper;
    }

    public static Context getContext() {
        return mContext;
    }
}
