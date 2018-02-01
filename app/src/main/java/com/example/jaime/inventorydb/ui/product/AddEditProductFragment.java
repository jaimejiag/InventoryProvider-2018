package com.example.jaime.inventorydb.ui.product;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.inventorydb.R;

public class AddEditProductFragment extends Fragment {
    public static final String TAG = "addeditproductfragment";


    public static AddEditProductFragment newInstance(Bundle arguments) {
        AddEditProductFragment fragment = new AddEditProductFragment();

        if (arguments != null)
            fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_edit_product, container, false);
    }

}
