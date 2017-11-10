package com.example.jaime.inventorymvp.data.db.repository;

import com.example.jaime.inventorymvp.data.db.model.Dependency;

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
        addDependency(new Dependency(3, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(4, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(5, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(6, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(7, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(8, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(9, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));
        addDependency(new Dependency(10, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
    }


    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }


    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }


    public int getLastId() {
        return dependencies.get(dependencies.size() - 1).get_ID();
    }
}
