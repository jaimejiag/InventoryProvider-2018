package com.example.jaime.inventorydb.data.db.repository.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jaime.inventorydb.data.db.InventoryContract;
import com.example.jaime.inventorydb.data.db.model.InventoryOpenHelper;
import com.example.jaime.inventorydb.data.db.model.Product;

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



}
