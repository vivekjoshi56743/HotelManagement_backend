package com.vivek.HotelBookingManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.HotelBookingManagement.dao.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
