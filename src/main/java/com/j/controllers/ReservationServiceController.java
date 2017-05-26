package com.j.controllers;

import com.j.business.domain.RoomReservation;
import com.j.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by J on 5/25/2017.
 */

@RestController
@RequestMapping(value = "/api")
public class ReservationServiceController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    public List<RoomReservation> getAllReservationsForDate(@PathVariable(value = "date") String dateString) {
        return this.reservationService.getRoomReservationsForDate(dateString);
    }
}
