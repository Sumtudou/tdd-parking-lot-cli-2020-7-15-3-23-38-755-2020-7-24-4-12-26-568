package com.oocl.cultivation;

public class Ticket {
    private String carId;
    private String token;

    public Ticket(Car car, String token) {
        this.carId = car.getId();
        this.token = token;
    }

    public String getCarId() {
        return carId;
    }

    public String getToken() {
        return token;
    }
    //    public Car getCar() {
//        return null;
//    }
}
