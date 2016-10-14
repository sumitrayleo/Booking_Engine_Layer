package com.cognizant.client.dto;

public class PointOfInterest {
	
	private String name;
    private String specialInstructions;
    private DistanceDetails driveDistanceDetails;
    private PromotionalOffer promotionalOffers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public DistanceDetails getDriveDistanceDetails() {
        return driveDistanceDetails;
    }

    public void setDriveDistanceDetails(DistanceDetails driveDistanceDetails) {
        this.driveDistanceDetails = driveDistanceDetails;
    }

    public PromotionalOffer getPromotionalOffers() {
        return promotionalOffers;
    }

    public void setPromotionalOffers(PromotionalOffer promotionalOffers) {
        this.promotionalOffers = promotionalOffers;
    }

	@Override
	public String toString() {
		return "PointOfInterest [name=" + name + ", specialInstructions=" + specialInstructions
				+ ", driveDistanceDetails=" + driveDistanceDetails + ", promotionalOffers=" + promotionalOffers + "]";
	}
}
