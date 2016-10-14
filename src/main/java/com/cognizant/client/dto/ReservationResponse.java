package com.cognizant.client.dto;

import java.io.Serializable;
import java.util.List;

public class ReservationResponse implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

	@Override
	public String toString() {
		return "ReservationResponse [reservations=" + reservations + "]";
	}

}
