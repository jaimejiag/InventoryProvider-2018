package com.example.jaime.inventoryprovider.ui.product;

import com.example.jaime.inventoryprovider.data.model.Product;
import com.example.jaime.inventoryprovider.data.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductContract {

    interface View {
        void showProducts(ArrayList<Product> products);

        void showProductView(ProductView productView);
    }


    interface Presenter {
        void requestToLoadProduct();

        void requetsToShowProduct(Product product);
    }


    interface Interactor {
        void loadProduct();

        void getProductView(Product product);

        interface ProductOperationsFinished {
            void onLoadSuccess(ArrayList<Product> products);
            void onLoadProductView(ProductView productView);
        }
    }
}
