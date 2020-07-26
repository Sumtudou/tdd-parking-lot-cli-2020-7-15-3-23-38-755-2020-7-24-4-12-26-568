package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest03 {

    @Test
    void should_return_parkingLotsId_when_parkCar_given_car() {
        //given
        Integer[] parkingLotMaxSizeArr = {3, 2};
        ParkingBoy notCleverParkingBoy = new ParkingBoy(parkingLotMaxSizeArr);
        Car car1 = new Car("C001");
        Car car2 = new Car("C002");
        Car car3 = new Car("C003");
        Car car4 = new Car("C004");
        Car car5 = new Car("C005");
        Car car6 = new Car("C006");
        //when
        Ticket ticket1 = notCleverParkingBoy.parkCar(car1,"T001");
        Ticket ticket2 = notCleverParkingBoy.parkCar(car2,"T002");
        Ticket ticket3 = notCleverParkingBoy.parkCar(car3,"T003");
        Ticket ticket4 = notCleverParkingBoy.parkCar(car4,"T004");
        Ticket ticket5 = notCleverParkingBoy.parkCar(car5,"T005");
        Ticket ticket6 = notCleverParkingBoy.parkCar(car6,"T006");
        //then

        assertEquals(1, ticket1.getParkingLotId());
        assertEquals(2, ticket4.getParkingLotId());
        assertEquals(null, ticket6.getParkingLotId());

    }


}
