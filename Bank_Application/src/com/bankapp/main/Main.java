package com.bankapp.main;

import com.bankapp.entity.User;
import com.bankapp.service.UserService;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static final Main main = new Main();
    private static final UserService userService = new UserService();
    public static void main(String[] args) {

        while(true) {
            System.out.print("Enter username : ");
            String username = scan.nextLine();

            System.out.print("Enter password : ");
            String password = scan.nextLine();

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
                default -> System.out.println("Invalid choice");
            }
        }

    }

    private void checkBalance(String username) {
        userService.checkBalance(username);
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
