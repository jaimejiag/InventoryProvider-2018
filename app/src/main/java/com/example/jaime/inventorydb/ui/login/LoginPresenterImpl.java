package com.example.jaime.inventorydb.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String user, String password) {
        loginInteractor.validateCredentials(user, password, this);
    }


    @Override
    public void onUserEmptyError() {
        loginView.setUserEmptyError();
    }


    @Override
    public void onPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }


    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }


    @Override
    public void onSuccess() {
        loginView.navigateToHome();
    }


    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }
}
