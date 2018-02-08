package com.example.jaime.inventoryprovider.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import com.example.jaime.inventoryprovider.InventoryApplication;
import com.example.jaime.inventoryprovider.data.base.ProductDao;
import com.example.jaime.inventoryprovider.data.db.InventoryContract;
import com.example.jaime.inventoryprovider.data.model.Product;
import com.example.jaime.inventoryprovider.data.model.ProductView;
import com.example.jaime.inventoryprovider.data.model.Sector;
import com.example.jaime.inventoryprovider.data.provider.InventoryProviderContract;

import java.util.ArrayList;

/**
 * Created by jaime on 08/02/2018.
 */

public class ProductDaoImpl implements ProductDao {
    private ArrayList<Product> mProducts;


    public ProductDaoImpl() {
        mProducts = new ArrayList<>();
    }


    @Override
    public ArrayList<Product> loadAll() {
        mProducts.clear();

        String[] projection = new String[]{
                InventoryProviderContract.Product._ID,
                InventoryProviderContract.Product.SERIAL,
                InventoryProviderContract.Product.MODELCODE,
                InventoryProviderContract.Product.SORTNAME,
                InventoryProviderContract.Product.DESCRIPTION,
                InventoryProviderContract.Product.CATEGORY,
                InventoryProviderContract.Product.SUBCATEGORY,
                InventoryProviderContract.Product.PRODUCTCLASS,
                InventoryProviderContract.Product.SECTOR,
                InventoryProviderContract.Product.QUANTITY,
                InventoryProviderContract.Product.VALUE,
                InventoryProviderContract.Product.VENDOR,
                InventoryProviderContract.Product.BITMAP,
                InventoryProviderContract.Product.IMAGENAME,
                InventoryProviderContract.Product.URL,
                InventoryProviderContract.Product.DATEPURCHASE,
                InventoryProviderContract.Product.NOTES
        };

        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Cursor cursor = resolver.query(InventoryProviderContract.Product.CONTENT_URI, projection,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getInt(5), cursor.getInt(6), cursor.getInt(7),
                        cursor.getInt(8), cursor.getInt(9), cursor.getDouble(10),
                        cursor.getString(11), cursor.getString(12), cursor.getString(13),
                        cursor.getString(14), cursor.getString(15), cursor.getString(16));

                mProducts.add(product);
            } while (cursor.moveToNext());
        }

        return mProducts;
    }


    @Override
    public long add(Product product) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Uri uri = resolver.insert(InventoryProviderContract.Product.CONTENT_URI, getContentValues(product));
        long id = 0;

        if (uri == null)
            id = -1;
        else
            id = Long.parseLong(uri.getLastPathSegment());

        return id;
    }


    @Override
    public int update(Product product) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.ProductEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(product.get_id())};
        Uri uri = InventoryProviderContract.Product.CONTENT_URI;

        return resolver.update(uri, getContentValues(product), selection, selectionArgs);
    }


    @Override
    public int delete(Product product) {
        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        String selection = InventoryContract.ProductEntry._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(product.get_id())};
        Uri uri = InventoryProviderContract.Product.CONTENT_URI;

        return resolver.delete(uri, selection, selectionArgs);
    }


    @Override
    public boolean exists(Product product) {
        return false;
    }


    @Override
    public ProductView getProductView(int id) {
        String selection = InventoryContract.ProductInnerEntry.TABLE_NAME + "." + BaseColumns._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(id)};
        ProductView productView = null;

        String[] projection = new String[]{
                InventoryProviderContract.Product._ID,
                InventoryProviderContract.Product.SERIAL,
                InventoryProviderContract.Product.MODELCODE,
                InventoryProviderContract.Product.SORTNAME,
                InventoryProviderContract.Product.DESCRIPTION,
                InventoryProviderContract.Product.CATEGORY,
                InventoryProviderContract.Product.CATEGORYNAME,
                InventoryProviderContract.Product.SUBCATEGORY,
                InventoryProviderContract.Product.SUBCATEGORYNAME,
                InventoryProviderContract.Product.PRODUCTCLASS,
                InventoryProviderContract.Product.PRODUCTCLASSDESCRIPTION,
                InventoryProviderContract.Product.SECTOR,
                InventoryProviderContract.Product.SECTORNAME,
                InventoryProviderContract.Product.QUANTITY,
                InventoryProviderContract.Product.VALUE,
                InventoryProviderContract.Product.VENDOR,
                InventoryProviderContract.Product.BITMAP,
                InventoryProviderContract.Product.IMAGENAME,
                InventoryProviderContract.Product.URL,
                InventoryProviderContract.Product.DATEPURCHASE,
                InventoryProviderContract.Product.NOTES
        };

        ContentResolver resolver = InventoryApplication.getContext().getContentResolver();
        Cursor cursor = resolver.query(InventoryProviderContract.Product.CONTENT_URI_VIEW, projection,
                selection, selectionArgs, null);

        if (cursor.moveToFirst()) {
            do {
                productView = new ProductView(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getInt(5), cursor.getString(6), cursor.getInt(7),
                        cursor.getString(8), cursor.getInt(9), cursor.getString(10),
                        cursor.getInt(11), cursor.getString(12), cursor.getInt(13),
                        cursor.getDouble(14), cursor.getString(15), cursor.getString(16),
                        cursor.getString(17), cursor.getString(18), cursor.getString(19),
                        cursor.getString(20));
            } while (cursor.moveToNext());
        }

        return productView;
    }


    private ContentValues getContentValues(Product product) {
        ContentValues values = new ContentValues();

        values.put(InventoryProviderContract.Product.SERIAL, product.getSerial());
        values.put(InventoryProviderContract.Product.MODELCODE, product.getModelCode());
        values.put(InventoryProviderContract.Product.SORTNAME, product.getSortname());
        values.put(InventoryProviderContract.Product.DESCRIPTION, product.getDescription());
        values.put(InventoryProviderContract.Product.CATEGORY, product.getCategory());
        values.put(InventoryProviderContract.Product.SUBCATEGORY, product.getSubcategory());
        values.put(InventoryProviderContract.Product.PRODUCTCLASS, product.getProductClass());
        values.put(InventoryProviderContract.Product.SECTOR, product.getSector());
        values.put(InventoryProviderContract.Product.QUANTITY, product.getQuantity());
        values.put(InventoryProviderContract.Product.VALUE, product.getValue());
        values.put(InventoryProviderContract.Product.VENDOR, product.getVendor());
        values.put(InventoryProviderContract.Product.BITMAP, product.getBitmap());
        values.put(InventoryProviderContract.Product.IMAGENAME, product.getImageName());
        values.put(InventoryProviderContract.Product.URL, product.getUrl());
        values.put(InventoryProviderContract.Product.DATEPURCHASE, product.getDatePurchase());
        values.put(InventoryProviderContract.Product.NOTES, product.getNote());

        return values;
    }
}
