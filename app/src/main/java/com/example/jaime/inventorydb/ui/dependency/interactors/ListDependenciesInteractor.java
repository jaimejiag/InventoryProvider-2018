package com.example.jaime.inventorydb.ui.dependency.interactors;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.repository.DependencyRepository;
import com.example.jaime.inventorydb.ui.InteractorCallback;
import com.example.jaime.inventorydb.ui.dependency.contracts.ListDependencyContract;

import java.util.ArrayList;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependenciesInteractor implements ListDependencyContract.Interactor,
        InteractorCallback {
    ListDependencyContract.Interactor.OnFinishedLoadDependency mListener;


    public ListDependenciesInteractor(OnFinishedLoadDependency listener) {
        mListener = listener;
    }


    @Override
    public void loadDependencies(OnFinishedLoadDependency onFinishedLoadDependency) {
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public void loadDependenciesOrderByName(OnFinishedLoadDependency onFinishedLoadDependency) {
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependenciesOrderByName());
    }


    @Override
    public void loadDependenciesOrderByID(OnFinishedLoadDependency onFinishedLoadDependency) {
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependenciesOrderByID());
    }


    @Override
    public void deleteDependency(Dependency dependency, OnFinishedLoadDependency onFinishedLoadDependency) {
        DependencyRepository.getInstance().deleteDependency(dependency, this);
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public void deleteDependencies(ArrayList<Dependency> dependencies, OnFinishedLoadDependency listener) {
        for (int i = 0; i < dependencies.size(); i++)
            DependencyRepository.getInstance().deleteDependency(dependencies.get(i), this);

        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public Dependency getDependency(int position) {
        //return DependencyRepository.getInstance().getDependencyAtPosition(position);
        return null;
    }


    @Override
    public void onSuccess() {
        
    }


    @Override
    public void onError(Error error) {

    }
}
