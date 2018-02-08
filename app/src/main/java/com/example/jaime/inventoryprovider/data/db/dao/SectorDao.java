package com.example.jaime.inventoryprovider.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.model.InventoryOpenHelper;
import com.example.jaime.inventoryprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */

public class SectorDao {
    private ArrayList<Sector> mSectors;


    public SectorDao() {
        mSectors = new ArrayList<>();
    }


    public ArrayList<Sector> loadAll() {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        boolean isEnable;
        boolean isSectorDefault;
        mSectors.clear();

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

                Sector sector = new Sector(cursor.getInt(0), cursor.getInt(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        isEnable, isSectorDefault);

                mSectors.add(sector);
            } while (cursor.moveToNext());
        }

        return mSectors;
    }


    public boolean exists(Sector sector) {
        boolean result = false;
        int index = 0;

        while (index < mSectors.size() && !result) {
            if (sector.getName().equals(mSectors.get(index).getName()) ||
                    sector.getSortname().equals(mSectors.get(index).getSortname()))
                result = true;
            else
                index++;
        }

        return result;
    }


    public long add(Sector sector) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        ContentValues values = getContentValues(sector);
        long id;

        id = database.insert(InventoryContract.SectorEntry.TABLE_NAME, null, values);
        InventoryOpenHelper.getInstance().closeDatabase();

        return id;
    }


    public int update(Sector sector) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        String whereClause = BaseColumns._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(sector.get_ID())};
        ContentValues values = getContentValues(sector);
        int rows;

        rows = database.update(InventoryContract.SectorEntry.TABLE_NAME, values, whereClause, whereArgs);
        InventoryOpenHelper.getInstance().closeDatabase();

        return rows;
    }


    public int delete(Sector sector) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        String whereClause = BaseColumns._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(sector.get_ID())};
        int rows;

        rows = database.delete(InventoryContract.SectorEntry.TABLE_NAME, whereClause, whereArgs);
        InventoryOpenHelper.getInstance().closeDatabase();

        return rows;
    }


    private ContentValues getContentValues(Sector sector) {
        ContentValues values = new ContentValues();

        values.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCY_ID, sector.getDependencyId());
        values.put(InventoryContract.SectorEntry.COLUMN_NAME, sector.getName());
        values.put(InventoryContract.SectorEntry.COLUMN_SORTNAME, sector.getSortname());
        values.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, sector.getDescription());
        values.put(InventoryContract.SectorEntry.COLUMN_ENABLE, sector.isEnabled());
        values.put(InventoryContract.SectorEntry.COLUMN_SECTOR_DEFAULT, sector.isSectorDefault());

        return values;
    }
}
