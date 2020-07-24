package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Car;
import com.oocl.cultivation.Ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

    @Test
    void should_return_ticket_when_parkCar_given_1car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.parkCar(car);

        //then
        assertNotNull(ticket);
    }


//    @Test
//    void should_return_car_when_getCar_given_ticket() {
//
//        ParkingBoy parkingBoy = new ParkingBoy();
//        Ticket ticket = new Ticket();
//        Car ticketCar = ticket.getCar();
//
//        Car car = parkingBoy.getCar(ticket);
//
//        assertEquals(ticketCar, car);
//    }
}
