package com.vivek.HotelBookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.HotelBookingManagement.dao.User;
import com.vivek.HotelBookingManagement.service.UserService;



@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AuthController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/login")
	ResponseEntity<User> login(@RequestBody UserRequest user){
		return service.login(user);
		
	}
	
}
