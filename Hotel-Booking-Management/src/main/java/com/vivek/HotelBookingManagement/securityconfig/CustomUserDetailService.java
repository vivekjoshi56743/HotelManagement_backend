package com.vivek.HotelBookingManagement.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vivek.HotelBookingManagement.dao.User;
import com.vivek.HotelBookingManagement.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomUserDetails(user);
	}

}
