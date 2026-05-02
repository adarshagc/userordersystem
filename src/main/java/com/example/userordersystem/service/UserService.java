package com.example.userordersystem.service;

import com.example.userordersystem.model.User;
import com.example.userordersystem.model.Order;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {


    private Map<Integer, User> cache = new HashMap<>();

    public User getUser(int id) {


        if (cache.containsKey(id)) {
            System.out.println("Fetching from Cache");
            return cache.get(id);
        }

        System.out.println("Fetching from Database");

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Mobile"));
        orders.add(new Order(2, "Laptop"));

        User user = new User(id, "Yash", orders);

        cache.put(id, user);

        return user;
    }
}