package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingBoy {

    public Ticket parkCar(Car car, String token) {
        return new Ticket(car, token);
    }
    public Car getOutCar(Ticket ticket){
        return ticket.getCar();
    }


}
