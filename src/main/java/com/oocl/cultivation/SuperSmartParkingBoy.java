package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy{


    public SuperSmartParkingBoy(Integer[] maxSizeArr) {
        super(maxSizeArr);
    }
    @Override
    public Ticket parkCar(Car car, String token) {
        Ticket errTicket = new Ticket();
        // Set<Car> parkingLotSet = parkingLot.getParkingLotSet();
        if (car == null || token == null)
            return null;
        int maxSpaceParkingLotIndex = getMaxEmptyRateParkingLotIndex();
        if (maxSpaceParkingLotIndex == -1) {
            errTicket.setErrMsg("Not enough position.");
        } else {
            ParkingLot parkingLotItem = parkingLotList.get(maxSpaceParkingLotIndex);
            parkingLotItem.parkLotSetInACar(car);
            return new Ticket(car, token, maxSpaceParkingLotIndex + 1);
        }
        return null;
    }

    private Integer getMaxEmptyRateParkingLotIndex() {
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
