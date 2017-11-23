package com.example.jaime.inventoryfragment.ui.dependency;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaime.inventoryfragment.R;
import com.example.jaime.inventoryfragment.ui.dependency.contracts.AddeditDependencyContract;
import com.example.jaime.inventoryfragment.ui.dependency.presenters.AddeditDependencyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddeditDependencyFragment extends Fragment implements AddeditDependencyContract.View {
    public static final String TAG = "addeditdependency";
    private AddeditDependencyContract.Presenter mPresenter;


    public static AddeditDependencyFragment newInstance(Bundle bundle) {
        AddeditDependencyFragment addeditDependencyFragment = new AddeditDependencyFragment();

        if (bundle != null)
            addeditDependencyFragment.setArguments(bundle);

        return addeditDependencyFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_addedit_dependency, container, false);

        if (getArguments() != null) {

        }

        return root;
    }


    @Override
    public void setPresenter(AddeditDependencyContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
