package com.mum.Ocr.model.bussines;

public enum CreditRating {
	POOR("POOR"), GOOD("GOOD"), EXCELLENT("EXCELLENT");
private String rate;

private CreditRating(String rate) {
	this.rate = rate;
}

public String getRate() {
	return rate;
}

public void setRate(String rate) {
	this.rate = rate;
}

}
