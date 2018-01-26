package com.example.jaime.inventorydb.ui.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.jaime.inventorydb.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Método que combrueba que la contraseña tenga los siguientes requisitos.
     * Debe contener al menos un dígito.
     * Debe contener al menos un carácter en mayúscula.
     * Debe contener al menos un carácter en minúscula.
     * Debe contener una logintud de al menos 6 carácteres.
     *
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{6,}$";
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }


    public static ProgressDialog showLoadingDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        //progressDialog.show();

        if (progressDialog.getWindow() != null)
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        progressDialog.setProgressStyle(ProgressDialog. STYLE_SPINNER );
        //progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }
}
