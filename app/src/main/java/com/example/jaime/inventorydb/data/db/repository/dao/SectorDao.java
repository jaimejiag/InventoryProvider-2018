package com.example.jaime.inventorydb.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */

public class SectorDao {

    public ArrayList<Sector> loadAll() {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        ArrayList<Sector> sectors = new ArrayList<>();
        boolean isEnable;
        boolean isSectorDefault;

        Cursor cursor = database.query(InventoryContract.SectorEntry.TABLE_NAME,
                InventoryContract.SectorEntry.ALL_COLUMNS, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                if (cursor.getInt(5) == 1)
                    isEnable = true;
                else
                    isEnable = false;

                if (cursor.getInt(6) == 1)
                    isSectorDefault = true;
                else
                    isSectorDefault = false;

                Sector sector = new Sector(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getInt(4),
                        isEnable, isSectorDefault);

                sectors.add(sector);
            } while (cursor.moveToNext());
        }

        return sectors;
    }
}
