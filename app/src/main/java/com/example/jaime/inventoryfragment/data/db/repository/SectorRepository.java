package com.example.jaime.inventoryfragment.data.db.repository;

import com.example.jaime.inventoryfragment.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase repositorio que contiene todos los datos de Sector.
 */

public class SectorRepository {
    private static SectorRepository instance;
    private ArrayList<Sector> sectors;


    private SectorRepository() {
        sectors = new ArrayList<>();
        initialize();
    }


    public static SectorRepository getInstance(){
        if (instance == null)
            instance = new SectorRepository();

        return instance;
    }


    private void initialize() {
        addSector(new Sector(1, "Armario_1", "ARM1",
                "Un armario muy carismático", 1, true, true));
        addSector(new Sector(2, "Armario_2", "ARM2",
                "Un armario poco carismático", 2, false, false));
        addSector(new Sector(3, "Armario_1", "ARM1",
                "Un armario muy carismático", 1, true, true));
        addSector(new Sector(4, "Armario_2", "ARM2",
                "Un armario poco carismático", 2, false, false));
        addSector(new Sector(5, "Armario_1", "ARM1",
                "Un armario muy carismático", 1, true, true));
        addSector(new Sector(6, "Armario_2", "ARM2",
                "Un armario poco carismático", 2, false, false));
        addSector(new Sector(7, "Armario_1", "ARM1",
                "Un armario muy carismático", 1, true, true));
        addSector(new Sector(8, "Armario_2", "ARM2",
                "Un armario poco carismático", 2, false, false));
        addSector(new Sector(9, "Armario_1", "ARM1",
                "Un armario muy carismático", 1, true, true));
        addSector(new Sector(10, "Armario_2", "ARM2",
                "Un armario poco carismático", 2, false, false));
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
