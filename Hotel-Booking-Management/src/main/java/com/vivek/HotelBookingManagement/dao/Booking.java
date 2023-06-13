package com.vivek.HotelBookingManagement.dao;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Long bookingId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
//	@ManyToOne(fetch = FetchType.LAZY)
// 	@JoinColumn(name = "hotel_id", nullable = false)
//  private Hotels hotel;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@Column(name = "is_cancelled", nullable = false)
	private Boolean isCancelled;
	

	public Booking() {
		super();
	}

	public Booking(Long booking_id, Room room, User user, LocalDate startDate, LocalDate endDate, Boolean isCancelled) {
		super();
		this.bookingId = booking_id;
		this.room = room;
		this.user = user;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isCancelled = isCancelled;
	}

	public Long getBooking_id() {
		return bookingId;
	}

	public void setBooking_id(Long booking_id) {
		this.bookingId = booking_id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsCancelled() {
		return isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + bookingId + ", room=" + room + ", user=" + user + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", isCancelled=" + isCancelled + "]";
	}

	

}