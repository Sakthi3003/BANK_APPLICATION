package com.bankapp.main;

import com.bankapp.entity.User;
import com.bankapp.service.UserService;
import com.bankapp.util.InputValidator;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static final Main main = new Main();
    private static final UserService userService = new UserService();

    public static void main(String[] args) {

        while(true) {
            System.out.println("***********************************");
            System.out.println("Welcome to the Banking Application");
            System.out.println("***********************************");
            String username = InputValidator.validateString(scan, "Enter username : ");
            
            String password = InputValidator.validateString(scan, "Enter username : ");

            User user = userService.login(username, password);



            if (!(user == null) && user.getRole().equalsIgnoreCase("admin")) {
                main.initAdmin();
            } else if (!(user == null) && user.getRole().equalsIgnoreCase("user")) {
                main.initUser(user);
            } else {
                System.out.println("Login Failed!. Incorrect username or password");
            }
        }
    }

    private void initAdmin(){
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("1. Exit/Logout");
            System.out.println("2. Create a customer account");

            int selectedOptions = scan.nextInt();
            scan.nextLine();
            switch (selectedOptions) {
                case 1 -> {
                    isRunning = false;
                    System.out.println("Logged Out Successfully!");
                    break;
                }
                case 2 -> addNewCustomer();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void initUser(User user){
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("1. Exit/Logout");
            System.out.println("2. Check Balance");
            System.out.println("3. Fund Transfer");
            

            int selectedOptions = scan.nextInt();
            scan.nextLine();
            switch (selectedOptions) {
                case 1 -> {
                    isRunning = false;
                    System.out.println("Logged Out Successfully!");
                    break;
                }
                case 2 -> {
                    Double balance = userService.checkBalance(user.getUsername());
                    if(balance != null){
                        System.out.println("Balance : " + balance);
                    }
                    System.out.println("Check your Username and try again");
                    break;
                }
                case 3 -> main.transferFund(user);
                default -> System.out.println("Invalid choice");
            }
        }

    }

    private void transferFund(User payer) {
        String payeeName = InputValidator.validateString(scan, "Enter payee user id : ");

        User payee = userService.getUser(payeeName);
        if(payee != null){
            System.out.println("Enter Amount to transfer : ");
            double amount = scan.nextDouble();

            double payerBalance = checkBalance(payer.getUsername());

            if(payerBalance >= amount){
                Boolean isTransferSuccessful = userService.transferFunds(payer.getUsername(), payee.getUsername(), amount);
                if(isTransferSuccessful){
                    System.out.println("Transaction success");
                }else{
                    System.out.println("Transaction failed");
                }
            }else{
                System.out.println("Insufficient funds");
            }

        }else{
            System.out.println("Payee account not found");
        }
    }

    private void getUser(String userId){
        userService.getUser(userId);
    }

    private double checkBalance(String username) {
        return userService.checkBalance(username);
    }

    public void addNewCustomer(){
        System.out.print("Enter Username : ");
        String username = scan.nextLine();

        System.out.print("Enter Password : ");
        String password = scan.nextLine();

        System.out.print("Enter contact number : ");
        String contactNumber = scan.nextLine();

        if(userService.addCustomer(username, password, contactNumber)){
            System.out.println("Customer Account created Successfully");
        }else{
            System.out.println("Account creation failed!");
        }
    }


}
