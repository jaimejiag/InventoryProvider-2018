package com.example.jaime.inventorydb.ui.dependency.contracts;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.base.BasePresenter;
import com.example.jaime.inventorydb.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddeditDependencyContract {

    interface View extends BaseView {
        void navigateToListDependency();
        void setNameEmptyError();
        void setSortNameEmptyError();
        void setSortNameLengthError();
        void setDescriptionEmptyError();
        void setValidateDependencyError();
        void showDatabaseError(Error error);
    }


    interface Presenter extends BasePresenter {
        void saveDependency(String name, String sortName, String description);
        void editDependency(Dependency dependency);
    }


    interface Interactor {
        void validateDependecy(String name, String sortname, String description, Interactor.OnAddeditFinishedListener listener);
        void addDependency(String name, String sortname, String description);
        void editDependency(Dependency dependency,OnAddeditFinishedListener listener);

        interface OnAddeditFinishedListener {
            void onNameEmptyError();

            void onSortNameEmptyError();

            void onSortNameLengthError();

            void onDescriptionEmptyError();

            void onDependencyExists();

            void onSuccess();

            void onDatabaseError(Error error);
        }
    }
}
