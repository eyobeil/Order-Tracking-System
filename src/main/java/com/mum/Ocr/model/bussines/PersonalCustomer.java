package com.mum.Ocr.model.bussines;

import java.io.Serializable;

import com.mum.Ocr.model.Customer;

public class PersonalCustomer extends Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7020858490885842412L;
	private String rating = "POOR";
	private String creditcardno;

	

	public String getCreditcardno() {
		return creditcardno;
	}

	

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setCreditcardno(String creditcardno) {
		this.creditcardno = creditcardno;
	}
	
	
	
}
