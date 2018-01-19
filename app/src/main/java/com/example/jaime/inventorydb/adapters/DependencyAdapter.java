package com.example.jaime.inventorydb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Clase adapter que contiene el listado de Dependency.
 */
public class DependencyAdapter extends ArrayAdapter<Dependency> {

    /**
     * Se crea una copia del ArrayList que se tiene en DependencyRepository para tener una copia
     * local en el Adapater que se pueda modificar sin cambiar los datos del repositorio.
     * @param context
     */
    public DependencyAdapter(Context context) {
        super(context, R.layout.item_dependency, new ArrayList<Dependency>());
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewRoot = convertView;
        DependencyHolder holder;

        if (viewRoot == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewRoot = inflater.inflate(R.layout.item_dependency, null);
            holder = new DependencyHolder();

            holder.mliIcon = (MaterialLetterIcon) viewRoot.findViewById(R.id.mli_item_icon);
            holder.txvName = (TextView) viewRoot.findViewById(R.id.txv_item_name);
            holder.txvShortname = (TextView) viewRoot.findViewById(R.id.txv_item_shortname);

            viewRoot.setTag(holder);
        } else
            holder = (DependencyHolder) viewRoot.getTag();

        holder.mliIcon.setLetter(getItem(position).getShortname().substring(0, 1));
        holder.txvName.setText(getItem(position).getName());
        holder.txvShortname.setText(getItem(position).getShortname());

        return viewRoot;
    }


    private class DependencyHolder {
        public MaterialLetterIcon mliIcon;
        public TextView txvName;
        public TextView txvShortname;
    }
}
