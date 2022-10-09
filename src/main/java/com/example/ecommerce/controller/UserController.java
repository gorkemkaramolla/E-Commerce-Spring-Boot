package com.example.ecommerce.controller;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
      return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/user/get/{}")
    public ResponseEntity<User> getUser(@RequestParam String username){
      return ResponseEntity.ok().body(userService.getUser(username));
    }
    @PostMapping("/user/save")
    public ResponseEntity saveUser(@RequestBody User user)
    {
        return ResponseEntity.created(null).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity saveRole(@RequestBody Role role)
    {
        return ResponseEntity.created(null).body(userService.saveRole(role));
    }
}
