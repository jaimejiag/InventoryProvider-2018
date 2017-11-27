package com.example.jaime.inventoryfragment.ui.dependency.presenters;

import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.ui.dependency.ListDependencyInteractor;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyContract.Interactor.OnFinishedLoadDependency {
    private ListDependencyContract.View view;
    private ListDependencyInteractor listDependencyInteractor;


    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        listDependencyInteractor = new ListDependencyInteractor();
    }


    @Override
    public void loadDependency() {
        listDependencyInteractor.loadDependencies(this);
    }


    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependencies(dependencies);
    }
}
