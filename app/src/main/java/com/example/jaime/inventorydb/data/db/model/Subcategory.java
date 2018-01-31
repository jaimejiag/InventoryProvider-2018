package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaime on 31/01/2018.
 */

public class Subcategory implements Parcelable {
    private int _id;
    private String name;
    private String sortname;
    private String description;


    public Subcategory(int _id, String name, String sortname, String description) {
        this._id = _id;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    public Subcategory(String name, String sortname, String description) {
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }


    protected Subcategory(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
    }


    public static final Creator<Subcategory> CREATOR = new Creator<Subcategory>() {
        @Override
        public Subcategory createFromParcel(Parcel in) {
            return new Subcategory(in);
        }

        @Override
        public Subcategory[] newArray(int size) {
            return new Subcategory[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(name);
        parcel.writeString(sortname);
        parcel.writeString(description);
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
