package com.example.jaime.inventorydb.ui.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.dependency.contracts.ListDependencyContract;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {
    public static final String MESSAGE = "message";
    public static final String TITTLE = "tittle";
    public static final String DEPENDENCY = "dependency";


    public static Dialog showConfirmDialog(final Bundle bundle, Context context, final ListDependencyContract.Presenter presenter) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITTLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteDependency((Dependency) bundle.getParcelable(DEPENDENCY));
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
