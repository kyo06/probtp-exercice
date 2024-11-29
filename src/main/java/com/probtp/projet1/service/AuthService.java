package com.probtp.projet1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.probtp.projet1.config.JwtTokenProvider;
import com.probtp.projet1.dto.LoginDto;
import com.probtp.projet1.dto.RegisterDto;
import com.probtp.projet1.model.User;
import com.probtp.projet1.dao.UserDao;
import com.probtp.projet1.model.Role;
import com.probtp.projet1.dao.RoleDao;
import com.probtp.projet1.model.RoleEnum;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public String login(LoginDto loginDto) {

        // 01 - AuthenticationManager is used to authenticate the user
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()
        ));

        /* 02 - SecurityContextHolder is used to allows the rest of the application to know
        that the user is authenticated and can use user data from Authentication object */
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 03 - Generate the token based on username and secret key
        String token = jwtTokenProvider.generateToken(authentication);

        // 04 - Return the token to controller
        return token;
    }

    public User register(RegisterDto registerDto) {
        // Create new user from register DTO
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());

        // Encode password using BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
        user.setPassword(encodedPassword);

        // Save user to database
        User savedUser = userDao.save(user);

        // Set user role by default
        Role userRole = roleDao.findByName(RoleEnum.USER.toString()).get();
        savedUser.getRoles().add(userRole);
        savedUser = userDao.save(savedUser);

        return savedUser;
    }
}