package com.example.jaime.inventoryprovider.ui.product;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaime.inventoryprovider.R;

/**
 * Clase que muestra la activity de Product.
 */
public class ProductActivity extends AppCompatActivity implements ListProductFragment.OnListProduct {
    private ListProductFragment mListProductFragment;
    private AddEditProductFragment mAddEditProductFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mListProductFragment = (ListProductFragment) getSupportFragmentManager().findFragmentByTag(ListProductFragment.TAG);

        if (mListProductFragment == null)
            mListProductFragment = ListProductFragment.newInstance(null);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(android.R.id.content, mListProductFragment, ListProductFragment.TAG).commit();
    }


    @Override
    public void onShowProduct(Bundle arguments) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mAddEditProductFragment = AddEditProductFragment.newInstance(arguments);
        transaction.addToBackStack(null);
        transaction.replace(android.R.id.content, mAddEditProductFragment).commit();
    }
}
