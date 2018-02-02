package com.example.jaime.inventorydb.ui.product;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.repository.ProductRepository;

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
        mListener.onLoadSuccess(ProductRepository.getInstance().getProducts());
    }


    @Override
    public void getProductView(Product product) {
        mListener.onLoadProductView(ProductRepository.getInstance().getProductView());
    }
}
