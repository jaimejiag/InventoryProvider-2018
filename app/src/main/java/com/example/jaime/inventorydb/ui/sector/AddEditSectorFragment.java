package com.example.jaime.inventorydb.ui.sector;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.inventorydb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditSectorFragment extends Fragment {


    public AddEditSectorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addedit_sector, container, false);
    }

}
