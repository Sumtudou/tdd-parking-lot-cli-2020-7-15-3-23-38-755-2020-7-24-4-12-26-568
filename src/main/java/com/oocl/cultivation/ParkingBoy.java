package com.oocl.cultivation;

import java.lang.reflect.Array;
import java.util.*;

public class ParkingBoy {
    //private ParkingLot parkingLot = null;
    protected List<ParkingLot> parkingLotList;

    public ParkingBoy(Integer[] maxSizeArr) {
        parkingLotList = new ArrayList<>();
        for (Integer maxSize : maxSizeArr) {
            parkingLotList.add(new ParkingLot(maxSize));
        }
    }

    public void printParkingLotList() {
        int index = 1;
        for (ParkingLot parkingLot : parkingLotList) {
            System.out.printf("No %d parkingLot has %d car , maxSize is %d\n",
                    index++, parkingLot.getParkingLotSet().size(), parkingLot.getMaxSize());
        }
        System.out.println("=================");
    }

    public Ticket parkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        if (car == null || token == null)
            return null;
        Integer parkingLotIndex = 1;
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.haveSpaceLot()) {
                if (parkingLot.parkLotSetInACar(car)) {
                    return new Ticket(car, token, parkingLotIndex);
                } else {
                    errTicket.setErrMsg("This car has been parked");
                    return errTicket;
                }
            }
            parkingLotIndex++;
        }
        //loop in last parkingLot ,but not have parking space
        errTicket.setErrMsg("Not enough position.");
        return errTicket;
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
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.parkLotSetOutACar(car)) {
                ticket.setUsed(true);
                return car;
            }
        }
        // all of ParkingLot can't find this car
        errorCar.setErrMsg("This car has been stolen");
        return errorCar;
    }


}
