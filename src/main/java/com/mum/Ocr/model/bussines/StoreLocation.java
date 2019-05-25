package com.mum.Ocr.model.bussines;

public enum StoreLocation{
	STOKE("STOKE"),STORE("STORE");
	
	String douboeVal;

	private StoreLocation(String d) {
		this.douboeVal = d;
	}

	public String getD() {
		return douboeVal;
	}
}
