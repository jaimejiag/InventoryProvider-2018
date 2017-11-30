package com.example.jaime.inventoryfragment.ui.dependency;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.example.jaime.inventoryfragment.R;
import com.example.jaime.inventoryfragment.adapters.DependencyAdapter;
import com.example.jaime.inventoryfragment.data.db.model.Dependency;
import com.example.jaime.inventoryfragment.ui.base.BasePresenter;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.ListDependencyContract;
import com.example.jaime.inventoryfragment.ui.utils.CommonDialog;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {
    public static final String TAG = "listdependency";
    private ListDependencyContract.Presenter mListPresenter;
    private ListDependencyListener mCallback;
    private DependencyAdapter mAdapter;
    private Dependency mDeleteDependency;

    private FloatingActionButton fabDependency;


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

        mAdapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_dependency, container, false);

        fabDependency = (FloatingActionButton) root.findViewById(R.id.fab_dependency_add);
        mListPresenter.loadDependency();

        return root;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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


    @Override
    public void setPresenter(BasePresenter presenter) {
        mListPresenter = (ListDependencyContract.Presenter) presenter;
    }


    @Override
    public void showDependencies(List<Dependency> dependencies) {
        mAdapter.clear();
        mAdapter.addAll(dependencies);
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
        getActivity().getMenuInflater().inflate(R.menu.menu_listdependency, menu);
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
    public void onDestroyView() {
        super.onDestroyView();
        //mListPresenter.onDestroy();
        //mAdapter = null;
    }
}
