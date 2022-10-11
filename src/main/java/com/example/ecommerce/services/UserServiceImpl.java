package com.example.ecommerce.services;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {



    private final UserRepository userRepo;

    private final RoleRepository roleRepo;

    private final BCryptPasswordEncoder passwordEncoder;
    //UserDetailsService Override


    @Override
    public User saveUser(User user) {
        log.info("Saving user to the database {}",user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving {} role to the database ",role.getName());

        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        log.info("Saving user to the database {}",user.getUsername());

        user.getRoles().add(role);

    }

    @Override
    public User getUser(String userName) {
        log.info("getting user info",userName);

        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all users");

        return userRepo.findAll();

    }


}
