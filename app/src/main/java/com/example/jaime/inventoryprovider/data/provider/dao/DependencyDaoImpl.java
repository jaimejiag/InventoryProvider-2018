package com.example.jaime.inventoryprovider.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.jaime.inventoryprovider.InventoryApplication;
import com.example.jaime.inventoryprovider.data.base.DependencyDao;
import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.model.Dependency;
import com.example.jaime.inventoryprovider.data.provider.InventoryProviderContract;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDaoImpl implements DependencyDao {
    private ArrayList<Dependency> mDependencies;


    public DependencyDaoImpl() {
        mDependencies = new ArrayList<>();
    }


    @Override
    public ArrayList<Dependency> loadAll() {
        mDependencies.clear();

        //1. Array projection.
        String[] projection = new String [] {
                InventoryProviderContract.Dependency._ID,
                InventoryProviderContract.Dependency.NAME,
                InventoryProviderContract.Dependency.SORTNAME,
                InventoryProviderContract.Dependency.DESCRIPTION,
                InventoryProviderContract.Dependency.IMAGE
        };

        //2. Hago la consulta al provider con la Uri de Dependency.
        //Con Content Provider está registrado en el sistema.
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Cursor cursor = resolver.query(InventoryProviderContract.Dependency.CONTENT_URI, projection, null,
                null, null);

        if (cursor.moveToFirst()) {
            do {
                Dependency dependency = new Dependency(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4));

                mDependencies.add(dependency);
            } while (cursor.moveToNext());
        }

        return mDependencies;
    }


    @Override
    public long add(Dependency dependency) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Uri uri = resolver.insert(InventoryProviderContract.Dependency.CONTENT_URI, getContentValues(dependency));
        long id = 0;

        if (uri == null)
            id = -1;
        else
            id = Long.parseLong(uri.getLastPathSegment());

        return id;
    }


    @Override
    public int update(Dependency dependency) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.DependencyEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(dependency.get_ID())};
        Uri uri = InventoryProviderContract.Dependency.CONTENT_URI;

        return resolver.update(uri, getContentValues(dependency), selection, selectionArgs);
    }


    @Override
    public int delete(Dependency dependency) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.DependencyEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(dependency.get_ID())};
        Uri uri = InventoryProviderContract.Dependency.CONTENT_URI;

        return resolver.delete(uri, selection, selectionArgs);
    }


    @Override
    public boolean exists(String name, String sortname) {
        boolean result = true;
        int index = 0;

        while (index < mDependencies.size()) {
            if (name.equals(mDependencies.get(index).getName()) || sortname.equals(mDependencies.get(index).getShortname())) {
                result = false;
                index = mDependencies.size();
            } else
                index++;
        }

        return result;
    }


    private ContentValues getContentValues(Dependency dependency) {
        ContentValues values = new ContentValues();

        values.put(InventoryProviderContract.Dependency.NAME, dependency.getName());
        values.put(InventoryProviderContract.Dependency.SORTNAME, dependency.getShortname());
        values.put(InventoryProviderContract.Dependency.DESCRIPTION, dependency.getDescription());
        values.put(InventoryProviderContract.Dependency.IMAGE, dependency.getImage());

        return values;
    }
}
