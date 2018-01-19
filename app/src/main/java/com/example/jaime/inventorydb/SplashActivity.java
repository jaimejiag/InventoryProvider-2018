package com.example.jaime.inventorydb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaime.inventorydb.ui.login.LoginViewImpl;

/**
 * Activity que muestra el logo de la aplicación durante unos segundos al
 * inicio del arranque de la app.
 * Lanzará la Activity Login pasado 2 segundos en un hilo a parte. Finalmente cerrará esta Activity.
 *
 * @author Jaime Jiménez Agudo
 * @version 1.0
 */
public class SplashActivity extends AppCompatActivity {
    private static final long WAIT_TIME = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginViewImpl.class);
                startActivity(intent);
                finish();
            }
        }, WAIT_TIME);
    }
}
