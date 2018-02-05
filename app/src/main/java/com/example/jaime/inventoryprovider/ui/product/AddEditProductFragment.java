package com.example.jaime.inventoryprovider.ui.product;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jaime.inventoryprovider.R;
import com.example.jaime.inventoryprovider.data.db.model.ProductView;

public class AddEditProductFragment extends Fragment {
    public static final String TAG = "addeditproductfragment";

    private EditText edtName;
    private EditText edtSerial;
    private EditText edtVendor;
    private EditText edtModel;
    private TextView txvCategory;
    private TextView txvSubcategory;
    private TextView txvType;
    private TextView txvSector;
    private EditText edtDescription;
    private EditText edtPrice;
    private EditText edtDatePurchase;
    private EditText edtUrl;
    private EditText edtNote;


    public static AddEditProductFragment newInstance(Bundle arguments) {
        AddEditProductFragment fragment = new AddEditProductFragment();

        if (arguments != null)
            fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_edit_product, container, false);

        edtName = (EditText) view.findViewById(R.id.edt_product_name);
        edtSerial = (EditText) view.findViewById(R.id.edt_product_serial);
        edtVendor = (EditText) view.findViewById(R.id.edt_product_seller);
        edtModel = (EditText) view.findViewById(R.id.edit_product_model);
        txvCategory = (TextView) view.findViewById(R.id.txv_category_result);
        txvSubcategory = (TextView) view.findViewById(R.id.txv_subcategory_result);
        txvType = (TextView) view.findViewById(R.id.txv_type_result);
        txvSector = (TextView) view.findViewById(R.id.txv_sector_result);
        edtDescription = (EditText) view.findViewById(R.id.editDescription);
        edtPrice = (EditText) view.findViewById(R.id.edt_product_price);
        edtDatePurchase = (EditText) view.findViewById(R.id.edt_product_date);
        edtUrl = (EditText) view.findViewById(R.id.edt_product_url);
        edtNote = (EditText) view.findViewById(R.id.editNotes);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            ProductView productView = getArguments().getParcelable(ListProductFragment.KEY_PRODUCTVIEW);
            setFields(productView);
        }
    }


    private void setFields(ProductView productView) {
        edtName.setText(productView.getSortname());
        edtSerial.setText(productView.getSerial());
        edtVendor.setText(productView.getVendor());
        edtModel.setText(productView.getModelCode());
        txvCategory.setText(productView.getCategoryName());
        txvSubcategory.setText(productView.getSubcategoryName());
        txvType.setText(productView.getProductClassDescription());
        txvSector.setText(productView.getSectorName());
        edtDescription.setText(productView.getDescription());
        edtPrice.setText(String.valueOf(productView.getValue()));
        edtDatePurchase.setText(productView.getDatePurchase());
        edtUrl.setText(productView.getUrl());
        edtNote.setText(productView.getNote());
    }
}
