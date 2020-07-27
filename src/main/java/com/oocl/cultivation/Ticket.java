package com.oocl.cultivation;

public class Ticket extends Message{
    private Car car = null;
    private Boolean isUsed = false;
    private Integer parkingLotId = null;

    public Ticket(Car car, String token) {

        this.car = car;
    }

    public Ticket(Car car, Integer parkingLotId) {
        this.car = car;
        this.parkingLotId = parkingLotId;
    }

    public Ticket() {
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
