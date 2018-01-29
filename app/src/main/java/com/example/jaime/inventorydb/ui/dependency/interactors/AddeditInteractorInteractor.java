package com.example.jaime.inventorydb.ui.dependency.interactors;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.repository.DependencyRepository;
import com.example.jaime.inventorydb.ui.dependency.contracts.AddeditDependencyContract;
import com.example.jaime.inventorydb.ui.InteractorCallback;

/**
 * Created by usuario on 24/11/17.
 */

public class AddeditInteractorInteractor implements AddeditDependencyContract.Interactor,
        InteractorCallback {
    AddeditDependencyContract.Interactor.OnAddeditFinishedListener mListener;


    public AddeditInteractorInteractor(OnAddeditFinishedListener listener) {
        mListener = listener;
    }


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
            DependencyRepository.getInstance().addDependency(
                    new Dependency(11, name, sortname, description, ""), this);
            listener.onSuccess();
        } else
            listener.onDependencyExists();
    }


    @Override
    public void addDependency(String name, String sortname, String description) {
        Dependency dependency = new Dependency(11, name, sortname, description, "");
        DependencyRepository.getInstance().addDependency(dependency, this);
    }


    @Override
    public void editDependency(Dependency dependency, OnAddeditFinishedListener listener) {
        DependencyRepository.getInstance().editDependency(dependency, this);
        listener.onSuccess();
    }


    @Override
    public void onSuccess() {
        mListener.onSuccess();
    }


    @Override
    public void onError(Error error) {
        mListener.onDatabaseError(error);
    }
}
