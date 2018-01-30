package com.example.jaime.inventorydb.data.db;

import android.provider.BaseColumns;

/**
 * Created by usuario on 19/01/18.
 */

public final class InventoryContract {
    public static final int DATABASE_VERSION = 11;
    public static final String DATABASE_NAME = "inventory.db";


    //Por cada tabla se crea una clase que implementa la interfaz BaseColumns.
    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SORTNAME = "sortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGE = "imageName";

        public static final String[] ALL_COLUMN = new String[] {
                _ID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGE
        };

        public static final String ORDER_BY="name";

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT)",
                TABLE_NAME,
                _ID,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGE);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (" +
                "%s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s'), ",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGE,
                "Aula de 2FPGS",
                "2FPGS",
                "Aula de los maquinetis hardcoretis",
                "No tengo imagen") +
                String.format("('%s', '%s', '%s', '%s')",
                        "Aula de 1FPGS",
                        "1FPGS",
                        "Aula donde salva no debería haber salido",
                        "No tengo imagen");
    }


    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_DEPENDENCY_ID = "dependencyId";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SORTNAME = "sortName";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ENABLE = "isEnable";
        public static final String COLUMN_SECTOR_DEFAULT = "isSectorDeafault";

        public static final String[] ALL_COLUMNS = new String[] {
                _ID, COLUMN_DEPENDENCY_ID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION,
                COLUMN_ENABLE, COLUMN_SECTOR_DEFAULT
        };

        public static final String REFERENCES_DEPENDENCY_ID = String.format(
                "REFERENCES %s (%s) ON DELETE RESTRICT ON UPDATE CASCADE",
                DependencyEntry.TABLE_NAME, DependencyEntry._ID);

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s INTEGER NOT NULL %s, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s INTEGER NOT NULL, " +
                "%s INTEGER NOT NULL)",
                TABLE_NAME,
                _ID,
                COLUMN_DEPENDENCY_ID, REFERENCES_DEPENDENCY_ID,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_ENABLE,
                COLUMN_SECTOR_DEFAULT);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                "(%s, %s, %s, %s, %s, %s) VALUES (%s, '%s', '%s', '%s', %s, %s), ",
                TABLE_NAME,
                COLUMN_DEPENDENCY_ID,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_ENABLE,
                COLUMN_SECTOR_DEFAULT,
                1,
                "Sector 1",
                "S1",
                "sector número 1",
                1,
                1) +
                String.format("(%s, '%s', '%s', '%s', %s, %s)" ,
                        2,
                        "Sector 2",
                        "S2",
                        "sector número 2",
                        0,
                        0);
    }


    public static class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SORTNAME = "sortname";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String[] ALL_COLUMNS = new String[] {
                _ID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION
        };

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                "%s INTERGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL)",
                TABLE_NAME,
                _ID,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                "(%s, %s, %s) VALUES ('%s', '%s', '%s'), ",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                "Electrónica",
                "Elec",
                "Categoría de electrónica") +
                String.format("('%s', '%s', '%s')",
                        "Hogar",
                        "Hog",
                        "Categoría de electrónica");
    }


    public static class SubcategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "subcategory";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SORTNAME = "sortname";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String[] ALL_COLUMNS = new String[] {
                _ID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION
        };

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                        "%s INTERGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                _ID,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                        "(%s, %s, %s) VALUES ('%s', '%s', '%s'), ",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                "Telefonía",
                "Tel",
                "Subcategoría de telefonía") +
                String.format("('%s', '%s', '%s'), ",
                        "Televisores",
                        "TV",
                        "Subcategoría de televisores") +
                String.format("('%s', '%s', '%s'), ",
                        "Sofás",
                        "Sof",
                        "Subcategoría de sofás") +
                String.format("('%s', '%s', '%s')",
                        "Mesas",
                        "Mes",
                        "Subcategoría de mesas");
    }


    public static class ProductClassEntry implements BaseColumns {
        public static final String TABLE_NAME = "productClass";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String[] ALL_COLUMN = new String[] {
                _ID, COLUMN_DESCRIPTION
        };

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL)",
                TABLE_NAME,
                _ID,
                COLUMN_DESCRIPTION);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                "(%s) VALUES ('%s'), ",
                TABLE_NAME,
                COLUMN_DESCRIPTION,
                "Descripción de producto 1") +
                String.format("('%s')",
                        "Descripción de producto 2");
    }


    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_MODELCODE = "modelCode";
        public static final String COLUMN_SORTNAME = "sortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_SUBCATEGORY = "subcategory";
        public static final String COLUMN_PRODUCTCLASS = "productClass";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_BITMAP = "bitmap";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATEPURCHASE = "datePurchase";
        public static final String COLUMN_NOTES = "notes";

        public static final String[] ALL_COLUMNS = new String[] {
                _ID, COLUMN_SERIAL, COLUMN_MODELCODE, COLUMN_SORTNAME, COLUMN_DESCRIPTION, COLUMN_CATEGORY,
                COLUMN_SUBCATEGORY, COLUMN_PRODUCTCLASS, COLUMN_QUANTITY, COLUMN_VALUE, COLUMN_VENDOR,
                COLUMN_BITMAP, COLUMN_IMAGENAME, COLUMN_URL, COLUMN_DATEPURCHASE, COLUMN_NOTES
        };

        public static final String REFERENCES_CATEGORY_ID = String.format(
                "REFERENCES %s (%s) ON DELETE RESTRICT ON UPDATE CASCADE",
                CategoryEntry.TABLE_NAME, _ID);

        public static final String REFERENCES_SUBCATEGORY_ID = String.format(
                "REFERENCES %s (%s) ON DELETE RESTRICT ON UPDATE CASCADE",
                SubcategoryEntry.TABLE_NAME, _ID);

        public static final String REFERENCES_PRODUCTCLASS_ID = String.format(
                "REFERENCES %s (%s) ON DELETE RESTRICT ON UPDATE CASCADE",
                ProductClassEntry.TABLE_NAME, _ID);

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (" +
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s INTEGER NOT NULL %s, " +
                "%s INTEGER NOT NULL %s, " +
                "%s INTEGER NOT NULL %s, " +
                "%s INTEGER NOT NULL, " +
                "%s REAL NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL, " +
                "%s TEXT NOT NULL)",
                TABLE_NAME,
                _ID,
                COLUMN_SERIAL,
                COLUMN_MODELCODE,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORY, REFERENCES_CATEGORY_ID,
                COLUMN_SUBCATEGORY, REFERENCES_SUBCATEGORY_ID,
                COLUMN_PRODUCTCLASS, REFERENCES_PRODUCTCLASS_ID,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATEPURCHASE,
                COLUMN_NOTES);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s " +
                "(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES " +
                "('%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, '%s', '%s', '%s', '%s', '%s', '%s')",
                TABLE_NAME,
                COLUMN_SERIAL,
                COLUMN_MODELCODE,
                COLUMN_SORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORY,
                COLUMN_SUBCATEGORY,
                COLUMN_PRODUCTCLASS,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATEPURCHASE,
                COLUMN_NOTES,
                "7492SQL",
                "569L",
                "Producto",
                "Descripción de producto",
                0,
                0,
                0,
                50,
                9.99,
                "LG",
                "",
                "Sin imagen",
                "Sin url",
                "29-04-2017",
                "Producto de prueba");
    }
}
