package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingBoy {

    private ParkingLot parkingLot = null;


    public ParkingBoy(Integer maxSize) {
        buildParkingLot(maxSize);
    }


    public ParkingLot buildParkingLot(Integer maxSize) {
        this.parkingLot = new ParkingLot(maxSize);
        return parkingLot;
    }


    public Ticket parkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        Set<Car> parkingLotSet = parkingLot.getParkingLotSet();
        if (car == null || token == null)
            return null;
        if (parkingLotSet.size() < parkingLot.getMaxSize()) {
            if (!parkingLotSet.contains(car)) {
                parkingLotSet.add(car);
                parkingLot.setParkingLotSet(parkingLotSet);
                return new Ticket(car, token);
            }
        }else{
            errTicket.setErrMsg("Not enough position.");
            return errTicket;
        }
        return null;
    }

    public Car getOutCar(Ticket ticket) {
        Car errorCar = new Car();
        if (ticket == null) {
            errorCar.setErrMsg("Please provide your parking ticket.");
            return errorCar;
        }
        if (ticket.getUsed() || ticket.getCar() == null) {
            errorCar.setErrMsg("Unrecognized parking ticket.");
            return errorCar;
        }

        Car car = ticket.getCar();
        Set<Car> parkingLotSet = parkingLot.getParkingLotSet();
        if (parkingLotSet.contains(car)) {  //this car is in parkingLot
            parkingLotSet.remove(car);
            parkingLot.setParkingLotSet(parkingLotSet);
            ticket.setUsed(true);
            return car;
        } else {
            errorCar.setErrMsg("This car has been stolen");
            return errorCar;
        }
    }


}
