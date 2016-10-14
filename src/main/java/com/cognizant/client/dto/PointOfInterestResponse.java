package com.cognizant.client.dto;

import java.io.Serializable;
import java.util.List;

public class PointOfInterestResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PointOfInterest> pointsOfInterest;

	public List<PointOfInterest> getPointOfInterests() {
		return pointsOfInterest;
	}

	public void setPointOfInterests(List<PointOfInterest> pointOfInterests) {
		this.pointsOfInterest = pointOfInterests;
	}

	@Override
	public String toString() {
		return "PointOfInterestResponse [pointsOfInterest=" + pointsOfInterest + "]";
	}

}
