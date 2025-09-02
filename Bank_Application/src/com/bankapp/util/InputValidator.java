package com.bankapp.util;

import java.util.Scanner;

public class InputValidator {
    public static String validateString(Scanner scan, String message){
        String input = "";
        while(input.isEmpty()){
            System.out.print(message);
            input = scan.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Value cannnot be empty");
            }
        }

        return input;
    }
}
