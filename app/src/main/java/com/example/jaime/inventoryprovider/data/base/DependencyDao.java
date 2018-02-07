package com.example.jaime.inventoryprovider.data.base;

import com.example.jaime.inventoryprovider.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public interface DependencyDao {
    ArrayList<Dependency> loadAll();

    long add(Dependency dependency);

    int update(Dependency dependency);

    int delete(Dependency dependency);

    boolean exists(String name, String sortname);
}
