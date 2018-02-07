package com.example.jaime.inventoryprovider.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.db.model.InventoryOpenHelper;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvider extends ContentProvider {
    private static final int PRODUCT = 1;
    private static final int PRODUCT_ID = 2;
    private static final int DEPENDENCY = 3;
    private static final int DEPENDENCY_ID = 4;
    private static final int SECTOR = 5;
    private static final int SECTOR_ID = 6;

    private SQLiteDatabase mDatabase;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH, PRODUCT);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH + "/#", PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH, DEPENDENCY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH + "/#", DEPENDENCY_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH, SECTOR);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH + "/#", SECTOR_ID);
    }


    @Override
    public boolean onCreate() {
        mDatabase = InventoryOpenHelper.getInstance().openDatabase();
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:

                break;

            case PRODUCT_ID:
                break;

            case DEPENDENCY:
                cursor = mDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME, projection,selection,
                        selectionArgs, null, null, sortOrder);
                break;

            case DEPENDENCY_ID:
                break;

            case SECTOR:
                break;

            case SECTOR_ID:
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
