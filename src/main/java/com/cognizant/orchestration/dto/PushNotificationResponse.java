package com.cognizant.orchestration.dto;

import java.util.List;

public class PushNotificationResponse {

	private String memberId;
	private List<Reservation> reservations;
	//private NearbyAirport nearbyAirport;//@TODO - This will be handled later on.
	private List<PointOfInterest> poi;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<PointOfInterest> getPoi() {
		return poi;
	}
	public void setPoi(List<PointOfInterest> poi) {
		this.poi = poi;
	}
	
}
