package com.example.jaime.inventoryfragment.ui.dependency.presenters;

import android.support.v4.app.Fragment;

import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter {
    ListDependencyContract.View view;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
    }
}
