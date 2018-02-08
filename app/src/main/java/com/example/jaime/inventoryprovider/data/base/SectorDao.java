package com.example.jaime.inventoryprovider.data.base;

import com.example.jaime.inventoryprovider.data.model.Dependency;
import com.example.jaime.inventoryprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public interface SectorDao {
    ArrayList<Sector> loadAll();

    long add(Sector sector);

    int update(Sector sector);

    int delete(Sector sector);

    boolean exists(Sector sector);
}
