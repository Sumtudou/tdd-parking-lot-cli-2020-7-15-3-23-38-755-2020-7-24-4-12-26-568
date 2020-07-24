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
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkCar(car,"T001");
        Car getsCar = parkingBoy.getCar(ticket);

        assertEquals(getsCar, car);
    }
}
