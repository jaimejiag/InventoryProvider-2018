package com.example.jaime.inventoryfragment.ui.dependency.interactors;

import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;

import java.util.ArrayList;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements ListDependencyContract.Interactor {

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
        DependencyRepository.getInstance().deleteDependency(dependency);
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public void deleteDependencies(ArrayList<Dependency> dependencies, OnFinishedLoadDependency listener) {
        for (int i = 0; i < dependencies.size(); i++)
            DependencyRepository.getInstance().deleteDependency(dependencies.get(i));

        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }


    @Override
    public Dependency getDependency(int position) {
        return DependencyRepository.getInstance().getDependencyAtPosition(position);
    }
}
