package com.example.jaime.inventoryprovider.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.jaime.inventoryprovider.data.db.InventoryContract;

import java.util.HashMap;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContract {
    public static final String AUTHORITY = "com.example.jaime.inventoryprovider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);


    private InventoryProviderContract() {

    }


    public static class Dependency implements BaseColumns {
        public static final String CONTENT_PATH = "dependency";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGE = "imageName";

        public static final String[] PROJECTION = new String[] {
                _ID, NAME, SORTNAME, DESCRIPTION, IMAGE
        };
    }


    public static class Sector implements BaseColumns {
        public static final String CONTENT_PATH = "sector";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String DEPENDENCY_ID = "dependencyId";
        public static final String NAME = "name";
        public static final String SORTNAME = "sortName";
        public static final String DESCRIPTION = "description";
        public static final String ENABLE = "isEnable";
        public static final String SECTOR_DEFAULT = "isSectorDeafault";

        public static final String[] PROJECTION = new String[] {
                _ID, DEPENDENCY_ID, NAME, SORTNAME, DESCRIPTION, ENABLE, SECTOR_DEFAULT
        };
    }


    public static class Product implements BaseColumns {
        public static final String CONTENT_PATH = "product";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String SERIAL = "serial";
        public static final String MODELCODE = "modelCode";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORY = "category";
        public static final String CATEGORYNAME = "categoryName";
        public static final String SUBCATEGORY = "subcategory";
        public static final String SUBCATEGORYNAME = "subcategoryName";
        public static final String PRODUCTCLASS = "productClass";
        public static final String PRODUCTCLASSDESCRIPTION = "productDescription";
        public static final String SECTOR = "sector";
        public static final String SECTORNAME = "sectorName";
        public static final String QUANTITY = "quantity";
        public static final String VALUE = "value";
        public static final String VENDOR = "vendor";
        public static final String BITMAP = "bitmap";
        public static final String IMAGENAME = "imageName";
        public static final String URL = "url";
        public static final String DATEPURCHASE = "datePurchase";
        public static final String NOTES = "notes";

        public static final String[] PROJECTION = new String[] {
                _ID, SERIAL, MODELCODE, SORTNAME, DESCRIPTION, CATEGORY,
                CATEGORYNAME, SUBCATEGORY, SUBCATEGORYNAME, PRODUCTCLASS,
                PRODUCTCLASSDESCRIPTION, SECTOR, SECTORNAME, QUANTITY,
                VALUE, VENDOR, BITMAP, IMAGENAME, URL, DATEPURCHASE, NOTES
        };


        public static HashMap<String, String> sProductInnerProjectionMap;
        static {
            sProductInnerProjectionMap = new HashMap<>();
            sProductInnerProjectionMap.put(BaseColumns._ID, InventoryContract.ProductEntry.TABLE_NAME + "." + InventoryContract.ProductEntry._ID);
            sProductInnerProjectionMap.put(SERIAL, InventoryContract.ProductInnerEntry.COLUMN_SERIAL);
            sProductInnerProjectionMap.put(MODELCODE, InventoryContract.ProductInnerEntry.COLUMN_MODELCODE);
            sProductInnerProjectionMap.put(SORTNAME, InventoryContract.ProductInnerEntry.TABLE_NAME + "." + InventoryContract.ProductInnerEntry.COLUMN_SORTNAME);
            sProductInnerProjectionMap.put(DESCRIPTION, InventoryContract.ProductInnerEntry.TABLE_NAME + "." + InventoryContract.ProductInnerEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(CATEGORY, InventoryContract.CategoryEntry.TABLE_NAME + "." + InventoryContract.CategoryEntry._ID);
            sProductInnerProjectionMap.put(CATEGORYNAME, InventoryContract.CategoryEntry.TABLE_NAME + "." + InventoryContract.CategoryEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(SUBCATEGORY, InventoryContract.ProductInnerEntry.COLUMN_SUBCATEGORY);
            sProductInnerProjectionMap.put(SUBCATEGORYNAME, InventoryContract.SubcategoryEntry.TABLE_NAME + "." + InventoryContract.SubcategoryEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(PRODUCTCLASS, InventoryContract.ProductClassEntry.TABLE_NAME + "." + InventoryContract.ProductClassEntry._ID);
            sProductInnerProjectionMap.put(PRODUCTCLASSDESCRIPTION, InventoryContract.ProductClassEntry.TABLE_NAME + "." + InventoryContract.ProductClassEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(SECTOR, InventoryContract.SectorEntry.TABLE_NAME + "." + InventoryContract.SectorEntry._ID);
            sProductInnerProjectionMap.put(SECTORNAME, InventoryContract.SectorEntry.TABLE_NAME + "." + InventoryContract.SectorEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(QUANTITY, InventoryContract.ProductInnerEntry.COLUMN_QUANTITY);
            sProductInnerProjectionMap.put(VALUE, InventoryContract.ProductInnerEntry.COLUMN_VALUE);
            sProductInnerProjectionMap.put(VENDOR, InventoryContract.ProductInnerEntry.COLUMN_VENDOR);
            sProductInnerProjectionMap.put(BITMAP, InventoryContract.ProductInnerEntry.COLUMN_BITMAP);
            sProductInnerProjectionMap.put(IMAGENAME, InventoryContract.ProductInnerEntry.COLUMN_IMAGENAME);
            sProductInnerProjectionMap.put(URL, InventoryContract.ProductInnerEntry.COLUMN_URL);
            sProductInnerProjectionMap.put(DATEPURCHASE, InventoryContract.ProductInnerEntry.COLUMN_DATEPURCHASE);
            sProductInnerProjectionMap.put(NOTES, InventoryContract.ProductInnerEntry.COLUMN_NOTES);
        }
    }


    public static class Category implements BaseColumns {
        public static final String CONTENT_PATH = "category";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] PROJECTION = new String[] {
                _ID, NAME, SORTNAME, DESCRIPTION
        };
    }


    public static class Subcategory implements BaseColumns {
        public static final String CONTENT_PATH = "subcategory";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SORTNAME = "sortname";
        public static final String DESCRIPTION = "description";

        public static final String[] PROJECTION = new String[] {
                _ID, NAME, SORTNAME, DESCRIPTION
        };
    }


    public static class ProductClass implements BaseColumns {
        public static final String CONTENT_PATH = "productclass";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final String DESCRIPTION = "description";


        public static final String[] PROJECTION = new String[] {
                _ID, DESCRIPTION
        };
    }
}
