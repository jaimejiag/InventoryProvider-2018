package com.example.jaime.inventorymvp.ui.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.jaime.inventorymvp.R;
import com.example.jaime.inventorymvp.adapters.DependencyAdapter;

/**
 * Activity que muestra un listado de objetos Dependency.
 */
public class DependencyActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private FloatingActionButton fabAdd;

    private DependencyAdapter mAdapter;
    private CoordinatorLayout mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        toolbar = (Toolbar) findViewById(R.id.tb_dependency);
        listView = (ListView) findViewById(R.id.lv_dependencies);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_dependencyAdd);
        mLayout = (CoordinatorLayout) findViewById(R.id.layout_dependency);

        setSupportActionBar(toolbar);
        mAdapter = new DependencyAdapter(this);
        listView.setAdapter(mAdapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
            }
        });
    }


    @Override
    protected void onRestart() {
        onCreate(null);
        super.onRestart();
    }
}
