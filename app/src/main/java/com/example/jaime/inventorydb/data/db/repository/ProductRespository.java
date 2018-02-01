package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.Product;
import com.example.jaime.inventorydb.data.db.repository.dao.ProductDao;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductRespository {
    private static ProductRespository mInstance;
    private ProductDao mDao;


    private ProductRespository() {
        mDao = new ProductDao();
    }


    public static ProductRespository getInstance() {
        if (mInstance == null)
            mInstance = new ProductRespository();

        return mInstance;
    }


    public ArrayList<Product> getProducts() {
        return mDao.loadAll();
    }
}
