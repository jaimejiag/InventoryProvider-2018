package com.example.jaime.inventorydb.ui.dependency.presenters;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.dependency.interactors.AddeditInteractorInteractor;
import com.example.jaime.inventorydb.ui.dependency.contracts.AddeditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddeditDependencyPresenter implements AddeditDependencyContract.Presenter,
        AddeditDependencyContract.Interactor.OnAddeditFinishedListener {
    private AddeditDependencyContract.View view;
    private AddeditDependencyContract.Interactor mInteractor;


    public AddeditDependencyPresenter (AddeditDependencyContract.View view) {
        this.view = view;
        mInteractor = new AddeditInteractorInteractor(this);
    }


    @Override
    public void saveDependency(String name, String sortname, String description) {
        mInteractor.validateDependecy(name, sortname, description, this);
    }


    @Override
    public void editDependency(Dependency dependency) {
        mInteractor.editDependency(dependency, this);
    }


    @Override
    public void onNameEmptyError() {
        view.setNameEmptyError();
    }


    @Override
    public void onSortNameEmptyError() {
        view.setSortNameEmptyError();
    }


    @Override
    public void onSortNameLengthError() {
        view.setSortNameLengthError();
    }


    @Override
    public void onDescriptionEmptyError() {
        view.setDescriptionEmptyError();
    }


    @Override
    public void onDependencyExists() {
        view.setValidateDependencyError();
    }


    @Override
    public void onSuccess() {
        view.navigateToListDependency();
    }


    @Override
    public void onDatabaseError(Error error) {
        view.showDatabaseError(error);
    }


    @Override
    public void onDestroy() {
        view = null;
        mInteractor = null;
    }
}
