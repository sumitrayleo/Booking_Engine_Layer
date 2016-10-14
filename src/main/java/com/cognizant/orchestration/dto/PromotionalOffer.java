package com.cognizant.orchestration.dto;

import java.util.List;

public class PromotionalOffer {

	private List<PromotionalRule> rules;
	private String loyaltyCode;
	
	public List<PromotionalRule> getRules() {
		return rules;
	}
	public void setRules(List<PromotionalRule> rules) {
		this.rules = rules;
	}
	public String getLoyaltyCode() {
		return loyaltyCode;
	}
	public void setLoyaltyCode(String loyaltyCode) {
		this.loyaltyCode = loyaltyCode;
	}
	
}
