package com.example.jaime.inventorydb.data.db.repository.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;

import java.util.ArrayList;

/**
 * Created by jaime on 24/01/2018.
 */

public class DependencyDao {
    ArrayList<Dependency> mDependencies;


    public ArrayList<Dependency> loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        mDependencies = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,InventoryContract.DependencyEntry.ALL_COLUMN,
                null,null,null,null,InventoryContract.DependencyEntry.ORDER_BY,null);

        if(cursor.moveToFirst()){
            do{
                Dependency dependency = new Dependency(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3),
                        cursor.getString(4));
                mDependencies.add(dependency);
            } while(cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();

        return mDependencies;
    }


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


    /**
     * Añade un objeto dependency en la base de datos.
     * @param dependency
     * @return
     */
    public long save(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        long id;

        values.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        values.put(InventoryContract.DependencyEntry.COLUMN_SORTNAME, dependency.getShortname());
        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        values.put(InventoryContract.DependencyEntry.COLUMN_IMAGE, dependency.getImage());

        id = database.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, values);
        InventoryOpenHelper.getInstance().closeDatabase();

        return id;
    }


    public void delete(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        String whereClause = InventoryContract.DependencyEntry._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(dependency.get_ID())};

        database.delete(InventoryContract.DependencyEntry.TABLE_NAME, whereClause, whereArgs);

        InventoryOpenHelper.getInstance().closeDatabase();
    }


    public void update(Dependency dependency) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        String whereClause = InventoryContract.DependencyEntry._ID + "=?";
        String[] whereArgs = new String[] {String.valueOf(dependency.get_ID())};

        values.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        values.put(InventoryContract.DependencyEntry.COLUMN_SORTNAME, dependency.getShortname());
        values.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        values.put(InventoryContract.DependencyEntry.COLUMN_IMAGE, dependency.getImage());

        database.update(InventoryContract.DependencyEntry.TABLE_NAME, values, whereClause, whereArgs);
        InventoryOpenHelper.getInstance().closeDatabase();
    }
}
