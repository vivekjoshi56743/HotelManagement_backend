package com.vivek.HotelBookingManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.HotelBookingManagement.dao.Hotels;

@Repository
public interface HotelsRepo extends JpaRepository<Hotels,Long>{

}
