package com.example.jaime.inventorydb.ui.dependency.presenters;

import android.os.AsyncTask;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.ui.dependency.interactors.ListDependenciesInteractor;
import com.example.jaime.inventorydb.ui.dependency.contracts.ListDependencyContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyContract.Interactor.OnFinishedLoadDependency {
    private ListDependencyContract.View view;
    HashMap<Integer, Boolean> mSelection = new HashMap<>();


    private ListDependenciesInteractor mInteractor;


    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        mInteractor = new ListDependenciesInteractor(this);
    }


    @Override
    public void loadDependency() {
        DependencyAsyncTask asyncTask = new DependencyAsyncTask();
        asyncTask.execute();
    }


    @Override
    public void loadDependencyOrderByName() {
        mInteractor.loadDependenciesOrderByName(this);
    }


    @Override
    public void loadDependencyOrderByID() {
        mInteractor.loadDependenciesOrderByID(this);
    }


    @Override
    public void deleteDependency(Dependency dependency) {
        mInteractor.deleteDependency(dependency, this);
        view.showDeleteMessage();
    }


    @Override
    public void setNewSelection(int position) {
        mSelection.put(position, true);
    }


    @Override
    public void removeSelection(int position) {
        mSelection.remove(position);
    }


    @Override
    public void deleteSelection() {
        view.deleteSelectedDependencies(mSelection.keySet());
    }


    @Override
    public boolean isPositionChecked(int position) {
        return mSelection.get(position) == null ? false : true;
    }


    @Override
    public void clearSelection() {
        mSelection.clear();
    }


    @Override
    public void deleteSelectedDependencies(ArrayList<Dependency> dependencies) {
        mInteractor.deleteDependencies(dependencies, this);
    }


    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependencies(dependencies);
    }


    @Override
    public void onDestroy() {
        view = null;
        mInteractor = null;
    }


    class DependencyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressDialog();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mInteractor.loadDependencies(ListDependencyPresenter.this);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.dismissProgressDialog();
        }
    }
}
