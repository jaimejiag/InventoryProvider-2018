package com.example.jaime.inventorydb.data.db.repository;

import com.example.jaime.inventorydb.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> users;


    private UserRepository() {
        users = new ArrayList<>();
        initialize();
    }


    public static UserRepository getInstance(){
        if (instance == null)
            instance = new UserRepository();

        return instance;
    }


    private void initialize() {
        addUser(new User(1, "jaime", "Jaime1", "Jaime",
                "jaime@gmail.com", true, true));

        addUser(new User(2, "julia", "julia", "Julia",
                "julia@gmail.com", false, false));

        addUser(new User(3, "paco", "nopaco", "Paco",
                "nopaco@gmail.com", false, true));
    }


    public void addUser(User user) {
        users.add(user);
    }


    public ArrayList<User> getUsers() {
        return users;
    }


    /**
     * Método que comprueba si un usuario existe en la base de datos.
     * @return
     */
    public boolean isUserExits(User user) {

        return true;
    }


    public boolean validateCredentials(String user, String password) {
        boolean result = false;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUser().equals(user) && users.get(i).getPassword().equals(password))
                result = true;
        }

        return result;
    }
}
