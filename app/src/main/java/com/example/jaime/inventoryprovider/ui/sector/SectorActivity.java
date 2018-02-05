package com.example.jaime.inventoryprovider.ui.sector;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaime.inventoryprovider.R;

public class SectorActivity extends AppCompatActivity implements ListSectorFragment.ListSectorListener,
        AddEditSectorFragment.AddEditSectorListener {
    private ListSectorFragment listSectorFragment;
    private AddEditSectorFragment addEditSectorFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        listSectorFragment = (ListSectorFragment) getSupportFragmentManager().findFragmentByTag(ListSectorFragment.TAG);

        if (listSectorFragment == null) {
            listSectorFragment = ListSectorFragment.newInstance(null);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(android.R.id.content, listSectorFragment, ListSectorFragment.TAG).commit();
        }
    }


    @Override
    public void onAddEditSector(Bundle arguments) {
        addEditSectorFragment = (AddEditSectorFragment) getSupportFragmentManager().
                findFragmentByTag(AddEditSectorFragment.TAG);

        if (addEditSectorFragment == null)
            addEditSectorFragment = AddEditSectorFragment.newInstance(arguments);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(android.R.id.content, addEditSectorFragment, AddEditSectorFragment.TAG).commit();
    }


    @Override
    public void onListSector() {
        getSupportFragmentManager().popBackStack();
    }
}
