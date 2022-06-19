package com.company;

import com.company.domain.User;
import com.company.repositories.UserRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainUser {
    private static Scanner sc = new Scanner(System.in);
    private static UserRepository userRepository = new UserRepository();
    private static boolean control = true;
    private static int menu = -1;

    public static void main(String[] args) {
        while(control) {
            optionsMenu();
            collectOptionsMenu();

            switch(menu) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    exit();
                    break;
            }
        }
    }

    private static void collectOptionsMenu() {
        boolean assistant = true;
        while(assistant) {
            try {
                menu = sc.nextInt();
                sc.nextLine();
                assistant = false;
            } catch(InputMismatchException e) {
                System.out.println("Invalid value!");
                sc.nextLine();
            }
        }
    }

    private static void optionsMenu() {
        System.out.println("1 - Register");
        System.out.println("2 - Search");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
        System.out.println("5 - Exit");
        System.out.println("");
        System.out.print("Choose a menu alternative: ");
    }

    private static void deleteUser() {
        System.out.println();
        System.out.println("Delete user");
        System.out.print("Enter user document: ");
        String document = sc.nextLine();
        userRepository.deleteByDocument(document);

        System.out.println("\nClick ENTER to go back...");
        sc.nextLine();
    }

    private static void updateUser() {
        System.out.println();
        System.out.println("Update user");
        System.out.print("Enter user document: ");
        String documentUp = sc.nextLine();

        System.out.print("- Enter the new name: ");
        String nameNew = sc.nextLine();

        System.out.print("- Enter the new document: ");
        String documentNew = sc.nextLine();

        System.out.print("- Enter the new phone: ");
        String phoneNew = sc.nextLine();

        System.out.print("- Enter the new email: ");
        String emailNew = sc.nextLine();

        User userUpdate = new User(nameNew, documentNew, phoneNew, emailNew);
        userRepository.updateUser(userUpdate, documentUp);

        System.out.println();
        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void registerUser() {
        System.out.println();
        System.out.println("Register user");

        System.out.print("- Enter the name: ");
        String name = sc.nextLine();

        System.out.print("- Enter the document: ");
        String document = sc.nextLine();

        System.out.print("- Enter the phone: ");
        String phone = sc.nextLine();

        System.out.print("- Enter the e-mail: ");
        String email = sc.nextLine();

        User newUser = new User(name, document, phone, email);
        userRepository.addUser(newUser);

        System.out.println();
        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void searchUser() {
        System.out.println();
        System.out.println("Search user");
        System.out.print("Enter the name user: ");
        String name = sc.nextLine();

        List<User> users = userRepository.findByName(name);

        if(!users.isEmpty()) {
            for(User user : users) {
                System.out.println(user);
            }
        }
        System.out.println();
        System.out.println("Click ENTER to go back...");
        sc.nextLine();
    }

    private static void exit() {
        System.out.println("\nShutting down system...");
        sc.close();
        MainUser.control = false;
    }
}