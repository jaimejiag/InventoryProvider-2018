package com.example.jaime.inventorydb.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by usuario on 29/11/17.
 */

public class BaseFragment extends Fragment {

    public void onError(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
