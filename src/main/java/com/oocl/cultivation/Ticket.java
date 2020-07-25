package com.oocl.cultivation;

public class Ticket {
    private String carId = null;
    private String token = null;
    private Car car = null;
    private Boolean isUsed = false;

    public Ticket(Car car, String token) {
        this.carId = car.getId();
        this.token = token;
        this.car = car;
    }

    public Ticket() {

    }


    public String getCarId() {
        return carId;
    }

    public String getToken() {
        return token;
    }

    public Car getCar() {
        if (!this.isUsed && this.car != null){

            isUsed = true;
            return car;
        }
        return null;
    }
}
