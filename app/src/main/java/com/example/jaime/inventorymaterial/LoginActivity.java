package com.example.jaime.inventorymaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Clase encargada del funcionamiento del login de la aplicación.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSingIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSingIn = (Button) findViewById(R.id.btn_singIn);
        btnSingIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
    }
}
