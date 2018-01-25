package com.example.jaime.inventorydb.ui.dependency.presenters;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.dependency.interactors.ListInteractorInteractor;
import com.example.jaime.inventorydb.ui.dependency.contracts.ListDependencyContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyContract.Interactor.OnFinishedLoadDependency {
    private ListDependencyContract.View view;
    HashMap<Integer, Boolean> mSelection = new HashMap<>();


    private ListInteractorInteractor mInteractor;


    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        mInteractor = new ListInteractorInteractor();
    }


    @Override
    public void loadDependency() {
        mInteractor.loadDependencies(this);
        view.showProgressDialog();
    }


    @Override
    public void loadDependencyOrderByName() {
        mInteractor.loadDependenciesOrderByName(this);
        view.showProgressDialog();
    }


    @Override
    public void loadDependencyOrderByID() {
        mInteractor.loadDependenciesOrderByID(this);
        view.showProgressDialog();
    }


    @Override
    public void deleteDependency(Dependency dependency) {
        mInteractor.deleteDependency(dependency, this);
        view.showDeleteMessage();
    }


    @Override
    public void setNewSelection(int position) {
        mSelection.put(position, true);
    }


    @Override
    public void removeSelection(int position) {
        mSelection.remove(position);
    }


    @Override
    public void deleteSelection() {
        view.deleteSelectedDependencies(mSelection.keySet());
    }


    @Override
    public boolean isPositionChecked(int position) {
        return mSelection.get(position) == null ? false : true;
    }


    @Override
    public void clearSelection() {
        mSelection.clear();
    }


    @Override
    public void deleteSelectedDependencies(ArrayList<Dependency> dependencies) {
        mInteractor.deleteDependencies(dependencies, this);
    }


    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependencies(dependencies);
        view.dismissProgressDialog();
    }


    @Override
    public void onDestroy() {
        view = null;
        mInteractor = null;
    }
}
