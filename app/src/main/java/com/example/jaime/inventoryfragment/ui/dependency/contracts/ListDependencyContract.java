package com.example.jaime.inventoryfragment.ui.dependency.contracts;

import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.ui.base.BasePresenter;
import com.example.jaime.inventoryfragment.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependencies(List<Dependency> dependencies);
        void showDeleteMessage();
    }


    interface Presenter extends BasePresenter {
        void loadDependency();
        void loadDependencyOrderByName();
        void loadDependencyOrderByID();
        void deleteDependency(Dependency dependency);
    }


    interface Interactor {
        void loadDependencies(OnFinishedLoadDependency onFinishedLoadDependency);
        void loadDependenciesOrderByName(OnFinishedLoadDependency onFinishedLoadDependency);
        void loadDependenciesOrderByID(OnFinishedLoadDependency onFinishedLoadDependency);
        void deleteDependency(Dependency dependency, OnFinishedLoadDependency listener);

        interface OnFinishedLoadDependency {
            void onSuccess(List<Dependency> dependencies);
        }
    }
}
