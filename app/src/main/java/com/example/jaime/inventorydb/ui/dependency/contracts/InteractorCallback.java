package com.example.jaime.inventorydb.ui.dependency.contracts;

/**
 * Created by usuario on 25/01/18.
 */

public interface InteractorCallback {

    void onSuccess();

    void onError(Error error);
}
