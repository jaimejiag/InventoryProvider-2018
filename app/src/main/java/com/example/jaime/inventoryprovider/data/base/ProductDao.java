package com.example.jaime.inventoryprovider.data.base;

import com.example.jaime.inventoryprovider.data.model.Product;
import com.example.jaime.inventoryprovider.data.model.ProductView;
import com.example.jaime.inventoryprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * Created by jaime on 08/02/2018.
 */

public interface ProductDao {
    ArrayList<Product> loadAll();

    long add(Product product);

    int update(Product product);

    int delete(Product product);

    boolean exists(Product product);

    ProductView getProductView(int id);
}
