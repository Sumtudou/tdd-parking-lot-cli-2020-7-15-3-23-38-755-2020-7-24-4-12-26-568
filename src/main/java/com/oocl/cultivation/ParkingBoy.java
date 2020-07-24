package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingBoy {

    public Ticket parkCar(Car car, String token) {
        return new Ticket(car, token);
    }
    public Car getCar(Ticket ticket){
        return null;
    }


}
