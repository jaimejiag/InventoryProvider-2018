package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Sector;
import com.example.jaime.inventorydb.data.db.repository.dao.SectorDao;
import com.example.jaime.inventorydb.ui.InteractorCallback;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Sector.
 */

public class SectorRepository {
    private static SectorRepository instance;
    private SectorDao mDao;


    private SectorRepository() {
        mDao = new SectorDao();
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
        else
            callback.onSuccess();
    }
}
