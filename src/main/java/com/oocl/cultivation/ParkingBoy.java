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
        int bestParkingLotIndex = getBestParkigLotIndex();
        if (bestParkingLotIndex == -1) {
            errTicket.setErrMsg("Not enough position.");
            return errTicket;
        } else {
            ParkingLot parkingLotItem = parkingLotList.get(bestParkingLotIndex);
            parkingLotItem.parkLotSetInACar(car);
            return new Ticket(car, token, bestParkingLotIndex + 1);
        }
    }

    public int getBestParkigLotIndex() {
        for (int i = 0; i < parkingLotList.size(); i++) {
            if(parkingLotList.get(i).haveSpaceLot()){
                return i;
            }
        }
        return -1; // all of parkingLot  don't have park space
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
