package com.probtp.projet1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.probtp.projet1.dao.RoleDao;
import com.probtp.projet1.model.Role;
import com.probtp.projet1.model.RoleEnum;
import com.probtp.projet1.model.User;
import com.probtp.projet1.dao.UserDao;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        // Get all existing roles from RoleEnum
        for (RoleEnum roleEnum : RoleEnum.values()) {
            // Check if role exists
            if (roleDao.findByName(roleEnum.toString()).isEmpty()) {
                // Create and save new role if it doesn't exist
                Role newRole = new Role();
                newRole.setName(roleEnum.toString());
                roleDao.save(newRole);
            }
        }

        // Create admin user if not exists
        if (userDao.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode("admin");
            admin.setPassword(encodedPassword);            
            admin = userDao.save(admin);
            Role adminRole = roleDao.findByName(RoleEnum.ADMIN.toString()).get();
            admin.setRoles(Set.of(adminRole));
            admin = userDao.save(admin);
        }

        // Create user user if not exists
        if (userDao.findByUsername("user").isEmpty()) {
            User user = new User();
            user.setUsername("user");
            user.setEmail("user@example.com");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode("user");
            user.setPassword(encodedPassword);
            user = userDao.save(user);
            Role userRole = roleDao.findByName(RoleEnum.USER.toString()).get();
            user.setRoles(Set.of(userRole));
            user = userDao.save(user);
        }   
    }
}
