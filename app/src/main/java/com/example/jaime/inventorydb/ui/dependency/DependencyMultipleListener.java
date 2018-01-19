package com.example.jaime.inventorydb.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.ui.dependency.contracts.ListDependencyContract;

/**
 * Created by usuario on 18/12/17.
 */

public class DependencyMultipleListener implements AbsListView.MultiChoiceModeListener {
    private ListDependencyContract.Presenter mPresente;
    private int mCount;


    public DependencyMultipleListener(ListDependencyContract.Presenter presente) {
        this.mPresente = presente;
        mCount = 0;
    }


    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        if (checked) {
            mCount++;
            mPresente.setNewSelection(position);
        } else {
            mCount--;
            mPresente.removeSelection(position);
        }

        mode.setTitle(mCount + " seleccionados");
    }


    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_context_listdependency, menu);
        mode.setTitle("Iniciando ActionMode");
        return true;
    }


    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }


    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_listdependency_delete:
                mPresente.deleteSelection();
                break;
        }

        mode.finish();
        return true;
    }


    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mCount = 0;
        mPresente.clearSelection();
    }
}
