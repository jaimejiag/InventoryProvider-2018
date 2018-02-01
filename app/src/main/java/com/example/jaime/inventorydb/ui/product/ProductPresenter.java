package com.example.jaime.inventorydb.ui.product;

import com.example.jaime.inventorydb.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductPresenter implements ProductContract.Presenter, ProductContract.Interactor.ProductOperationsFinished {
    private ProductContract.View mView;
    private ProductContract.Interactor mInteractor;


    public ProductPresenter(ProductContract.View view) {
        mView = view;
        mInteractor = new ProductInteractor(this);
    }


    @Override
    public void requestToLoadProduct() {
        mInteractor.loadProduct();
    }


    @Override
    public void onLoadSuccess(ArrayList<Product> products) {
        mView.showProducts(products);
    }
}
