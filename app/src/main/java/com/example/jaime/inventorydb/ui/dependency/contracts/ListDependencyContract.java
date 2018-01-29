package com.example.jaime.inventorydb.ui.dependency.contracts;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.base.BasePresenter;
import com.example.jaime.inventorydb.ui.base.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependencies(List<Dependency> dependencies);

        void showDeleteMessage();

        void deleteSelectedDependencies(Set<Integer> positions);

        void showProgressDialog();

        void dismissProgressDialog();
    }


    interface Presenter extends BasePresenter {
        void loadDependency();

        void loadDependencyOrderByName();

        void loadDependencyOrderByID();

        void deleteDependency(Dependency dependency);

        void setNewSelection(int position);

        void removeSelection(int position);

        void deleteSelection();

        boolean isPositionChecked(int position);

        void clearSelection();

        void deleteSelectedDependencies(ArrayList<Dependency> dependencies);
    }


    interface Interactor {
        void loadDependencies(OnFinishedLoadDependency onFinishedLoadDependency);

        void loadDependenciesOrderByName(OnFinishedLoadDependency onFinishedLoadDependency);

        void loadDependenciesOrderByID(OnFinishedLoadDependency onFinishedLoadDependency);

        void deleteDependency(Dependency dependency, OnFinishedLoadDependency listener);

        void deleteDependencies(ArrayList<Dependency> dependencies, OnFinishedLoadDependency listener);

        Dependency getDependency(int position);

        interface OnFinishedLoadDependency {
            void onSuccess(List<Dependency> dependencies);
        }
    }
}
