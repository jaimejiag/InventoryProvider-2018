package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase pojo de Sector
 */

public class Sector implements Parcelable {
    private int _ID;
    private int dependencyId;
    private String name;
    private String sortname;
    private String description;
    private boolean isEnabled;
    private boolean isSectorDefault;


    public Sector(int _ID, int dependencyId, String name, String sortname, String description,
                  boolean isEnabled, boolean isSectorDefault) {
        this._ID = _ID;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyId = dependencyId;
        this.isEnabled = isEnabled;
        this.isSectorDefault = isSectorDefault;
    }


    public Sector(int dependencyId, String name, String sortname, String description,
                  boolean isEnabled, boolean isSectorDefault) {
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyId = dependencyId;
        this.isEnabled = isEnabled;
        this.isSectorDefault = isSectorDefault;
    }


    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
        dependencyId = in.readInt();
        isEnabled = in.readByte() != 0;
        isSectorDefault = in.readByte() != 0;
    }


    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(sortname);
        dest.writeString(description);
        dest.writeInt(dependencyId);
        dest.writeByte((byte) (isEnabled ? 1 : 0));
        dest.writeByte((byte) (isSectorDefault ? 1 : 0));
    }


    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
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

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public boolean isSectorDefault() {
        return isSectorDefault;
    }

    public void setSectorDefault(boolean sectorDefault) {
        this.isSectorDefault = sectorDefault;
    }


    @Override
    public boolean equals(Object obj) {
        Sector sector = (Sector) obj;
        boolean result = false;

        if (sector._ID == _ID)
            result = true;

        return result;
    }
}
