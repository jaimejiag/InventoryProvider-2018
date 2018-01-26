package com.example.jaime.inventorydb.ui.sector;

import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 26/01/18.
 */

public interface SectorContract {

    interface View {
        void showSectors(ArrayList<Sector> sectors);
    }


    interface Presenter {
        void requestToLoadSectors();
    }


    interface Interactor {
        void loadSectors();

        interface LoadSectorsFinished {
            void onSuccess(ArrayList<Sector> sectors);
        }
    }
}
