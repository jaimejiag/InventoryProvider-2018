package com.example.jaime.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.jaime.inventory.pojo.Dependency;


public class DependencyActivity extends ListActivity {
    private ArrayAdapter<Dependency> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                ((InventoryApplication) getApplicationContext()).getDependencies());
        getListView().setAdapter(mAdapter);
    }
}
