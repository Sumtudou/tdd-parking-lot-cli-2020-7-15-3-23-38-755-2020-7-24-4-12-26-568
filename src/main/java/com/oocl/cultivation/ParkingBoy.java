package com.oocl.cultivation;

import com.oocl.cultivation.exception.NoEnoughPositionException;

import java.lang.reflect.Array;
import java.util.*;

public class ParkingBoy extends Exception{
    //private ParkingLot parkingLot = null;
    protected List<ParkingLot> parkingLotList;
    private final String Not_Enough_Position = "Not enough position.";


    // TODO Dynamic increase of parking lot
    public ParkingBoy(Integer[] maxSizeArr) {
        parkingLotList = new ArrayList<>();
        for (Integer maxSize : maxSizeArr) {
            parkingLotList.add(new ParkingLot(maxSize));
        }
    }

    public void printParkingLotList() {
        int index = 1;
        for (ParkingLot parkingLot : parkingLotList) {
            System.out.printf("No. %d parkingLot has %d car , maxSize is %d\n",
                    index++, parkingLot.getParkingLotSet().size(), parkingLot.getMaxSize());
        }
        System.out.println("=================");
    }

    public Ticket parkCar(Car car) throws Exception {
        Ticket errTicket = new Ticket();
        if (car == null)
            return null;
        int bestParkingLotIndex = getBestParkigLotIndex();  // TODO rename it

//        try {
//            int result = numA/numB;
//        }catch (ArithmeticException e){
//            throw new Exception("The numB not allowed to '0'!!");
//        }

        if (bestParkingLotIndex == -1) {
            throw new NoEnoughPositionException();
            // errTicket.setErrMsg(Not_Enough_Position);
           //return errTicket;
        } else {
            ParkingLot parkingLotItem = parkingLotList.get(bestParkingLotIndex);
            parkingLotItem.parkLotSetInACar(car);
            return new Ticket(car,  bestParkingLotIndex + 1);
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

    public Car fetchCar(Ticket ticket) {
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
