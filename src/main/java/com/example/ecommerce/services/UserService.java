package com.example.ecommerce.services;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
