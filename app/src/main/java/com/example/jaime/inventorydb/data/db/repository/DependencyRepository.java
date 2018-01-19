package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Repositorio con los datos de Dependency.
 */
public class DependencyRepository {
    private ArrayList<Dependency> mDependencies;
    private static DependencyRepository mInstance;


    private DependencyRepository() {
        this.mDependencies = new ArrayList<>();
        initialize();
    }


    public static DependencyRepository getInstance() {
        if (mInstance == null)
            mInstance = new DependencyRepository();

        return mInstance;
    }


    private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "ZZZ", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "GGG", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(3, "1º Ciclo Formativo Grado Superior",
                "BBB", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(4, "2º Ciclo Formativo Grado Superior",
                "BBB", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(5, "1º Ciclo Formativo Grado Superior",
                "HHH", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(6, "2º Ciclo Formativo Grado Superior",
                "HHH", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(7, "1º Ciclo Formativo Grado Superior",
                "EEE", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(8, "2º Ciclo Formativo Grado Superior",
                "EEE", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(9, "1º Ciclo Formativo Grado Superior",
                "KKK", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(10, "2º Ciclo Formativo Grado Superior",
                "KKK", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
    }


    public void addDependency(Dependency dependency) {
        mDependencies.add(dependency);
    }


    public ArrayList<Dependency> getDependencies() {
        Collections.sort(mDependencies, new Dependency.DependencyOrderByShortName());
        return mDependencies;
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
