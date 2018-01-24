package com.example.jaime.inventorydb.ui.dependency.interactors;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.repository.DependencyRepository;
import com.example.jaime.inventorydb.ui.dependency.contracts.AddeditDependencyContract;

/**
 * Created by usuario on 24/11/17.
 */

public class AddeditDependencyInteractor implements AddeditDependencyContract.Interactor {

    @Override
    public void validateDependecy(String name, String sortname, String description, OnAddeditFinishedListener listener) {
        if (name.isEmpty())
            listener.onNameEmptyError();
        else if (sortname.isEmpty())
            listener.onSortNameEmptyError();
        else if (sortname.length() < 2 || sortname.length() > 5)
            listener.onSortNameLengthError();
        else if (description.isEmpty())
            listener.onDescriptionEmptyError();
        else if (DependencyRepository.getInstance().validateDependency(name, sortname)) {
            DependencyRepository.getInstance().saveDependency(
                    new Dependency(11, name, sortname, description, ""));
            listener.onSuccess();
        } else
            listener.onDependencyExists();
    }


    @Override
    public void addDependency(String name, String sortname, String description) {
        Dependency dependency = new Dependency(11, name, sortname, description, "");
        DependencyRepository.getInstance().saveDependency(dependency);
    }


    @Override
    public void editDependency(Dependency dependency, OnAddeditFinishedListener listener) {
        DependencyRepository.getInstance().editDependency(dependency);
        listener.onSuccess();
    }
}
