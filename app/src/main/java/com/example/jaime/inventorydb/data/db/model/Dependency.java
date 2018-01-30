package com.example.jaime.inventorydb.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

/**
 * Clase POJO de dependencias.
 */

public class Dependency implements Comparable, Parcelable {
    public static final Comparator<Dependency> COMPARATOR_ID = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency o1, Dependency o2) {
            int result = 0;

            if (o1.get_ID() > o2.get_ID())
                result = 1;
            else if (o1.get_ID() < o2.get_ID())
                result = -1;
            else if (o1.get_ID() == o2.get_ID())
                result = 0;

            return result;
        }
    };

    public static final Comparator<Dependency> COMPARATOR_NAME = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };


    private int _ID;
    private String name;
    private String shortname;
    private String description;
    private String image;


    public Dependency(int _ID, String name, String shortname, String description, String image) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.image = image;
    }


    protected Dependency(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        image = in.readString();
    }


    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
        dest.writeString(image);
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        Dependency dependency = (Dependency) obj;
        boolean result = false;

        if (name.equals(dependency.getName()))
            result = true;
        else if (shortname.equals(dependency.getShortname()))
            result = true;

        return result;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Dependency)o).getName());
    }


    @Override
    public int describeContents() {
        return 0;
    }


    public static class DependencyOrderByShortName implements Comparator<Dependency> {

        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getShortname().compareTo(o2.getShortname());
        }
    }
}
