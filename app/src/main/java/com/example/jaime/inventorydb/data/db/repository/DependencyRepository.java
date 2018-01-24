package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.repository.dao.DependencyDao;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Repositorio con los datos de Dependency.
 */
public class DependencyRepository {
    private static DependencyRepository mInstance;
    private DependencyDao mDao;


    private DependencyRepository() {
        this.mDao = new DependencyDao();
    }


    public static DependencyRepository getInstance() {
        if (mInstance == null)
            mInstance = new DependencyRepository();

        return mInstance;
    }


    public void addDependency(Dependency dependency) {
        //mDao.addDependency(dependency);
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


    public boolean validateDependency(String name, String sortname) {
        return mDao.exists(name, sortname);
    }


    public void editDependency(Dependency dependency) {
        mDao.update(dependency);
    }


    public long saveDependency(Dependency dependency) {
        return mDao.save(dependency);
    }


    public void deleteDependency(Dependency dependency) {
        mDao.delete(dependency);
    }


    /*public int getLastId() {
        return mDependencies.get(mDependencies.size() - 1).get_ID();
    }
    */


    /*public Dependency getDependencyAtPosition(int position){
        return mDependencies.get(position);
    }
    */
}
