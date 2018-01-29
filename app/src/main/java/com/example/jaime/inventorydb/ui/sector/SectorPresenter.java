package com.example.jaime.inventorydb.ui.sector;

import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by jaime on 29/01/2018.
 */

public class SectorPresenter implements SectorContract.Presenter, SectorContract.Interactor.LoadSectorsFinished {
    private SectorContract.View mView;
    private SectorContract.Interactor mInteractor;


    public SectorPresenter(SectorContract.View view) {
        mView = view;
        mInteractor = new SectorInteractor(this);
    }


    @Override
    public void requestToLoadSectors() {
        mInteractor.loadSectors();
    }


    @Override
    public void onSuccess(ArrayList<Sector> sectors) {
        mView.showSectors(sectors);
    }
}
