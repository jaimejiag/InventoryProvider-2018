package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Sector.
 */

public class SectorRepository {
    private static SectorRepository instance;
    private ArrayList<Sector> sectors;


    private SectorRepository() {
        sectors = new ArrayList<>();
    }


    public static SectorRepository getInstance(){
        if (instance == null)
            instance = new SectorRepository();

        return instance;
    }


    public void addSector(Sector sector) {
        sectors.add(sector);
    }


    public ArrayList<Sector> getSectors() {
        return sectors;
    }


    public void modifySector(int sectorID, boolean isSectorEnabled) {
        int index = 0;

        while (index < sectors.size()){
            if (sectorID == sectors.get(index).get_ID()) {
                sectors.get(index).setEnabled(isSectorEnabled);
                index = sectors.size();
            } else
                index++;
        }
    }
}
