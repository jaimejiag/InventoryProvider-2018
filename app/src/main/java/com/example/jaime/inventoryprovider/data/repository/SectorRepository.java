package com.example.jaime.inventoryprovider.data.repository;

import com.example.jaime.inventoryprovider.data.base.SectorDao;
import com.example.jaime.inventoryprovider.data.model.Sector;
import com.example.jaime.inventoryprovider.data.provider.dao.SectorDaoImpl;
import com.example.jaime.inventoryprovider.ui.InteractorCallback;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Sector.
 */

public class SectorRepository {
    private static SectorRepository instance;
    private SectorDao mDao;


    private SectorRepository() {
        mDao = new SectorDaoImpl();
    }


    public static SectorRepository getInstance(){
        if (instance == null)
            instance = new SectorRepository();

        return instance;
    }


    public ArrayList<Sector> getSectors() {
        return mDao.loadAll();
    }


    public boolean validateSector(Sector sector) {
        return mDao.exists(sector);
    }


    public void addSector(Sector sector, InteractorCallback callback) {
        long id = mDao.add(sector);

        if (id == -1)
            callback.onError(new Error());
        else
            callback.onSuccess();
    }


    public void updateSector(Sector sector, InteractorCallback callback) {
        int rows = mDao.update(sector);

        if (rows == 0)
            callback.onError(new Error());
    }


    public void deleteSector(Sector sector, InteractorCallback callback) {
        int rows = mDao.delete(sector);

        if (rows == 0)
            callback.onError(new Error());
    }
}
