package com.bankapp.service;

import com.bankapp.entity.User;
import com.bankapp.repository.UserRepository;

import java.util.List;
import java.util.Map;

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

    public User getUser(String userId){
        return userRepository.getUser(userId);
    }

    public Boolean transferFunds(String payerName, String payeeName, Double amount) {
        return userRepository.transferFunds(payerName, payeeName, amount);
    }

    public void seeAllTransactionHistory(String username) {
        userRepository.seeAllTransactionHistory(username);
    }

    public void showAllTransaction() {
        userRepository.showAllTransaction();
    }

    public void raiseCheckBookRequest(String userId){
        userRepository.raiseCheckBookRequest(userId);
    }

    public Map<String, Boolean> getAllCheckBookRequest(){
        return userRepository.getAllCheckBookRequest();
    }

    public List<String> getAllUserIdForCheckBookRequestApproval() {
       return userRepository.getAllUserIdForCheckBookRequestApproval();
    }

    public void approveCheckBookRequest(String userID){
        userRepository.approveCheckBookRequest(userID);
    }
}
