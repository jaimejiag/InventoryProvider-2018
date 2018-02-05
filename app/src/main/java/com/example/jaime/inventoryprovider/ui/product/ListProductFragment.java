package com.example.jaime.inventoryprovider.ui.product;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jaime.inventoryprovider.R;
import com.example.jaime.inventoryprovider.adapters.ProductAdapter;
import com.example.jaime.inventoryprovider.data.db.model.Product;
import com.example.jaime.inventoryprovider.data.db.model.ProductView;

import java.util.ArrayList;


public class ListProductFragment extends Fragment implements ProductContract.View {
    public static final String TAG = "listproductfragment";
    public static final String KEY_PRODUCTVIEW = "keyproductview";

    private ListView lvProduct;
    private FloatingActionButton fabAdd;

    private ProductAdapter mAdapater;
    private ProductContract.Presenter mPresenter;
    private OnListProduct mCallback;


    public interface OnListProduct {
        void onShowProduct(Bundle arguments);
    }


    public static ListProductFragment newInstance(Bundle argument) {
        ListProductFragment fragment = new ListProductFragment();

        if (argument != null)
            fragment.setArguments(argument);

        return fragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnListProduct) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implement OnListProduct");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        mPresenter = new ProductPresenter(this);
        mAdapater = new ProductAdapter(getContext());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);

        lvProduct = (ListView) view.findViewById(R.id.lv_product);
        fabAdd = (FloatingActionButton) view.findViewById(R.id.fab_product_add);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter.requestToLoadProduct();
        lvProduct.setAdapter(mAdapater);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) parent.getItemAtPosition(position);
                mPresenter.requetsToShowProduct(product);
            }
        });
        
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onShowProduct(null);
            }
        });
    }


    @Override
    public void showProducts(ArrayList<Product> products) {
        mAdapater.clear();
        mAdapater.addAll(products);
    }


    @Override
    public void showProductView(ProductView productView) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(KEY_PRODUCTVIEW, productView);
        mCallback.onShowProduct(arguments);
    }
}
