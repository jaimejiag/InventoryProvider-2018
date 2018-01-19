package com.example.jaime.inventorydb.ui.sector;

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
    private static final String SECTORS_MODIFIED_KEY = "sector";

    private RecyclerView rvSector;
    private SectorAdapter mAdapter;
    private Toolbar mToolbar;
    private SectorAdapter.OnItemClickListener mListener;
    //private ViewGroup mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        mToolbar = (Toolbar) findViewById(R.id.tb_sector);
        //mLayout = (ConstraintLayout) findViewById(R.id.layout_sector);
        rvSector = (RecyclerView) findViewById(R.id.rv_sector);
        rvSector.setHasFixedSize(true);
        rvSector.setLayoutManager(new LinearLayoutManager(this));

        mListener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sector sector) {
                Toast.makeText(SectorActivity.this, sector.getName() + " " + sector.getSortname(), Toast.LENGTH_SHORT).show();
            }
        };

        if (savedInstanceState != null)
            mAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList(SECTORS_MODIFIED_KEY), mListener);
        else
            mAdapter = new SectorAdapter(mListener);

        setSupportActionBar(mToolbar);
        rvSector.setAdapter(mAdapter);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(SECTORS_MODIFIED_KEY, mAdapter.getSectorsModified());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_sector, menu);

        return super.onCreateOptionsMenu(menu);
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ArrayList<Sector> sectorsModified = mAdapter.getSectorsModified();

        for (int i = 0; i < sectorsModified.size(); i++)
            SectorRepository.getInstance().modifySector(sectorsModified.get(i).get_ID(), sectorsModified.get(i).isEnabled());

        Snackbar.make(mLayout, "Datos guardados con éxito", Snackbar.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }*/
}
