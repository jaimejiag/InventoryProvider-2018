package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaime on 31/01/2018.
 */

public class ProductClass implements Parcelable {
    private int _id;
    private String description;


    public ProductClass(int _id, String description) {
        this._id = _id;
        this.description = description;
    }


    public ProductClass(String description) {
        this.description = description;
    }


    protected ProductClass(Parcel in) {
        _id = in.readInt();
        description = in.readString();
    }


    public static final Creator<ProductClass> CREATOR = new Creator<ProductClass>() {
        @Override
        public ProductClass createFromParcel(Parcel in) {
            return new ProductClass(in);
        }

        @Override
        public ProductClass[] newArray(int size) {
            return new ProductClass[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(description);
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return description;
    }
}
