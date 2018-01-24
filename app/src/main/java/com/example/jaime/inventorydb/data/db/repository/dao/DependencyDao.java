package com.example.jaime.inventorydb.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;

/**
 * Created by jaime on 24/01/2018.
 */

public class DependencyDao {

    public Cursor loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabse();

        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,InventoryContract.DependencyEntry.ALL_COLUMN,
                null,null,null,null,InventoryContract.DependencyEntry.ORDER_BY,null);

        InventoryOpenHelper.getInstance().closeDatabase();
        return cursor;
    }
}
