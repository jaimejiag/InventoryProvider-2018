package com.example.jaime.inventoryprovider.ui.sector;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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

import com.example.jaime.inventoryprovider.R;
import com.example.jaime.inventoryprovider.adapters.SectorAdapter;
import com.example.jaime.inventoryprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListSectorFragment extends Fragment implements SectorContract.ListSectorView {
    public static final String TAG = "listsectorfragment";

    private RecyclerView rvSector;
    private FloatingActionButton fabAddSector;

    private SectorAdapter mAdapter;
    private Toolbar mToolbar;
    private SectorAdapter.OnSectorUpdatedListener mSectorUpdatedListener;
    private SectorAdapter.OnItemClickListener mClickListener;
    private SectorAdapter.OnItemLongClickListener mLongClickListener;
    private SectorContract.Presenter mPresenter;
    private ListSectorListener mCallback;


    public interface ListSectorListener {
        void onAddEditSector(Bundle arguments);
    }


    public static ListSectorFragment newInstance(Bundle arguments) {
        ListSectorFragment fragment = new ListSectorFragment();

        if (arguments != null)
            fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (ListSectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implement ListSectorListener");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);

        mPresenter = new SectorPresenter(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_sector, container, false);

        mToolbar = (Toolbar) view.findViewById(R.id.tb_sector);
        rvSector = (RecyclerView) view.findViewById(R.id.rv_sector);
        fabAddSector = (FloatingActionButton) view.findViewById(R.id.fab_addSector);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

        rvSector.setHasFixedSize(true);
        rvSector.setLayoutManager(new LinearLayoutManager(getActivity()));

        mSectorUpdatedListener = new SectorAdapter.OnSectorUpdatedListener() {
            @Override
            public void onSectorUpdated(Sector sector) {
                mPresenter.requestToUpdateSector(sector);
            }
        };

        mClickListener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sector sector) {
                Toast.makeText(getActivity(), sector.getName() + " " + sector.getSortname(), Toast.LENGTH_SHORT).show();
            }
        };

        mLongClickListener = new SectorAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(Sector sector) {
                showDeleteDialog(sector);
            }
        };

        mAdapter = new SectorAdapter(mSectorUpdatedListener, mClickListener, mLongClickListener);

        mPresenter.requestToLoadSectors();
        rvSector.setAdapter(mAdapter);

        fabAddSector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onAddEditSector(null);
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sector, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void showSectors(ArrayList<Sector> sectors) {
        mAdapter.addAll(sectors);
    }


    private void showDeleteDialog(final Sector sector) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.delete_title))
                .setMessage(getResources().getString(R.string.delete_sector_message))
                .setPositiveButton(getResources().getString(R.string.btnOk), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mPresenter.requestToDeleteSector(sector);
                    }
                })
                .setNegativeButton(getResources().getString(R.string.btnCancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}
