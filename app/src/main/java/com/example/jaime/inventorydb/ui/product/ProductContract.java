package com.example.jaime.inventorydb.ui.product;

import com.example.jaime.inventorydb.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductContract {

    interface View {
        void showProducts(ArrayList<Product> products);
    }


    interface Presenter {
        void requestToLoadProduct();
    }


    interface Interactor {
        void loadProduct();

        interface ProductOperationsFinished {
            void onLoadSuccess(ArrayList<Product> products);
        }
    }
}
