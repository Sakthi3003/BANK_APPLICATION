package com.bankapp.service;

import com.bankapp.entity.User;
import com.bankapp.repository.UserRepository;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void getAllUsers() {
        userRepository.getAllUsers();
    }

    public User login(String username, String password) {
        return  userRepository.login(username, password);
    }

    public boolean addCustomer(String username, String password, String contactNumber){
        return userRepository.addCustomer(username, password, contactNumber);
    }

    public Double checkBalance(String username) {
        return userRepository.checkBalance(username);
    }
}
