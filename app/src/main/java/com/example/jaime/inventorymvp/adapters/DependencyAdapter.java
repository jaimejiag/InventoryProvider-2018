package com.example.jaime.inventorymvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jaime.inventorymvp.R;
import com.example.jaime.inventorymvp.data.db.model.Dependency;
import com.example.jaime.inventorymvp.data.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Clase adapter que contiene el listado de Dependency.
 */
public class DependencyAdapter extends ArrayAdapter<Dependency> {

    public DependencyAdapter(Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
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
