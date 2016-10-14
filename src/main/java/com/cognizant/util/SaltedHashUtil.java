package com.cognizant.util;

public class SaltedHashUtil {

	public String generateSaltedHash(final String password){
		System.out.println("we have recvd a value = " + password);
		return password + "SaltedHash";
	}
}
