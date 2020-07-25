package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private Set<Car> parkingLotSet = new HashSet<>();
    private Integer maxSize;

    public ParkingLot(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Ticket lotParkCar(Car car, String token) {
        if (parkingLotSet.size() < maxSize && !parkingLotSet.contains(car)) {
            parkingLotSet.add(car);
            return new Ticket(car, token);
        }
        return null;
    }
}
