package com.vivek.HotelBookingManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.vivek.HotelBookingManagement.dao.User;

public interface UserService {

	List<User> getallUser();

	Optional<User> getuserbyid(Long user_id);

	ResponseEntity<User> adduser(User user);

	ResponseEntity<String> deleteuser(Long user_id);

}
