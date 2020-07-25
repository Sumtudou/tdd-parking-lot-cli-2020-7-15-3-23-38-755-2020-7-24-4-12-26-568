package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private Set<Car> parkingLotSet = new HashSet<>();
    private Integer maxSize;

    public ParkingLot(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Set<Car> getParkingLotSet() {
        return parkingLotSet;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setParkingLotSet(Set<Car> parkingLotSet) {
        this.parkingLotSet = parkingLotSet;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

}
