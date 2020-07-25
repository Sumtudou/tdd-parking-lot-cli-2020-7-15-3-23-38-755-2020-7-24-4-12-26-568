package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingBoy {

    private ParkingLot parkingLot = null;
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(Integer maxSize) {
        buildParkingLot(maxSize);
    }

    public ParkingBoy(Integer[] maxSizeArr) {
        parkingLotList = new ArrayList<>();
        for (Integer maxSize : maxSizeArr) {
            parkingLotList.add(new ParkingLot(maxSize));
        }
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void printParkingLotList() {
        int index = 1;
        for(ParkingLot parkingLot:parkingLotList){
            System.out.printf("No %d parkingLot has %d car , maxSize is %d\n",
                index++,parkingLot.getParkingLotSet().size(),parkingLot.getMaxSize());
        }
        System.out.println("=================");
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingLot buildParkingLot(Integer maxSize) {
        this.parkingLot = new ParkingLot(maxSize);
        return parkingLot;
    }

    public Ticket notCleverParkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        // Set<Car> parkingLotSet = parkingLot.getParkingLotSet();
        if (car == null || token == null)
            return null;
        Integer parkingLotIndex = 1;
        for (ParkingLot parkingLot : parkingLotList) {
            //every ParkingLot's space SetItem
            Set<Car> parkingLotSetItem = parkingLot.getParkingLotSet();
            if (parkingLotSetItem.size() < parkingLot.getMaxSize()) {
                if (!parkingLotSetItem.contains(car)) {
                    parkingLotSetItem.add(car);
                    parkingLot.setParkingLotSet(parkingLotSetItem);
                    return new Ticket(car, token, parkingLotIndex);
                } else {
                    errTicket.setErrMsg("This car has been parked");
                    return errTicket;
                }
            }
            //loop in last parkingLot ,but not have parking space
            if (parkingLotIndex == parkingLotList.size()) {
                errTicket.setErrMsg("Not enough position.");
                return errTicket;
            }
            parkingLotIndex++;

        }
        return null;
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
        } else {
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
