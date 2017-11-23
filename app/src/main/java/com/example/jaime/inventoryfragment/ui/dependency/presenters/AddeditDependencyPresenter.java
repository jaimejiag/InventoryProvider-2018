package com.example.jaime.inventoryfragment.ui.dependency.presenters;

import com.example.jaime.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddeditDependencyPresenter implements AddeditDependencyContract.Presenter {
    private AddeditDependencyContract.View view;


    public AddeditDependencyPresenter (AddeditDependencyContract.View view) {
        this.view = view;
    }
}
