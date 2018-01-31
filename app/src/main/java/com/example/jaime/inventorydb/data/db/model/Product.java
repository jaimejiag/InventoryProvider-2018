package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by jaime on 31/01/2018.
 */

public class Product implements Parcelable {
    private int _id;
    private String serial;
    private String modelCode;
    private String sortname;
    private String description;
    private int category;
    private int subcategory;
    private int productClass;
    private int sector;
    private int quantity;
    private double value;
    private String vendor;
    private String bitmap;
    private String imageName;
    private String url;
    private String datePurchase;
    private String note;


    public Product(int _id, String serial, String modelCode, String sortname, String description,
                   int category, int subcategory, int productClass, int sector, int quantity, double value,
                   String vendor, String bitmap, String imageName, String url, String datePurchase, String note) {
        this._id = _id;
        this.serial = serial;
        this.modelCode = modelCode;
        this.sortname = sortname;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.productClass = productClass;
        this.sector = sector;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageName = imageName;
        this.url = url;
        this.datePurchase = datePurchase;
        this.note = note;
    }


    public Product(String serial, String modelCode, String sortname, String description, int category,
                   int subcategory, int productClass, int sector, int quantity, double value, String vendor,
                   String bitmap, String imageName, String url, String datePurchase, String note) {
        this.serial = serial;
        this.modelCode = modelCode;
        this.sortname = sortname;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.productClass = productClass;
        this.sector = sector;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageName = imageName;
        this.url = url;
        this.datePurchase = datePurchase;
        this.note = note;
    }


    protected Product(Parcel in) {
        _id = in.readInt();
        serial = in.readString();
        modelCode = in.readString();
        sortname = in.readString();
        description = in.readString();
        category = in.readInt();
        subcategory = in.readInt();
        productClass = in.readInt();
        sector = in.readInt();
        quantity = in.readInt();
        value = in.readDouble();
        vendor = in.readString();
        bitmap = in.readString();
        imageName = in.readString();
        url = in.readString();
        datePurchase = in.readString();
        note = in.readString();
    }


    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_id);
        parcel.writeString(serial);
        parcel.writeString(modelCode);
        parcel.writeString(sortname);
        parcel.writeString(description);
        parcel.writeInt(category);
        parcel.writeInt(subcategory);
        parcel.writeInt(productClass);
        parcel.writeInt(sector);
        parcel.writeInt(quantity);
        parcel.writeDouble(value);
        parcel.writeString(vendor);
        parcel.writeString(bitmap);
        parcel.writeString(imageName);
        parcel.writeString(url);
        parcel.writeString(datePurchase);
        parcel.writeString(note);
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public int getProductClass() {
        return productClass;
    }

    public void setProductClass(int productClass) {
        this.productClass = productClass;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
