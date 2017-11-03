package com.example.jaime.inventorymaterial;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class AccountSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_settings);
    }
}
