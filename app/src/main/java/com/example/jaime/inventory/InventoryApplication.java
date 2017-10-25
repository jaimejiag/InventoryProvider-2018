package com.example.jaime.inventory;

import android.app.Application;

import com.example.jaime.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by Jaime on 25/10/17.
 */

public class InventoryApplication extends Application {
    ArrayList<Dependency> dependencies;


    public InventoryApplication() {
        this.dependencies = new ArrayList<>();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "1º CFGS", "1CFGS Desarrollo de Aplicaciones Multiplataformma"));

        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "2º CFGS", "2CFGS Desarrollo de Aplicaciones Multiplataformma"));
    }


    private void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }


    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
