package com.oocl.cultivation;

import java.util.Comparator;
import java.util.Set;

public class SmartParkingBoy extends ParkingBoy {


    public SmartParkingBoy(Integer[] maxSizeArr) {
        super(maxSizeArr);
    }

    @Override
    public Ticket parkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        if (car == null || token == null)
            return null;
        int maxSpaceParkingLotIndex = getMaxEmptyParkingLotIndex();
        if (maxSpaceParkingLotIndex == -1) {
            errTicket.setErrMsg("Not enough position.");
        } else {
            ParkingLot parkingLotItem = parkingLotList.get(maxSpaceParkingLotIndex);
            parkingLotItem.parkLotSetInACar(car);
            return new Ticket(car, token, maxSpaceParkingLotIndex + 1);
        }
        return null;
    }

    private Integer getMaxEmptyParkingLotIndex() {
        int maxSpaceNum = -1;
        int index = -1;
        for (int i = 0; i < parkingLotList.size(); i++) {
            int currentSize = parkingLotList.get(i).getMaxSize() - parkingLotList.get(i).getParkingLotSet().size();
            if (currentSize > maxSpaceNum) {
                index = i;
                maxSpaceNum = currentSize;
            }
        }
        if (maxSpaceNum == 0)
            return -1;
        return index;
    }

}
