package com.example.jaime.inventorydb.data.db.model;

/**
 * Created by usuario on 8/11/17.
 */

public class User {
    private int _ID;
    private String user;
    private String password;
    private String name;
    private String email;
    private boolean isRoot;
    private boolean isManager;


    public User(int _ID, String user, String password, String name, String email, boolean isRoot, boolean isManager) {
        this._ID = _ID;
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.isRoot = isRoot;
        this.isManager = isManager;
    }


    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }


    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj != null || getClass() == obj.getClass()) {
            User user = (User) obj;

            if (user.user == this.user)
                result = true;
            else if (user.email == this.email)
                result = true;
        }

        return result;
    }
}
