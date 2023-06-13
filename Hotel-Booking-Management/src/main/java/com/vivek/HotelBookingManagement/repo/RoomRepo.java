package com.vivek.HotelBookingManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.HotelBookingManagement.dao.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

	List<Room> findByHotel_HotelId(Long hotel_id);

}
