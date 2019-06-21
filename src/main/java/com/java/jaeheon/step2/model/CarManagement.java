package com.java.jaeheon.step2.model;

import java.util.List;

public class CarManagement {
	private final List<Car> cars;

	public CarManagement(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCarsList() {
		return cars;
	}

	public long getCarsSize() {
		return cars.size();
	}

}
