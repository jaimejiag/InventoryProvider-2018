package com.example.jaime.inventorymvp.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        if (password.isEmpty())
            listener.onPasswordEmptyError();
        else if (user.isEmpty())
            listener.onUserEmptyError();
        else if ()
            listener.onPasswordError();
        else
            listener.onSuccess();
    }
}
