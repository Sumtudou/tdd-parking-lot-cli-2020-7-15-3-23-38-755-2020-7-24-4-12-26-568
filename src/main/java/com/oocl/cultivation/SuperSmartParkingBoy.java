package com.oocl.cultivation;

public class SuperSmartParkingBoy extends ParkingBoy {


    public SuperSmartParkingBoy(Integer[] maxSizeArr) {
        super(maxSizeArr);
    }

    @Override
    public int getBestParkigLotIndex() {
        double maxSpaceNumRate = -1;
        int index = -1;
        for (int i = 0; i < parkingLotList.size(); i++) {
            double currentSizeRate = 1 - (double) parkingLotList.get(i).getParkingLotSet().size() / parkingLotList.get(i).getMaxSize();
            //System.out.printf("%d   %f\n",i,currentSizeRate);
            if (currentSizeRate > maxSpaceNumRate) {
                index = i;
                maxSpaceNumRate = currentSizeRate;
            }
        }
        if (Math.abs(maxSpaceNumRate) < 0.001)
            return -1;
        return index;
    }
}
