package com.vivek.HotelBookingManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.HotelBookingManagement.dao.User;
import com.vivek.HotelBookingManagement.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/user")
	public List<User> getalluser(){
		return service.getallUser();
	}
	
	@GetMapping("/user/{user_id}")
	public Optional<User> getUserById(@PathVariable Long user_id){
		return service.getuserbyid(user_id);
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User user2 = new User();
		user2.setUsername(userRequest.getUsername());
	    user2.setPassword(passwordEncoder.encode(userRequest.getPassword()).toString());
	    user2.setRoles("user");
		return service.adduser(user2);
	}
	
	@DeleteMapping("/user/delete/{user_id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long user_id){
		return service.deleteuser(user_id);
	}
	
}
