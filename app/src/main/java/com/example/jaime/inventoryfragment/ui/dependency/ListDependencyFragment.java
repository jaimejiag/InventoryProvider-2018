package com.example.jaime.inventoryfragment.ui.dependency;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.support.v7.widget.Toolbar;

import com.example.jaime.inventoryfragment.R;
import com.example.jaime.inventoryfragment.adapters.DependencyAdapter;
import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;
import com.example.jaime.inventoryfragment.ui.dependency.presenters.ListDependencyPresenter;
import com.example.jaime.inventoryfragment.ui.utils.CommonDialog;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {
    public static final String TAG = "listdependency";

    private FloatingActionButton fabDependency;

    private ListDependencyContract.Presenter mListPresenter;
    private ListDependencyListener mCallback;
    private DependencyAdapter mAdapter;
    private Toolbar mToolbar;


    interface ListDependencyListener {
        void addNewDependency(Bundle bundle);
    }


    public static ListDependencyFragment newInstance(Bundle bundle) {
        ListDependencyFragment listDependencyFragment = new ListDependencyFragment();

        if (bundle != null)
            listDependencyFragment.setArguments(bundle);

        return listDependencyFragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_dependency, container, false);

        fabDependency = (FloatingActionButton) root.findViewById(R.id.fab_dependency_add);
        mAdapter = new DependencyAdapter(getActivity());

        mListPresenter = new ListDependencyPresenter(this);
        mListPresenter.loadDependency();

        mToolbar = (Toolbar) root.findViewById(R.id.tb_dependency);

        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        registerForContextMenu(getListView());
        setListAdapter(mAdapter);

        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.addNewDependency(null);
            }
        });

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dependency dependency = (Dependency) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(AddeditDependencyFragment.EDIT_KEY, dependency);

                mCallback.addNewDependency(bundle);
            }
        });
    }


    /**
     * Menú contextual sobre la lista
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones lista de dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_context_listdependency, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dependency dependency = (Dependency) getListView().getItemAtPosition(info.position);

        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.MESSAGE, "Desea eliminar la dependencia");
                bundle.putString(CommonDialog.TITTLE, "Eliminar dependencia");
                bundle.putParcelable(CommonDialog.DEPENDENCY, dependency);
                Dialog dialog = CommonDialog.showConfirmDialog(bundle, getActivity(), mListPresenter);
                dialog.show();
                break;
        }

        return super.onContextItemSelected(item);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_listdependency, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sortbyname:
                mListPresenter.loadDependencyOrderByName();
                break;

            case R.id.action_sortbyid:
                mListPresenter.loadDependencyOrderByID();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mListPresenter.onDestroy();
        mAdapter = null;
    }


    @Override
    public void showDependencies(List<Dependency> dependencies) {
        mAdapter.clear();
        mAdapter.addAll(dependencies);
    }


    @Override
    public void showDeleteMessage() {
        Snackbar.make(getView(), "Dependencia eliminada con éxito", Snackbar.LENGTH_SHORT).show();
    }
}
