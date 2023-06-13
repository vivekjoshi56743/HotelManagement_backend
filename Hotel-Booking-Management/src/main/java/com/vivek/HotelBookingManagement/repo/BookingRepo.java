package com.vivek.HotelBookingManagement.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.HotelBookingManagement.dao.Booking;
import com.vivek.HotelBookingManagement.dao.Room;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

	//Optional<Booking> findByUser(User user);
	
	
	List<Booking> findByUser_UserId(Long user_id);
	
	List<Booking> findByStartDate(LocalDate start_date);
	
	List<Booking> findByRoomAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Room room, LocalDate endDate, LocalDate startDate);
	

}
