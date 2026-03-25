package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.User;
import com.abhi.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminUserController {

	 private final UserRepository userRepository;

	    // Get all users
	    @GetMapping("/users")
	    public List<User> getAllUsers(){
	        return userRepository.findAll();
	    }

	    // Get all admins
	    @GetMapping("/admins")
	    public List<User> getAllAdmins(){
	        return userRepository.findAll()
	                .stream()
	                .filter(u -> u.getRole().name().equals("ADMIN"))
	                .toList();
	    }

	    // Get all staff
	    @GetMapping("/staff")
	    public List<User> getAllStaff(){
	        return userRepository.findAll()
	                .stream()
	                .filter(u -> u.getRole().name().equals("STAFF"))
	                .toList();
	    }
}