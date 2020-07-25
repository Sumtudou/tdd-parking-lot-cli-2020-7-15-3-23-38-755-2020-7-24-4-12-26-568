package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest05 {

    @Test
    void should_return_parkingLotsId_when_SuperSmartParkCar_given_car() {
        //given
        Integer[] parkingLotMaxSizeArr = {3, 10, 5};
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotMaxSizeArr);
        Car car1 = new Car("C001");
        Car car2 = new Car("C002");
        Car car3 = new Car("C003");
        Car car4 = new Car("C004");
        Car car5 = new Car("C005");
        Car car6 = new Car("C006");
        //when
        Ticket ticket1 = superSmartParkingBoy.smartParkCar(car1, "T001");
        superSmartParkingBoy.printParkingLotList();

        Ticket ticket2 = superSmartParkingBoy.smartParkCar(car2, "T002");
        superSmartParkingBoy.printParkingLotList();

        Ticket ticket3 = superSmartParkingBoy.smartParkCar(car3, "T003");
        superSmartParkingBoy.printParkingLotList();

        Ticket ticket4 = superSmartParkingBoy.smartParkCar(car4, "T004");
        Ticket ticket5 = superSmartParkingBoy.smartParkCar(car5, "T005");
        Ticket ticket6 = superSmartParkingBoy.smartParkCar(car6, "T006");
        //then

        assertEquals(1, ticket1.getParkingLotId());
        assertEquals(2, ticket2.getParkingLotId());
        assertEquals(3, ticket3.getParkingLotId());
        assertEquals(2, ticket4.getParkingLotId());

    }


}
