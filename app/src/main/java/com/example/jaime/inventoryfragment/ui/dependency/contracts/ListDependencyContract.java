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
    }


    interface Presenter extends BasePresenter {
        void loadDependency();
    }


    interface Interactor {
        void loadDependencies(OnFinishedLoadDependency onFinishedLoadDependency);

        interface OnFinishedLoadDependency {
            void onSuccess(List<Dependency> dependencies);
        }
    }
}
