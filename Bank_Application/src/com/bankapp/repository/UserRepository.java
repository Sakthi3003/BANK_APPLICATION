package com.bankapp.repository;

import com.bankapp.entity.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepository {

    // Using a Set to store users ensures that duplicate users are not allowed,
    // because each user should be unique in the system.
    // A HashSet is chosen for efficient lookup and insertion operations (O(1) average time).
    private static Set<User> users = new HashSet<>();


    // Using static block to initialize users
    static{
        User admin = new User("admin","admin@123", "9383932959", "admin", 0.0);
        User user1 = new User("Sahi", "sahi@123", "9434235312", "user",40000.0);
        User user2 = new User("Sara", "sara@123", "8647282384", "user", 50000.0);
        User user3 = new User("Akil", "akil@123", "7324909325", "user", 63000.0);

        users.add(admin);
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }


    public void getAllUsers() {
        for (User user : users) {
            System.out.println(user + "\n");
        }
    }


    public User login(String username, String password) {
        List<User> finalList = users
                .stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .toList();

        if (!finalList.isEmpty()) {
            return finalList.get(0);
        } else {
            return null;
        }
    }
}
