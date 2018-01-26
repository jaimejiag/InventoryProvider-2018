package com.example.jaime.inventorydb.data.db;

import android.provider.BaseColumns;

import java.security.PublicKey;

/**
 * Created by usuario on 19/01/18.
 */

public final class InventoryContract {
    public static final int DATABASE_VERSION = 10;
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
}
