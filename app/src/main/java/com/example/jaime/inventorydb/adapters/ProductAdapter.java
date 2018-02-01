package com.example.jaime.inventorydb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Context context) {
        super(context, R.layout.item_product, new ArrayList<Product>());
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        ProductHolder holder;

        if (rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rootView = inflater.inflate(R.layout.item_product, null, false);
            holder = new ProductHolder();

            holder.txvName = (TextView) rootView.findViewById(R.id.txv_itemProduct_name);
            holder.txvSerial = (TextView) rootView.findViewById(R.id.txv_itemProduct_serial);

            rootView.setTag(holder);
        } else
            holder = (ProductHolder) rootView.getTag();

        holder.txvName.setText(getItem(position).getSortname());
        holder.txvSerial.setText(getItem(position).getSerial());

        return rootView;
    }


    public class ProductHolder {
        private TextView txvName;
        private TextView txvSerial;
    }
}
