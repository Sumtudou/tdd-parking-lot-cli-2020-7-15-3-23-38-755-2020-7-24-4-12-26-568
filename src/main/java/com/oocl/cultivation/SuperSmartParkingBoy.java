package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(Integer maxSize) {
        super(maxSize);
    }

    public SuperSmartParkingBoy(Integer[] maxSizeArr) {
        super(maxSizeArr);
    }

    public Ticket smartParkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        // Set<Car> parkingLotSet = parkingLot.getParkingLotSet();
        if (car == null || token == null)
            return null;
        int maxSpaceParkingLotIndex = getMaxEmptyRateParkingLotIndex();
        if (maxSpaceParkingLotIndex == -1) {
            errTicket.setErrMsg("Not enough position.");
        } else {
            ParkingLot parkingLotItem = parkingLotList.get(maxSpaceParkingLotIndex);
            parkingLotItem.getParkingLotSet().add(car);
            parkingLotItem.setParkingLotSet(parkingLotItem.getParkingLotSet());
            return new Ticket(car, token, maxSpaceParkingLotIndex + 1);
        }
        return null;
    }

    public Integer getMaxEmptyRateParkingLotIndex() {
        double maxSpaceNumRate = -1;
        int index = -1;
        for (int i = 0; i < parkingLotList.size(); i++) {
            double currentSizeRate = 1 - (double)parkingLotList.get(i).getParkingLotSet().size()/parkingLotList.get(i).getMaxSize();
            //System.out.printf("%d   %f\n",i,currentSizeRate);
            if (currentSizeRate > maxSpaceNumRate) {
                index = i;
                maxSpaceNumRate = currentSizeRate;
            }
        }
        if (Math.abs(maxSpaceNumRate)< 0.001)
            return -1;
        return index;
    }
}
