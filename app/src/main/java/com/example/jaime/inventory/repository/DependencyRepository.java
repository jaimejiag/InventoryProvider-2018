package com.example.jaime.inventory.repository;

import com.example.jaime.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Repositorio con los datos de Dependency.
 */
public class DependencyRepository {
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository instance;


    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }


    public static DependencyRepository getInstance() {
        if (instance == null)
            instance = new DependencyRepository();

        return instance;
    }


    private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));

        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
    }


    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }


    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
