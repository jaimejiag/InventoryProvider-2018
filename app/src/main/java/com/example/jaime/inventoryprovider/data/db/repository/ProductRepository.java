package com.example.jaime.inventoryprovider.data.db.repository;

import com.example.jaime.inventoryprovider.data.db.model.Product;
import com.example.jaime.inventoryprovider.data.db.model.ProductView;
import com.example.jaime.inventoryprovider.data.db.repository.dao.ProductDao;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductRepository {
    private static ProductRepository mInstance;
    private ProductDao mDao;


    private ProductRepository() {
        mDao = new ProductDao();
    }


    public static ProductRepository getInstance() {
        if (mInstance == null)
            mInstance = new ProductRepository();

        return mInstance;
    }


    public ArrayList<Product> getProducts() {
        return mDao.loadAll();
    }


    public ProductView getProductView(int id) {
        return mDao.search(id);
    }
}
