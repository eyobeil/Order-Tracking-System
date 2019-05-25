package com.mum.Ocr.model.bussines;

public enum ProductType{
COMPUTER("COMPUTER"),HEALTH("HEALTH"),AUDIOVIDEO("AUDIOVIDEO"),OTHER("OTHER");
String douboeVal;

private ProductType(String d) {
	this.douboeVal = d;
}

public String getD() {
	return douboeVal;
}

}
