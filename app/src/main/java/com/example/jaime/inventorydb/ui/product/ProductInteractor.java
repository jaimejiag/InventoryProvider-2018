package com.example.jaime.inventorydb.ui.product;

import com.example.jaime.inventorydb.data.db.repository.ProductRespository;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductInteractor implements ProductContract.Interactor {
    private ProductOperationsFinished mListener;


    public ProductInteractor(ProductOperationsFinished listener) {
        mListener = listener;
    }


    @Override
    public void loadProduct() {
        mListener.onLoadSuccess(ProductRespository.getInstance().getProducts());
    }
}
