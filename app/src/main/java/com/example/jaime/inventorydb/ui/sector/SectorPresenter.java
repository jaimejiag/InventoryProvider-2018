package com.example.jaime.inventorydb.ui.sector;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by jaime on 29/01/2018.
 */

public class SectorPresenter implements SectorContract.Presenter, SectorContract.Interactor.SectorOperationsFinished {
    private SectorContract.ListSectorView mListSectorView;
    private SectorContract.AddEditSectorView mAddEditSectorView;
    private SectorContract.Interactor mInteractor;


    public SectorPresenter(SectorContract.ListSectorView view) {
        mListSectorView = view;
        mInteractor = new SectorInteractor(this);
    }


    public SectorPresenter(SectorContract.AddEditSectorView view) {
        mAddEditSectorView = view;
        mInteractor = new SectorInteractor(this);
    }


    @Override
    public void requestToLoadSectors() {
        mInteractor.loadSectors();
    }


    @Override
    public void requestToLoadDependecies() {
        mInteractor.loadDependencies();
    }


    @Override
    public void requestToAddSector(Sector sector) {
        mInteractor.addSector(sector);
    }


    @Override
    public void requestToUpdateSector(Sector sector) {
        mInteractor.updateSector(sector);
    }


    @Override
    public void onLoadSuccess(ArrayList<Sector> sectors) {
        mListSectorView.showSectors(sectors);
    }


    @Override
    public void onLoadDependenciesSuccess(ArrayList<Dependency> dependencies) {
        mAddEditSectorView.initializeDependencies(dependencies);
    }


    @Override
    public void onSuccess() {
        mAddEditSectorView.navigateToListSector();
    }


    @Override
    public void onNameEmpty() {
        mAddEditSectorView.showNameEmptyError();
    }


    @Override
    public void onSortnameEmpty() {
        mAddEditSectorView.showSortnameEmptyError();
    }


    @Override
    public void onDescriptionEmpty() {
        mAddEditSectorView.showDescriptionEmptyError();
    }


    @Override
    public void onSectorExists() {
        mAddEditSectorView.showSectorExistsError();
    }
}
