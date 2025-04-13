package com.mycompany.registration;

import java.util.Scanner;

public class Registration {
   private String registeredUsername;
    private String registeredPassword;
    private String registeredPhoneNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();

        System.out.println("Welcome to Whatsapp,this is where you register!");

        registration.checkUserName(scanner);
        registration.checkPasswordComplexity(scanner);
        registration.checkCellPhoneNumber(scanner);

        System.out.println("\nNow let's log you in...");
        registration.loginUser(scanner);

        scanner.close();
    }

    public void checkUserName(Scanner scanner) {
        while (true) {
            System.out.print("Create a Username: ");
            String username = scanner.nextLine();

            if (username.length() <= 5 && username.contains("_")) {
                System.out.println("Username successfully captured.");
                registeredUsername = username;
                break;
            } else {
                System.out.println("Username is not correctly formatted!\n"
                        + "Please ensure that your username contains an underscore (_) and is no more than 5 characters in length.\n");
            }
        }
    }

    public void checkPasswordComplexity(Scanner scanner) {
        while (true) {
            System.out.print("Create a Password (at least 8 characters, 1 capital letter, 1 number, 1 special character): ");
            String password = scanner.nextLine();

            if (password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()].*")) {

                System.out.println("Password successfully captured.");
                registeredPassword = password;
                break;
            } else {
                System.out.println("Password is not correctly formatted!\n"
                        + "Ensure it has at least 8 characters, one uppercase letter, one number, and one special character.\n");
            }
        }
    }

    public void checkCellPhoneNumber(Scanner scanner) {
        while (true) {
            System.out.print("Enter your South African cell phone number (must start with +27 or 27 and be exactly 10 digits long): ");
            String phoneNumber = scanner.nextLine();

            String cleanedNumber = phoneNumber.startsWith("+") ? phoneNumber.substring(1) : phoneNumber;

            if (cleanedNumber.matches("27\\d{9}")) {
                System.out.println("Phone number successfully captured.");
                registeredPhoneNumber = cleanedNumber;
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }
    }

    public void loginUser(Scanner scanner) {
        while (true) {
            System.out.print("Enter your username to login: ");
            String inputUsername = scanner.nextLine();

            System.out.print("Enter your password to login: ");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(registeredUsername) && inputPassword.equals(registeredPassword)) {
                System.out.println("Login successful. Welcome back, " + registeredUsername + "!");
                break;
            } else {
                System.out.println("Login failed. Username or password is incorrect. Please try again.\n");
            }
        }
    }
}


