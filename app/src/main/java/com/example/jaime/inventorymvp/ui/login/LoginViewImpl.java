package com.example.jaime.inventorymvp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jaime.inventorymvp.DashBoardActivity;
import com.example.jaime.inventorymvp.R;

/**
 * Clase encargada del funcionamiento del login de la aplicación.
 */
public class LoginViewImpl extends AppCompatActivity implements View.OnClickListener{
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnSingIn;

    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = (EditText) findViewById(R.id.edt_user);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnSingIn = (Button) findViewById(R.id.btn_singIn);
        btnSingIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mLoginPresenter.
                validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());

        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
    }
}
