package com.cognizant.client.dto;

import java.io.Serializable;

public class PromotionalRule implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String promoCodeId;
    private String description;
    private Double discount;
    private String discountType;
    private String category;

    public String getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(String promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
