package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.model.User;
import com.example.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIplm implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void deleteViaId(Integer id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }else {
            System.out.println("khong xoa duoc");
        }
    }

    @Override
    public boolean check_user(User user) {
        List<User> userList = repository.findAll();
        for (User i:userList) {
            if(i.getUsername().equals(user.getUsername())){
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(Integer id, User user) {
        if(user != null) {
            User user1 = repository.getById(id);

            user1.setPassword(user.getPassword());
            user1.setEmail(user1.getEmail());
            user1.setUsername(user1.getUsername());
            user1.setProducts(user1.getProducts());

            repository.save(user1);
        }else {
            System.out.println("khong ton tai san pham");
        }
    }
}
