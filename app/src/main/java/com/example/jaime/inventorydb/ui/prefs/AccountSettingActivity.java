package com.example.jaime.inventorydb.ui.prefs;

import android.preference.PreferenceActivity;
import android.os.Bundle;

import com.example.jaime.inventorydb.R;

public class AccountSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
