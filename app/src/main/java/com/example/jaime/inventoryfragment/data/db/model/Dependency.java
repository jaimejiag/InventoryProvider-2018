package com.example.jaime.inventoryfragment.data.db.model;

import java.util.Comparator;

/**
 * Clase POJO de dependencias.
 */

public class Dependency implements Comparable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;


    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
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


    @Override
    public String toString() {
        return "Dependency{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        Dependency dependency = (Dependency) obj;
        boolean result = true;

        if (name.equals(dependency.getName()))
            result = false;
        else if (shortname.equals(dependency.getShortname()))
            result = false;

        return result;
    }


    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Dependency)o).getName());
    }


    public static class DependencyOrderByShortName implements Comparator<Dependency> {

        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getShortname().compareTo(o2.getShortname());
        }
    }
}
