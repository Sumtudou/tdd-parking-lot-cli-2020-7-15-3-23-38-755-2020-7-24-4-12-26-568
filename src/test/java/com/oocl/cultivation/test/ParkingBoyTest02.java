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

class ParkingBoyTest02 {

    @Test
    void should_return_error_mssage_when_getCar_given_wrong_ticket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        Ticket wrongTicket = new Ticket();
        //when
        Car getsCar = parkingBoy.getOutCar(wrongTicket);
        //then
        assertEquals("Unrecognized parking ticket.", getsCar.getErrorMsg());
    }
    @Test
    void should_return_error_mssage_when_getCar_given_used_ticket() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        //when
        Car getsCar = parkingBoy.getOutCar(ticket);
        Car getsAgainCar = parkingBoy.getOutCar(ticket);

        //then
        assertEquals("Unrecognized parking ticket.", getsAgainCar.getErrorMsg());
    }

    @Test
    void should_return_give_me_ticket_when_getCar_given_null() {
        //given
        Car car = new Car("C001");
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        //when
        Car getsCar = parkingBoy.getOutCar(null);

        //then
        assertEquals("Please provide your parking ticket.", getsCar.getErrorMsg());
    }



}
