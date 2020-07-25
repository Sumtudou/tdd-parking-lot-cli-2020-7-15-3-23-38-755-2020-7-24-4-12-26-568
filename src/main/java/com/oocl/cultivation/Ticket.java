package com.oocl.cultivation;

public class Ticket extends Message{
    private String carId = null;
    private String token = null;
    private Car car = null;
    private Boolean isUsed = false;
    private Integer parkingLotId = null;

    public Ticket(Car car, String token) {
        this.carId = car.getId();
        this.token = token;
        this.car = car;
    }

    public Ticket(Car car, String token,Integer parkingLotId) {
        this.carId = car.getId();
        this.token = token;
        this.car = car;
        this.parkingLotId = parkingLotId;
    }

    public Ticket() {
    }

    public String getCarId() {
        return carId;
    }

    public String getToken() {
        return token;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public Car getCar() {
        return car;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
