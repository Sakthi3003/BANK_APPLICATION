package com.bankapp.main;

import com.bankapp.entity.User;
import com.bankapp.service.UserService;

import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        UserService userService = new UserService();

        System.out.print("Enter username : ");
        String username = scan.nextLine();

        System.out.print("Enter password : ");
        String password = scan.nextLine();

        User user = userService.login(username, password);

        if(!(user == null)){
            System.out.println("Logged in Successfully");
        }else{
            System.out.println("Incorrect username or password");
        }
    }
}
