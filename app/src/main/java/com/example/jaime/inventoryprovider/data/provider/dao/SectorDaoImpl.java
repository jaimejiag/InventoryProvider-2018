package com.example.jaime.inventoryprovider.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.jaime.inventoryprovider.InventoryApplication;
import com.example.jaime.inventoryprovider.data.base.SectorDao;
import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.model.Sector;
import com.example.jaime.inventoryprovider.data.provider.InventoryProviderContract;

import java.util.ArrayList;

/**
 * Created by usuario on 8/02/18.
 */

public class SectorDaoImpl implements SectorDao {
    private ArrayList<Sector> mSectors;


    public SectorDaoImpl() {
        mSectors = new ArrayList<>();
    }


    @Override
    public ArrayList<Sector> loadAll() {
        mSectors.clear();
        boolean isEnable = false;
        boolean isSectorDefault = false;

        String[] projection = new String[] {
                InventoryProviderContract.Sector._ID,
                InventoryProviderContract.Sector.DEPENDENCY_ID,
                InventoryProviderContract.Sector.NAME,
                InventoryProviderContract.Sector.SORTNAME,
                InventoryProviderContract.Sector.DESCRIPTION,
                InventoryProviderContract.Sector.ENABLE,
                InventoryProviderContract.Sector.SECTOR_DEFAULT
        };

        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Cursor cursor = resolver.query(InventoryProviderContract.Sector.CONTENT_URI, projection,
                null, null, null);

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


    @Override
    public long add(Sector sector) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Uri uri = resolver.insert(InventoryProviderContract.Sector.CONTENT_URI, getContentValues(sector));
        long id = 0;

        if (uri == null)
            id = -1;
        else
            id = Long.parseLong(uri.getLastPathSegment());

        return id;
    }


    @Override
    public int update(Sector sector) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.SectorEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(sector.get_ID())};
        Uri uri = InventoryProviderContract.Sector.CONTENT_URI;

        return resolver.update(uri, getContentValues(sector), selection, selectionArgs);
    }


    @Override
    public int delete(Sector sector) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.SectorEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(sector.get_ID())};
        Uri uri = InventoryProviderContract.Sector.CONTENT_URI;

        return resolver.delete(uri, selection, selectionArgs);
    }


    @Override
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


    private ContentValues getContentValues(Sector sector) {
        ContentValues values = new ContentValues();

        values.put(InventoryProviderContract.Sector.DEPENDENCY_ID, sector.getDependencyId());
        values.put(InventoryProviderContract.Sector.NAME, sector.getName());
        values.put(InventoryProviderContract.Sector.SORTNAME, sector.getSortname());
        values.put(InventoryProviderContract.Sector.DESCRIPTION, sector.getDescription());
        values.put(InventoryProviderContract.Sector.ENABLE, sector.isEnabled());
        values.put(InventoryProviderContract.Sector.SECTOR_DEFAULT, sector.isSectorDefault());

        return values;
    }
}
