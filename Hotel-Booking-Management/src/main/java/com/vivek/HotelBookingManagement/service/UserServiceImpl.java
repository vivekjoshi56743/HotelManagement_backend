package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.HotelBookingManagement.controller.UserRequest;
import com.vivek.HotelBookingManagement.dao.User;
import com.vivek.HotelBookingManagement.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;

	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return repo.findAll();

	}

	@Override
	public Optional<User> getuserbyid(Long user_id) {
		// TODO Auto-generated method stub
		return repo.findById(user_id);
	}

	@Override
	public ResponseEntity<User> adduser(User user) {
		// TODO Auto-generated method stub
		try {
			repo.findAll();
			User newuser = repo.save(user);
			return ResponseEntity.ok(newuser);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@Override
	public ResponseEntity<String> deleteuser(Long user_id) {
		// TODO Auto-generated method stub
		if (repo.existsById(user_id)) {
			repo.deleteById(user_id);
			return new ResponseEntity<>("User Deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("id not found", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<User> login(UserRequest user) {
		// TODO Auto-generated method stub
		try {
			User Dbuser=repo.findByUsername(user.getUsername());
			if(Dbuser==null) {
				return ResponseEntity.badRequest().build();
			}
			User storedUser = Dbuser;
		      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		      
		      if (passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
		        // Passwords match, user is authenticated
		        // Implement your logic for successful login here
		        // You can generate a JWT token or set session variables for authentication purposes
		    	  
		        return ResponseEntity.ok(storedUser);
		      
		      } else {
		        
		        return ResponseEntity.badRequest().build();
		      }
		    
		  } catch (Exception e) {
		    
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		  }
		
	}

}
