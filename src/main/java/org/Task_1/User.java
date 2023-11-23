package org.Task_1;

public class User {

    public String name;
    String password;
    boolean isAdmin;
    public boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (this.name == name && this.password == password) {
            this.isAuthenticate = true;
            return true;
        }
        return false;
    }

}
