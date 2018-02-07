package com.example.jaime.inventoryprovider.data.db.repository;

import com.example.jaime.inventoryprovider.data.base.DependencyDao;
import com.example.jaime.inventoryprovider.data.db.model.Dependency;
import com.example.jaime.inventoryprovider.ui.InteractorCallback;
import com.example.jaime.inventoryprovider.data.provider.dao.DependencyDaoImpl;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Repositorio con los datos de Dependency.
 */
public class DependencyRepository {
    private static DependencyRepository mInstance;
    private DependencyDao mDao;


    private DependencyRepository() {
        this.mDao = new DependencyDaoImpl();
    }


    public static DependencyRepository getInstance() {
        if (mInstance == null)
            mInstance = new DependencyRepository();

        return mInstance;
    }


    public ArrayList<Dependency> getDependencies() {
        return mDao.loadAll();
    }


    public ArrayList<Dependency> getDependenciesOrderByName() {
        ArrayList<Dependency> dependencies = mDao.loadAll();
        Collections.sort(dependencies, Dependency.COMPARATOR_NAME);
        return dependencies;
    }


    public ArrayList<Dependency> getDependenciesOrderByID() {
        ArrayList<Dependency> dependencies = mDao.loadAll();
        Collections.sort(dependencies, Dependency.COMPARATOR_ID);
        return dependencies;
    }


    public void addDependency(Dependency dependency,  InteractorCallback callback) {
        long id = mDao.add(dependency);
        Error error = new Error();

        if (id == -1)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public boolean validateDependency(String name, String sortname) {
        return mDao.exists(name, sortname);
    }


    public void editDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.update(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }


    public void deleteDependency(Dependency dependency, InteractorCallback callback) {
        int rows = mDao.delete(dependency);
        Error error = new Error();

        if (rows == 0)
            callback.onError(error);
        else
            callback.onSuccess();
    }
}
