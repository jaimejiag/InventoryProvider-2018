package com.example.jaime.inventorydb.ui.sector;

import com.example.jaime.inventorydb.data.db.model.Sector;
import com.example.jaime.inventorydb.data.db.repository.SectorRepository;
import com.example.jaime.inventorydb.ui.InteractorCallback;

import java.util.ArrayList;

/**
 * Created by jaime on 29/01/2018.
 */

public class SectorInteractor implements SectorContract.Interactor, InteractorCallback {
    private SectorContract.Interactor.LoadSectorsFinished mListener;


    public SectorInteractor(LoadSectorsFinished listener) {
        mListener = listener;
    }


    @Override
    public void loadSectors() {
        ArrayList<Sector> sectors = SectorRepository.getInstance().getSectors();
        mListener.onSuccess(sectors);
    }


    @Override
    public void onSuccess() {

    }


    @Override
    public void onError(Error error) {

    }
}
