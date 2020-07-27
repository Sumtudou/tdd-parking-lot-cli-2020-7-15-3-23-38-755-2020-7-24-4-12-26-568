//package com.oocl.cultivation.test;
//
//import com.oocl.cultivation.*;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//class ParkingBoyTest03 {
//
//    @Test
//    void should_return_parkingLotsId_when_parkCar_given_car() {
//        //given
//        Integer[] parkingLotMaxSizeArr = {3, 2};
//        ParkingBoy notCleverParkingBoy = new ParkingBoy(parkingLotMaxSizeArr);
//        Car car1 = new Car();
//        Car car2 = new Car();
//        Car car3 = new Car();
//        Car car4 = new Car();
//        Car car5 = new Car();
//        Car car6 = new Car();
//        //when
//        Ticket ticket1 = notCleverParkingBoy.parkCar(car1);
//        Ticket ticket2 = notCleverParkingBoy.parkCar(car2);
//        Ticket ticket3 = notCleverParkingBoy.parkCar(car3);
//        Ticket ticket4 = notCleverParkingBoy.parkCar(car4);
//        Ticket ticket5 = notCleverParkingBoy.parkCar(car5);
//        Ticket ticket6 = notCleverParkingBoy.parkCar(car6);
//        //then
//
//        assertEquals(1, ticket1.getParkingLotId());
//        assertEquals(2, ticket4.getParkingLotId());
//        assertEquals(null, ticket6.getParkingLotId());
//
//    }
//
//
//}
