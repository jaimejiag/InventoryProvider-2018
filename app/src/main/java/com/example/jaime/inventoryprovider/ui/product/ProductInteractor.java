package com.example.jaime.inventoryprovider.ui.product;

import com.example.jaime.inventoryprovider.data.db.model.Product;
import com.example.jaime.inventoryprovider.data.db.repository.ProductRepository;

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
        mListener.onLoadProductView(ProductRepository.getInstance().getProductView(product.get_id()));
    }
}
