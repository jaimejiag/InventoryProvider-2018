package com.example.jaime.inventoryprovider.data.provider.dao;

import com.example.jaime.inventoryprovider.data.base.DependencyDao;
import com.example.jaime.inventoryprovider.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDaoImpl implements DependencyDao {
    private ArrayList<Dependency> mDependencies;


    public DependencyDaoImpl() {
        mDependencies = new ArrayList<>();
    }


    @Override
    public ArrayList<Dependency> loadAll() {
        return null;
    }


    @Override
    public long add(Dependency dependency) {
        return 0;
    }


    @Override
    public int update(Dependency dependency) {
        return 0;
    }


    @Override
    public int delete(Dependency dependency) {
        return 0;
    }


    @Override
    public boolean exists(String name, String sortname) {
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
}
