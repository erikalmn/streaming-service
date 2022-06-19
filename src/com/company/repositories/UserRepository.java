package com.company.repositories;

import com.company.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private List<User> userDataBase = new ArrayList<>();

    public UserRepository() {
        userBase();
    }

    public boolean addUser(User newUser) {
        boolean result = userDataBase.add(newUser);
        if(result) {
            System.out.println("\nUser successfully added!");
            return result;
        }
        System.out.println("\nError! User not added!");
        return false;
    }

    //Research
    public List<User> findByName(String name) {
        name = name.toLowerCase();

        List<User> effect = new ArrayList<>();
        for(User user : userDataBase) {
            String nameUser = user.getName().toLowerCase();
            if(nameUser.contains(name)) {
                effect.add(user);
            }
        }
        if(effect.isEmpty()) {
            System.out.println("\nUser not found!");
            return new ArrayList<>();
        }
        System.out.println("\nUser found!");
        return effect;
    }

    public User findByDocument(String document) {
        for(User user : userDataBase) {
            if(document.equalsIgnoreCase(user.getDocument())) {
                System.out.println("\nSuccessfully!");
                return user;
            }
        }
        System.out.println("\nNot found! Try again...");
        return null;
    }

    //Update
    public boolean updateUser(User userUpdated, String document) {
        User userCurrent = findByDocument(document);
        if(Objects.isNull(userCurrent)) {
            System.out.println("\nUser not found for update!");
            return false;
        }
        String newName = userUpdated.getName();
        String newDocument = userUpdated.getDocument();
        String newPhone = userUpdated.getPhone();
        String newEmail = userUpdated.getEmail();

        if(isValidString(newName)) {
            userCurrent.setName(newName);
        }
        if(isValidString(newDocument)) {
            userCurrent.setDocument(newDocument);
        }
        if(isValidString(newPhone)) {
            userCurrent.setPhone(newPhone);
        }
        if(isValidString(newEmail)) {
            userCurrent.setEmail(newEmail);
        }
        System.out.println("\nUser updated successfully!");
        return true;
    }

    //Delete
    public boolean deleteByDocument(String document) {
        User user = findByDocument(document);
        return userDataBase.remove(user);
    }

    private void userBase() {
        User user1 = new User("Carlos", "2008123", "(85) 98743-1234", "carlos@gmail.com");
        User user2 = new User("Jhonny", "3556789", "(85) 98556-5230", "jhonny@gmail.com");
        User user3 = new User("Hellen", "7002654", "(85) 95565-7855", "hellen@gmail.com");

        userDataBase.add(user1);
        userDataBase.add(user2);
        userDataBase.add(user3);
    }

    private boolean isValidString(String value) {
        return value != null && !value.isBlank();
    }
}