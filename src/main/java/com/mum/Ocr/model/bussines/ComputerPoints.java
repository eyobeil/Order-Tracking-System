package com.mum.Ocr.model.bussines;

import java.io.Serializable;

public class ComputerPoints extends ACompPoints {
	
	private final double points=2.0;

	@Override
	public double getPoints() {
		return points;
	}

}
