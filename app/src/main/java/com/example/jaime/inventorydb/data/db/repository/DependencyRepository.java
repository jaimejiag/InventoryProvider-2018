package com.example.jaime.inventorydb.data.db.repository;

import android.database.Cursor;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.repository.dao.DependencyDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Repositorio con los datos de Dependency.
 */
public class DependencyRepository {
    private ArrayList<Dependency> mDependencies;
    private static DependencyRepository mInstance;
    private DependencyDao mDao;


    private DependencyRepository() {
        this.mDependencies = new ArrayList<>();
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
        mDependencies.clear();
        Cursor cursor = getDependenciesCursor();
        if(cursor.moveToFirst()){
            do{
                Dependency dependency = new Dependency(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3),
                        cursor.getString(4));
                mDependencies.add(dependency);
            } while(cursor.moveToNext());
        }

        return mDependencies;
    }


    public Cursor getDependenciesCursor(){
        return mDao.loadAll();

    }


    public ArrayList<Dependency> getDependenciesOrderByName() {
        Collections.sort(mDependencies, Dependency.COMPARATOR_NAME);
        return mDependencies;
    }


    public ArrayList<Dependency> getDependenciesOrderByID() {
        Collections.sort(mDependencies, Dependency.COMPARATOR_ID);
        return mDependencies;
    }


    public int getLastId() {
        return mDependencies.get(mDependencies.size() - 1).get_ID();
    }


    public boolean validateDependency(String name, String sortname) {
        boolean result = true;
        int index = 0;

        while (index < mDependencies.size()) {
            if (name.equals(mDependencies.get(index).getName()) || sortname.equals(mDependencies.get(index).getShortname())) {
                result = false;
                index = mDependencies.size();
            } else
                index++;
        }

        return result;
    }


    public void editDependency(Dependency dependency) {
        int index = 0;

        while (index < mDependencies.size()) {
            if (dependency.get_ID() == mDependencies.get(index).get_ID()) {
                mDependencies.get(index).setDescription(dependency.getDescription());
                index = mDependencies.size();
            } else
                index++;
        }
    }


    public void deleteDependency(Dependency dependency) {
        Iterator<Dependency> iterator = mDependencies.iterator();
        Dependency tmpDependency;

        while (iterator.hasNext()) {
            tmpDependency = iterator.next();

            if (dependency.get_ID() == tmpDependency.get_ID()) {
                iterator.remove();
                break;
            }
        }
    }


    public Dependency getDependencyAtPosition(int position){
        return mDependencies.get(position);
    }
}
