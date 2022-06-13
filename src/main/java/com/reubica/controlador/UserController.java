package com.reubica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.reubica.entidad.User;
import com.reubica.interfaces.Status;
import com.reubica.interfaces.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
	
@Controller
public class UserController {
	
	
	
    @Autowired
    UserRepository userRepository;
    
    public Cookie cookie;
    
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }
    
    @PostMapping("/validacion/login")
    public String loginUser(@Valid User user, Model modelos, HttpServletResponse response) throws IOException {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                modelos.addAttribute("users", users);

                cookie = new Cookie("Alex", "admin");
                cookie.setMaxAge(60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);

                


                return "redirect:/administrar/protectoras";

            }
        }

        return "redirect:/";
    }
    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}