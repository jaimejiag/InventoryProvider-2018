package com.example.jaime.inventorydb.ui.sector;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.adapters.SectorAdapter;
import com.example.jaime.inventorydb.data.db.model.Sector;

public class SectorActivity extends AppCompatActivity {
    private ListSectorFragment listSectorFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        listSectorFragment = (ListSectorFragment) getSupportFragmentManager().findFragmentByTag(ListSectorFragment.TAG);

        if (listSectorFragment == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            listSectorFragment = ListSectorFragment.newInstance(null);
            transaction.add(android.R.id.content, listSectorFragment, ListSectorFragment.TAG).commit();
        }
    }
}
