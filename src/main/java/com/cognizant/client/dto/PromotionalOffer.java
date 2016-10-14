package com.cognizant.client.dto;

import java.io.Serializable;
import java.util.List;

public class PromotionalOffer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PromotionalRule> promos;
    private String loyaltyCode;

    public List<PromotionalRule> getRules() {
        return promos;
    }

    public void setRules(List<PromotionalRule> rules) {
        this.promos = rules;
    }

    public String getLoyaltyCode() {
        return loyaltyCode;
    }

    public void setLoyaltyCode(String loyaltyCode) {
        this.loyaltyCode = loyaltyCode;
    }
}
