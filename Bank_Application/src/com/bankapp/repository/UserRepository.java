package com.bankapp.repository;

import com.bankapp.entity.Transaction;
import com.bankapp.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepository {

    // Using a Set to store users ensures that duplicate users are not allowed,
    // because each user should be unique in the system.
    // A HashSet is chosen for efficient lookup and insertion operations (O(1) average time).
    private static Set<User> users = new HashSet<>();

    private static List<Transaction>  transactions = new ArrayList<>();


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

    public boolean addCustomer(String username, String password, String contactNumber){
        User user = new User(username, password, contactNumber, "user", 0.0);
        return users.add(user);
    }

    public Double checkBalance(String username) {
        List<User> result = users
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .toList();
        if(!result.isEmpty()){
            return result.get(0).getAccountBalance();
        }else {
            return null;
        }
    }

    public User getUser(String userId){
        List<User> list = users
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(userId))
                .toList();

        return !users.isEmpty() ? list.get(0) : null;
    }

    public boolean transferFunds(String payerName, String payeeName, Double amount) {
        boolean isDebited = debit(payerName, amount, payeeName);
        boolean isCredited = credit(payeeName, amount, payerName);

        System.out.println(transactions);

        return isDebited && isCredited;
    }

    public boolean debit(String payerName, double amount, String payeeName){
        User payer = getUser(payerName);

        double accountBalance = payer.getAccountBalance();
        users.remove(payer);

        double updatedBalance = accountBalance - amount;
        payer.setAccountBalance(updatedBalance);

        Transaction transaction = new Transaction(
                LocalDate.now(),
                payeeName,
                amount,
                "debit",
                accountBalance,
                updatedBalance,
                payerName
        );

        transactions.add(transaction);


        return users.add(payer);
    }

    public boolean credit(String payeeName, double amount, String payerName){
        User payee = getUser(payeeName);

        double accountBalance = payee.getAccountBalance();
        users.remove(payee);

        double updatedBalance = accountBalance + amount;
        payee.setAccountBalance(updatedBalance);

        Transaction transaction = new Transaction(
                LocalDate.now(),
                payerName,
                amount,
                "credit",
                accountBalance,
                updatedBalance,
                payeeName
        );

        transactions.add(transaction);
        return users.add(payee);
    }
}
