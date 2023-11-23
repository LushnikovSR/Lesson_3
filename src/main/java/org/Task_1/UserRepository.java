package org.Task_1;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    public static List<User> data = new ArrayList<>();

    public static void addUser(User user) {
        if (user.isAuthenticate == true){
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void unlogAllUsersExceptAdministrators(){
        for (User user: data) {
            if (user.isAdmin == false) {
                user.isAuthenticate = false;
            }
        }
    }

}
