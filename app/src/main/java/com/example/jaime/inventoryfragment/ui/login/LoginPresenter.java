package com.example.jaime.inventoryfragment.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginPresenter {
    void validateCredentials(String user, String password);
    void onDestroy();
}
