package com.example.jaime.inventorymvp.ui.dependency;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.jaime.inventorymvp.R;
import com.example.jaime.inventorymvp.data.db.model.Dependency;
import com.example.jaime.inventorymvp.data.db.repository.DependencyRepository;

public class AddDependencyActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtSortname;
    private EditText edtDescription;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dependency);

        mToolbar = (Toolbar) findViewById(R.id.tb_addDependency);
        edtName = (EditText)findViewById(R.id.edt_dependency_name);
        edtSortname = (EditText)findViewById(R.id.edt_dependency_sortname);
        edtDescription = (EditText)findViewById(R.id.edt_dependency_description);

        setSupportActionBar(mToolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_dependency, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DependencyRepository.getInstance().addDependency(getDependecy());

        startActivity(new Intent(this, DependencyActivity.class));

        return super.onOptionsItemSelected(item);
    }


    private Dependency getDependecy() {
        int id = DependencyRepository.getInstance().getLastId() + 1;
        String name = edtName.getText().toString();
        String sortname = edtSortname.getText().toString();
        String description = edtDescription.getText().toString();

        return new Dependency(id, name, sortname, description);
    }
}
