package com.company.test;

import com.company.domain.Payment;
import com.company.domain.User;
import com.company.repositories.UserRepository;

public class UserRepositoryTest {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user1 = new User("Carlos", "2008123", "(85) 98743-1234", "carlos@gmail.com");
        User user2 = new User("Jhonny", "3556789", "(85) 98556-5230", "jhonny@gmail.com");
        User user3 = new User("Hellen", "7002654", "(85) 95565-7855", "hellen@gmail.com");

        //Register
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);

        //Search
        userRepository.findByName("Carlos");
        userRepository.findByDocument("3556789");

        //Delete
        userRepository.deleteByDocument("3556789");

        //Payment
        Payment payment = new Payment("Credit card", "Payment made!");
        System.out.println(payment);
    }
}