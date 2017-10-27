package com.example.jaime.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.jaime.inventory.adapters.DependencyAdapter;
import com.example.jaime.inventory.pojo.Dependency;
import com.example.jaime.inventory.repository.DependencyRepository;

/**
 * Activity que muestra un listado de objetos Dependency.
 */
public class DependencyActivity extends ListActivity {
    private DependencyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        mAdapter = new DependencyAdapter(this);
        getListView().setAdapter(mAdapter);
    }
}
