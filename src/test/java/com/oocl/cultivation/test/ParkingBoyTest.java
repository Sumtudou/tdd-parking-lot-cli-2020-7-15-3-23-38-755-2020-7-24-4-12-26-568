package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parkCar_given_1car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Car car = new Car("C001");
        //when
        Ticket ticket = parkingBoy.parkCar(car,"T001");

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_getCar_given_ticket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket ticket = parkingBoy.parkCar(car,"T001");

        //when
        Car getsCar = parkingBoy.getOutCar(ticket);
        //then
        assertEquals(getsCar, car);
    }

    @Test
    void should_return_null_when_getOutCar_given_wrong_ticket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        //when
        Ticket ticket = new Ticket();

        Car gotCar = parkingBoy.getOutCar(ticket);

        //then
        assertEquals(null, gotCar);
    }

    @Test
    void should_return_null_when_getOutCar_given_used_ticket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        //when

        Car gotCar = parkingBoy.getOutCar(ticket);
        Car gotAgainCar = parkingBoy.getOutCar(ticket);

        //then
        assertEquals(null, gotAgainCar);
    }

    @Test
    void should_return_null_when_getOutCar_given_usedTicket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        //when
        Ticket ticket = new Ticket();

        Car gotCar = parkingBoy.getOutCar(null);

        //then
        assertEquals(null, gotCar);
    }

    @Test
    void should_return_null_when_parkCar_given_parking_is_full() {
        //given
        Car car1 = new Car("C001");
        Car car2 = new Car("C002");
        Car car3 = new Car("C003");
        Car car4 = new Car("C004");
        Car car5 = new Car("C005");
        Car car6 = new Car("C006");
        Car car7 = new Car("C007");
        Car car8 = new Car("C008");
        Car car9 = new Car("C009");
        Car car10 = new Car("C010");
        Car car11 = new Car("C011");

        ParkingBoy parkingBoy = new ParkingBoy(10);
        //when
        Ticket ticket1 = parkingBoy.parkCar(car1,"T001");
        Ticket ticket2 = parkingBoy.parkCar(car2,"T002");
        Ticket ticket3 = parkingBoy.parkCar(car3,"T003");
        Ticket ticket4 = parkingBoy.parkCar(car4,"T004");
        Ticket ticket5 = parkingBoy.parkCar(car5,"T005");
        Ticket ticket6 = parkingBoy.parkCar(car6,"T006");
        Ticket ticket7 = parkingBoy.parkCar(car7,"T007");
        Ticket ticket8 = parkingBoy.parkCar(car8,"T008");
        Ticket ticket9 = parkingBoy.parkCar(car9,"T009");
        Ticket ticket10 = parkingBoy.parkCar(car10,"T010");
        Ticket ticket11 = parkingBoy.parkCar(car11,"T011");

        //then
        assertNotNull(ticket10);
        assertEquals(null, ticket11);
    }

    @Test
    void should_return_null_when_parkCar_given_parked_car() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        //when
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        Ticket ticket1 = parkingBoy.parkCar(car,"T001");

        //then
        assertEquals(null, ticket1);
    }

    @Test
    void should_return_null_when_parkCar_null_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        //when
        Ticket ticket = parkingBoy.parkCar(null,"T001");

        //then
        assertEquals(null, ticket);
    }



}
