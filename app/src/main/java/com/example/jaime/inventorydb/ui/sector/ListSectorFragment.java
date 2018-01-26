package com.example.jaime.inventorydb.ui.sector;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.adapters.SectorAdapter;
import com.example.jaime.inventorydb.data.db.model.Sector;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListSectorFragment extends Fragment {
    public static final String TAG = "listsectorfragment";
    private static final String SECTORS_MODIFIED_KEY = "sector";

    private RecyclerView rvSector;
    private SectorAdapter mAdapter;
    private Toolbar mToolbar;
    private SectorAdapter.OnItemClickListener mListener;
    //private ViewGroup mLayout;


    public static ListSectorFragment newInstance(Bundle arguments) {
        ListSectorFragment fragment = new ListSectorFragment();

        if (arguments != null)
            fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_sector, container, false);

        mToolbar = (Toolbar) view.findViewById(R.id.tb_sector);
        //mLayout = (ConstraintLayout) view.findViewById(R.id.layout_sector);
        rvSector = (RecyclerView) view.findViewById(R.id.rv_sector);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

        rvSector.setHasFixedSize(true);
        rvSector.setLayoutManager(new LinearLayoutManager(getActivity()));

        mListener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sector sector) {
                Toast.makeText(getActivity(), sector.getName() + " " + sector.getSortname(), Toast.LENGTH_SHORT).show();
            }
        };

        if (savedInstanceState != null)
            mAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList(SECTORS_MODIFIED_KEY), mListener);
        else
            mAdapter = new SectorAdapter(mListener);

        rvSector.setAdapter(mAdapter);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(SECTORS_MODIFIED_KEY, mAdapter.getSectorsModified());
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sector, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
