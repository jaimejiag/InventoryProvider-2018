package com.example.jaime.inventorydb.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.jaime.inventorydb.InventoryApplication;
import com.example.jaime.inventorydb.ui.utils.AppConstans;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper, GeneralPreferencesHelper {
    private static final String TAG = "AppPreferencesHelper";

    private final SharedPreferences mPreferences;
    private static AppPreferencesHelper mInstance;
    private SharedPreferences.OnSharedPreferenceChangeListener mListener;


    public interface AppPreferencesListener {
        void onSharedPreferenceChanged();
    }


    private AppPreferencesHelper() {
        //Si es el fichero por defecto de las preferencias
        mPreferences = InventoryApplication.getContext().getSharedPreferences(AppConstans.PREF_NAME, Context.MODE_PRIVATE);

        mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.i(TAG, "se ha cambiado la key surmano: " + key);
            }
        };
    }


    public static  AppPreferencesHelper getInstance() {
        if (mInstance == null)
            mInstance = new AppPreferencesHelper();

        return mInstance;
    }


    /**
     * ID SQLite
     * @return
     */
    public long getCurrentUserId() {
        long id = mPreferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstans.NULL_INDEX);
        return id;
    }


    public String getCurrentUserName() {
        String name = mPreferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }


    public String getCurrentUserPassword() {
        String password = mPreferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }


    public boolean getCurrentUserRemember() {
        boolean remember = mPreferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return  remember;
    }


    public void setCurrentUserId(long id) {
        mPreferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }


    public void setCurrentUserName(String name) {
        mPreferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();
    }


    public void setCurrentUserPassword(String password) {
        mPreferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();
    }


    public void setCurrentUserRemember(boolean remember) {
        mPreferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();
    }
}
