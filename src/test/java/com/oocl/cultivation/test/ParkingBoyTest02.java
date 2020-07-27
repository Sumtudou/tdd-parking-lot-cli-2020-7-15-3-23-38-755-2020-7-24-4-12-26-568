package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.exception.NoEnoughPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest02 {

    @Test
    void should_return_error_mssage_when_getCar_given_wrong_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new Integer[]{10});
        Ticket ticket = parkingBoy.parkCar(car);
        Ticket wrongTicket = new Ticket();
        //when
        Car getsCar = parkingBoy.fetchCar(wrongTicket);
        //then
        assertEquals("Unrecognized parking ticket.", getsCar.getErrMsg());
    }
    @Test
    void should_return_error_mssage_when_getCar_given_used_ticket() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new Integer[]{10});
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car getsCar = parkingBoy.fetchCar(ticket);
        Car getsAgainCar = parkingBoy.fetchCar(ticket);

        //then
        assertEquals("Unrecognized parking ticket.", getsAgainCar.getErrMsg());
    }

    @Test
    void should_return_give_me_ticket_when_getCar_given_null() throws Exception {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new Integer[]{10});
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car getsCar = parkingBoy.fetchCar(null);

        //then
        assertEquals("Please provide your parking ticket.", getsCar.getErrMsg());
    }

    @Test
    void should_throw_not_enough_position_exception_when_parkCar_given_parking_is_full() throws Exception {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        Car car11 = new Car();

        ParkingBoy parkingBoy = new ParkingBoy(new Integer[]{10});
        //when
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);
        Ticket ticket3 = parkingBoy.parkCar(car3);
        Ticket ticket4 = parkingBoy.parkCar(car4);
        Ticket ticket5 = parkingBoy.parkCar(car5);
        Ticket ticket6 = parkingBoy.parkCar(car6);
        Ticket ticket7 = parkingBoy.parkCar(car7);
        Ticket ticket8 = parkingBoy.parkCar(car8);
        Ticket ticket9 = parkingBoy.parkCar(car9);
        Ticket ticket10 = parkingBoy.parkCar(car10);

        //then
        assertThrows(Exception.class, () -> parkingBoy.parkCar(new Car()));
        //assertThrows(NoEnoughPositionException.class, () -> parkingBoy.parkCar(new Car()));
    }



}
