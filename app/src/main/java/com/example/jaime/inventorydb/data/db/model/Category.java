package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 31/01/18.
 */

public class Category implements Parcelable {
    private int _id;
    private String name;
    private String sortname;
    private String description;


    public Category(int _id, String name, String sortname, String description) {
        this._id = _id;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    public Category(String name, String sortname, String description) {
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    protected Category(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
    }


    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(sortname);
        dest.writeString(description);
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return name;
    }
}
