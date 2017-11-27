package com.example.jaime.inventoryfragment.ui.dependency;

import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements ListDependencyContract.Interactor {

    @Override
    public void loadDependencies(OnFinishedLoadDependency onFinishedLoadDependency) {
        onFinishedLoadDependency.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
