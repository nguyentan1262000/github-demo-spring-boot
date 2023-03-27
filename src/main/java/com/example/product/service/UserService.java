package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void save(User user);
    User getById(Integer id);
    void deleteViaId(Integer id);
    boolean check_user(User user);
    void update(Integer id, User user);
}
