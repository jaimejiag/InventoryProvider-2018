package com.example.jaime.inventoryfragment.ui.dependency.presenters;

import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.ui.dependency.AddeditDependencyInteractor;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddeditDependencyPresenter implements AddeditDependencyContract.Presenter,
        AddeditDependencyContract.Interactor.OnAddeditFinishedListener {
    private AddeditDependencyContract.View view;
    private AddeditDependencyContract.Interactor mInteractor;


    public AddeditDependencyPresenter (AddeditDependencyContract.View view) {
        this.view = view;
        mInteractor = new AddeditDependencyInteractor();
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
}
