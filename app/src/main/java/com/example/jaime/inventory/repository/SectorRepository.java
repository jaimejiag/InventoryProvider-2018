package com.example.jaime.inventory.repository;

import com.example.jaime.inventory.pojo.Sector;

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
        addSector(new Sector(1, "Armario_a", "ARMa",
                "Un armario muy carismático", 1, true, true));

        addSector(new Sector(2, "Armario_b", "ARMb",
                "Un armario poco carismático", 2, false, false));
    }


    public void addSector(Sector sector) {
        sectors.add(sector);
    }


    public ArrayList<Sector> getSectors() {
        return sectors;
    }
}
