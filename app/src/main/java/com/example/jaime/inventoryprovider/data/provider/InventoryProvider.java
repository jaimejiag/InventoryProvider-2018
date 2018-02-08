package com.example.jaime.inventoryprovider.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.model.InventoryOpenHelper;

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
    private static final int PRODUCTVIEW = 7;

    private SQLiteDatabase mDatabase;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH, PRODUCT);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH + "/#", PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH, DEPENDENCY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Dependency.CONTENT_PATH + "/#", DEPENDENCY_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH, SECTOR);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Sector.CONTENT_PATH + "/#", SECTOR_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.Product.CONTENT_PATH_VIEW, PRODUCTVIEW);
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
                cursor = mDatabase.query(InventoryContract.ProductEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
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
                cursor = mDatabase.query(InventoryContract.SectorEntry.TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                break;

            case SECTOR_ID:
                break;

            case PRODUCTVIEW:
                SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
                queryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
                queryBuilder.setProjectionMap(InventoryProviderContract.Product.sProductInnerProjectionMap);

                cursor = queryBuilder.query(mDatabase, projection, selection, selectionArgs, null,
                        null, null);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        String result = "";

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                result = "vnd.android.cursor.dir/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Product.CONTENT_PATH;
                break;

            case PRODUCT_ID:
                result = "vnd.android.cursor.item/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Product.CONTENT_PATH;
                break;

            case DEPENDENCY:
                result = "vnd.android.cursor.dir/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Dependency.CONTENT_PATH;
                break;

            case DEPENDENCY_ID:
                result = "vnd.android.cursor.item/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Dependency.CONTENT_PATH;
                break;

            case SECTOR:
                result = "vnd.android.cursor.dir/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Sector.CONTENT_PATH;
                break;

            case SECTOR_ID:
                result = "vnd.android.cursor.item/vnd.com.example.jaime.inventoryprovider/" +
                        InventoryProviderContract.Sector.CONTENT_PATH;
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return result;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri result = null;
        long rows = 0;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                rows = mDatabase.insert(InventoryContract.ProductEntry.TABLE_NAME, null, values);
                break;

            case DEPENDENCY:
                rows = mDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME, null, values);
                result = Uri.parse(InventoryProviderContract.AUTHORITY + InventoryProviderContract.Dependency.CONTENT_URI +
                    "/" + rows);
                break;

            case SECTOR:
                rows = mDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME, null, values);
                result = Uri.parse(InventoryProviderContract.AUTHORITY + InventoryProviderContract.Sector.CONTENT_URI +
                    "/" + rows);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return result;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rows = 0;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                rows = mDatabase.delete(InventoryContract.ProductEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case DEPENDENCY:
                rows = mDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case SECTOR:
                rows = mDatabase.delete(InventoryContract.SectorEntry.TABLE_NAME, selection, selectionArgs);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return rows;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rows = 0;

        switch (uriMatcher.match(uri)) {
            case PRODUCT:
                rows = mDatabase.update(InventoryContract.ProductEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case DEPENDENCY:
                rows = mDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case SECTOR:
                rows = mDatabase.update(InventoryContract.SectorEntry.TABLE_NAME, values, selection, selectionArgs);
                break;

            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }

        return rows;
    }
}
