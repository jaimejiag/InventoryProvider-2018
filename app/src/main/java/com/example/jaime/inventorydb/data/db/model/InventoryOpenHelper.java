package com.example.jaime.inventorydb.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.jaime.inventorydb.InventoryApplication;
import com.example.jaime.inventorydb.data.db.InventoryContract;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {
    private static InventoryOpenHelper mInstance;
    private SQLiteDatabase mDatabase;


    private InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null,
                InventoryContract.DATABASE_VERSION);
    }


    public static InventoryOpenHelper getInstance() {
        if (mInstance == null)
            mInstance = new InventoryOpenHelper();

        return mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);

        db.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
        db.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);

        onCreate(db);
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                db.setForeignKeyConstraintsEnabled(true);
            else
                db.execSQL("PRAGMA foreign_keys=1");
        }
    }


    public void openDatabase() {
        mDatabase = getWritableDatabase();
    }
}
