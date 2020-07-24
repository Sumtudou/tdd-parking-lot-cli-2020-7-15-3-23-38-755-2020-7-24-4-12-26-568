package com.oocl.cultivation;

public class Ticket {
    private String carId;
    private String token;
    private Car car;
    public Ticket(Car car, String token) {
        this.carId = car.getId();
        this.token = token;
        this.car = car;
    }

    public String getCarId() {
        return carId;
    }

    public String getToken() {
        return token;
    }

    public Car getCar() {
        return car;
    }
}
