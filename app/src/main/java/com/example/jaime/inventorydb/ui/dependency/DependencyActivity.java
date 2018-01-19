package com.example.jaime.inventorydb.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.ui.base.BaseActivity;

/**
 * Activity que muestra un listado de objetos Dependency.
 */
public class DependencyActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener,
        AddeditDependencyFragment.AddeditDependencyListener {
    private ListDependencyFragment mListDependency;
    //private ListDependencyPresenter mListPresenter;
    private AddeditDependencyFragment mAddeditDependency;
    //private AddeditDependencyPresenter mAddeditPresenter;
    private Fragment mDetailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        mListDependency = (ListDependencyFragment) getSupportFragmentManager().findFragmentByTag(ListDependencyFragment.TAG);

        if (mListDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mListDependency = ListDependencyFragment.newInstance(null);
            transaction.add(android.R.id.content, mListDependency, ListDependencyFragment.TAG).commit();
        }

        //mListPresenter = new ListDependencyPresenter(mListDependency);
        //mListDependency.setPresenter(mListPresenter);
    }


    @Override
    public void addNewDependency(Bundle bundle) {
        mAddeditDependency = (AddeditDependencyFragment) getSupportFragmentManager().
                findFragmentByTag(AddeditDependencyFragment.TAG);

        if (mAddeditDependency == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mAddeditDependency = AddeditDependencyFragment.newInstance(bundle);
            transaction.addToBackStack(null);
            transaction.replace(android.R.id.content, mAddeditDependency, AddeditDependencyFragment.TAG).commit();
        }

        //mAddeditPresenter = new AddeditDependencyPresenter(mAddeditDependency);
        //mAddeditDependency.setPresenter(mAddeditPresenter);
    }


    @Override
    public void listDependency() {
        getSupportFragmentManager().popBackStack();
        //mAddeditPresenter = new AddeditDependencyPresenter(mAddeditDependency);
        //mListDependency.setPresenter(mListPresenter);
    }
}
