package com.example.jaime.inventorydb.ui.login;

import com.example.jaime.inventorydb.data.db.repository.UserRepository;
import com.example.jaime.inventorydb.ui.utils.CommonUtils;

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
        else if (!CommonUtils.isPasswordValid(password))
            listener.onPasswordError();
        else if (UserRepository.getInstance().validateCredentials(user, password))
            listener.onSuccess();
    }
}
