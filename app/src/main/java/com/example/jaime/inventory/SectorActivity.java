package com.example.jaime.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.jaime.inventory.adapters.SectorAdapter;
import com.example.jaime.inventory.pojo.Sector;

public class SectorActivity extends AppCompatActivity {
    //private static final String SECTORS_MODIFIED_KEY = "sector";

    private RecyclerView rvSector;
    private SectorAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        rvSector = (RecyclerView) findViewById(R.id.rv_sector);
        rvSector.setHasFixedSize(true);
        rvSector.setLayoutManager(new GridLayoutManager(this, 2));

        /*if (savedInstanceState != null)
            mAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList(SECTORS_MODIFIED_KEY));
        else*/
            mAdapter = new SectorAdapter();

        rvSector.setAdapter(mAdapter);
    }


    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(SECTORS_MODIFIED_KEY, mAdapter.getSectorsModified());
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_sector, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
