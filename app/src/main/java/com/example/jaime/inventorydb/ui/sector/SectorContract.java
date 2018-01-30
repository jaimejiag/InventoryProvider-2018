package com.example.jaime.inventorydb.ui.sector;

import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public interface SectorContract {

    interface ListSectorView {
        void showSectors(ArrayList<Sector> sectors);
    }


    interface AddEditSectorView {
        void navigateToListSector();

        void showNameEmptyError();

        void showSortnameEmptyError();

        void showDescriptionEmptyError();

        void showSectorExistsError();

        void initializeDependencies(ArrayList<Dependency> dependencies);
    }


    interface Presenter {
        void requestToLoadSectors();

        void requestToLoadDependecies();

        void requestToAddSector(Sector sector);

        void requestToUpdateSector(Sector sector);
    }


    interface Interactor {
        void loadSectors();

        void loadDependencies();

        void addSector(Sector sector);

        void updateSector(Sector sector);

        interface SectorOperationsFinished {
            void onLoadSuccess(ArrayList<Sector> sectors);
            void onLoadDependenciesSuccess(ArrayList<Dependency> dependencies);
            void onSuccess();
            void onNameEmpty();
            void onSortnameEmpty();
            void onDescriptionEmpty();
            void onSectorExists();
        }
    }
}
