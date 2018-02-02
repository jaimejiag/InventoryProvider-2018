package com.example.jaime.inventorydb.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {

    public ArrayList<Product> loadAll() {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        ArrayList<Product> products = new ArrayList<>();

        Cursor cursor = database.query(InventoryContract.ProductEntry.TABLE_NAME, InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getInt(5), cursor.getInt(6), cursor.getInt(7),
                        cursor.getInt(8), cursor.getInt(9), cursor.getDouble(10),
                        cursor.getString(11), cursor.getString(12), cursor.getString(13),
                        cursor.getString(14), cursor.getString(15), cursor.getString(16));

                products.add(product);
            } while (cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();
        return products;
    }


    public ProductView search(int id) {
        SQLiteDatabase database = InventoryOpenHelper.getInstance().openDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String selection = InventoryContract.ProductInnerEntry.TABLE_NAME + "." + BaseColumns._ID + "=?";
        String[] selectionArgs = new String[] {String.valueOf(id)};
        ProductView productView = null;

        queryBuilder.setTables(InventoryContract.ProductInnerEntry.PRODUCT_INNER);
        queryBuilder.setProjectionMap(InventoryContract.ProductInnerEntry.sProductInnerProjectionMap);

        Cursor cursor = queryBuilder.query(database, InventoryContract.ProductInnerEntry.ALL_COLUMNS,
                selection, selectionArgs, null, null, null);

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

        InventoryOpenHelper.getInstance().closeDatabase();

        return productView;
    }
}
