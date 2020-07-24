package com.oocl.cultivation;

public class Ticket {
    private String carId;
    private String token;

    public Ticket(Car car, String token) {
        this.carId = car.getId();
        this.token = token;
    }

    //    public Car getCar() {
//        return null;
//    }
}
