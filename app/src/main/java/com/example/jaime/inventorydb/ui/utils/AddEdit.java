package com.example.jaime.inventorydb.ui.utils;

/**
 * Created by usuario on 29/11/17.
 */

public class AddEdit {
    public static  final int ADD_MODE = 0;
    public static  final int EDIT_MODE = 1;
    private int mode;


    public AddEdit() {
        mode = ADD_MODE;
    }


    public AddEdit(int mode) {
        if (mode < ADD_MODE || mode > EDIT_MODE)
            throw new IllegalArgumentException("Invalid AddEditMode: " + mode);

        this.mode = mode;
    }


    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
