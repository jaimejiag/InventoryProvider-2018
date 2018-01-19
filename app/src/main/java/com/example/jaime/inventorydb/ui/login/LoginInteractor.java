package com.example.jaime.inventorydb.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginInteractor {
    
    void validateCredentials(String user, String password, OnLoginFinishedListener listener);
    
    interface OnLoginFinishedListener {
        void onUserEmptyError();
        
        void onPasswordEmptyError();
        
        void onPasswordError();

        void onSuccess();
    }
}
