package com.example.jaime.inventorydb.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jaime.inventorydb.DashBoardActivity;
import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.ui.base.BaseActivity;

/**
 * Clase encargada del funcionamiento del login de la aplicación.
 */
public class LoginViewImpl extends BaseActivity implements View.OnClickListener, LoginView {
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnSingIn;

    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenter = new LoginPresenterImpl(this);

        edtUser = (EditText) findViewById(R.id.edt_user);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnSingIn = (Button) findViewById(R.id.btn_singIn);
        btnSingIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mLoginPresenter.
                validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
    }


    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
    }


    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }


    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
    }


    @Override
    public void setPasswordError() {
        onError(R.string.errorPasswordLenght);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
